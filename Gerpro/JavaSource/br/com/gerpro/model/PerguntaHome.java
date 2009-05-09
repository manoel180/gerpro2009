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
 * Home object for domain model class Pergunta.
 * @see .Pergunta
 * @author Hibernate Tools
 */
public class PerguntaHome {

	private static final Log log = LogFactory.getLog(PerguntaHome.class);

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

	public void persist(Pergunta transientInstance) {
		log.debug("persisting Pergunta instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Pergunta instance) {
		log.debug("attaching dirty Pergunta instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pergunta instance) {
		log.debug("attaching clean Pergunta instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Pergunta persistentInstance) {
		log.debug("deleting Pergunta instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pergunta merge(Pergunta detachedInstance) {
		log.debug("merging Pergunta instance");
		try {
			Pergunta result = (Pergunta) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Pergunta findById(java.lang.Integer id) {
		log.debug("getting Pergunta instance with id: " + id);
		try {
			Pergunta instance = (Pergunta) sessionFactory.getCurrentSession()
					.get("Pergunta", id);
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

	public List<Pergunta> findByExample(Pergunta instance) {
		log.debug("finding Pergunta instance by example");
		try {
			List<Pergunta> results = (List<Pergunta>) sessionFactory
					.getCurrentSession().createCriteria("Pergunta").add(
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
