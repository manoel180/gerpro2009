package br.com.gerpro.model;
// Generated 29/04/2009 19:29:50 by Hibernate Tools 3.2.2.GA

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class ListaFuncao.
 * @see .ListaFuncao
 * @author Hibernate Tools
 */
public class ListaFuncaoHome {

	private static final Log log = LogFactory.getLog(ListaFuncaoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(ListaFuncao transientInstance) {
		log.debug("persisting ListaFuncao instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ListaFuncao instance) {
		log.debug("attaching dirty ListaFuncao instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ListaFuncao instance) {
		log.debug("attaching clean ListaFuncao instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ListaFuncao persistentInstance) {
		log.debug("deleting ListaFuncao instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ListaFuncao merge(ListaFuncao detachedInstance) {
		log.debug("merging ListaFuncao instance");
		try {
			ListaFuncao result = (ListaFuncao) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ListaFuncao findById(ListaFuncaoId id) {
		log.debug("getting ListaFuncao instance with id: " + id);
		try {
			ListaFuncao instance = (ListaFuncao) sessionFactory
					.getCurrentSession().get("ListaFuncao", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ListaFuncao> findByExample(ListaFuncao instance) {
		log.debug("finding ListaFuncao instance by example");
		try {
			List<ListaFuncao> results = (List<ListaFuncao>) sessionFactory
					.getCurrentSession().createCriteria("ListaFuncao").add(
							create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
