/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.dao.impl;

import br.com.gerpro.dao.GenericDao;
import br.com.gerpro.finder.FinderArgumentTypeFactory;
import br.com.gerpro.finder.FinderExecutor;
import br.com.gerpro.finder.FinderNamingStrategy;
import br.com.gerpro.finder.impl.SimpleFinderArgumentTypeFactory;
import br.com.gerpro.finder.impl.SimpleFinderNamingStrategy;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author M2R
 */
public class HibernateGenericDao<T, PK extends Serializable> extends HibernateDaoSupport
        implements GenericDao<T, PK>, FinderExecutor {

    //private SessionFactory sessionFactory;
    private FinderNamingStrategy namingStrategy = new SimpleFinderNamingStrategy(); // Default. Can override in config
    private FinderArgumentTypeFactory argumentTypeFactory = new SimpleFinderArgumentTypeFactory(); // Default. Can override in config
    private Class<T> type;

    public HibernateGenericDao(Class<T> type) {
        this.type = type;
    }

    public PK create(T o) {
        return (PK) getHibernateTemplate().save(o);//getSession().save(o);
    }

    public T read(PK id) {
        return (T) getHibernateTemplate().get(type, id);//getSession().get(type, id);
    }

    public void update(T o) {
        getHibernateTemplate().update(o);//getSession().update(o);
    }

    public void delete(T o) {
        getHibernateTemplate().delete(o);//getSession().delete(o);
    }    

    public List<T> executeFinder(Method method, final Object[] queryArgs) {
        final Query namedQuery = prepareQuery(method, queryArgs);
        return (List<T>) namedQuery.list();
    }

    public Iterator<T> iterateFinder(Method method, final Object[] queryArgs) {
        final Query namedQuery = prepareQuery(method, queryArgs);
        return (Iterator<T>) namedQuery.iterate();
    }

//    public ScrollableResults scrollFinder(Method method, final Object[] queryArgs)
//    {
//        final Query namedQuery = prepareQuery(method, queryArgs);
//        return (ScrollableResults) namedQuery.scroll();
//    }
    private Query prepareQuery(Method method, Object[] queryArgs) {
        final String queryName = getNamingStrategy().queryNameFromMethod(type, method);
        final Query namedQuery = getSession().getNamedQuery(queryName);
        String[] namedParameters = namedQuery.getNamedParameters();
        if (namedParameters.length == 0) {
            setPositionalParams(queryArgs, namedQuery);
        } else {
            setNamedParams(namedParameters, queryArgs, namedQuery);
        }
        return namedQuery;
    }

    private void setPositionalParams(Object[] queryArgs, Query namedQuery) {
        // Set parameter. Use custom Hibernate Type if necessary
        if (queryArgs != null) {
            for (int i = 0; i < queryArgs.length; i++) {
                Object arg = queryArgs[i];
                Type argType = getArgumentTypeFactory().getArgumentType(arg);
                if (argType != null) {
                    namedQuery.setParameter(i, arg, argType);
                } else {
                    namedQuery.setParameter(i, arg);
                }
            }
        }
    }

    private void setNamedParams(String[] namedParameters, Object[] queryArgs, Query namedQuery) {
        // Set parameter. Use custom Hibernate Type if necessary
        if (queryArgs != null) {
            for (int i = 0; i < queryArgs.length; i++) {
                Object arg = queryArgs[i];
                Type argType = getArgumentTypeFactory().getArgumentType(arg);
                if (argType != null) {
                    namedQuery.setParameter(namedParameters[i], arg, argType);
                } else {
                    if (arg instanceof Collection) {
                        namedQuery.setParameterList(namedParameters[i], (Collection) arg);
                    } else {
                        namedQuery.setParameter(namedParameters[i], arg);
                    }
                }
            }
        }
    }
    /*public Session getSession()
    {
    boolean allowCreate = true;
    return SessionFactoryUtils.getSession(sessionFactory, allowCreate);
    }

    public void setSessionFactory(SessionFactory sessionFactory)
    {
    this.sessionFactory = sessionFactory;
    }*/

    public FinderNamingStrategy getNamingStrategy() {
        return namingStrategy;
    }

    public void setNamingStrategy(FinderNamingStrategy namingStrategy) {
        this.namingStrategy = namingStrategy;
    }

    public FinderArgumentTypeFactory getArgumentTypeFactory() {
        return argumentTypeFactory;
    }

    public void setArgumentTypeFactory(FinderArgumentTypeFactory argumentTypeFactory) {
        this.argumentTypeFactory = argumentTypeFactory;
    }
}