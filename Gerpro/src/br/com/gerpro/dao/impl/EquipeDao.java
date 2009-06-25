package br.com.gerpro.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.dao.FacadeEquipe;
import br.com.gerpro.model.Equipe;
import br.com.gerpro.util.HibernateUtil;

public class EquipeDao implements FacadeEquipe {

	private static Session session = null;
	private static Transaction tx = null;

	public void salvar(Equipe equipe) {

		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(equipe);
			tx.commit();

		} catch (HibernateException e) {

			tx.rollback();

			e.printStackTrace();
		} catch (PersistenceException e) {

			tx.rollback();

			e.printStackTrace();
		} catch (Exception e) {
			tx.rollback();

			e.printStackTrace();
		}

		finally {
			session.close();
		}
	}


	public List<Equipe> listar() {

		List<Equipe> result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery(" from Equipe ");

		result = q.list();

		session.close();
		return result;
	}


	public List<Equipe> listarPorNome(String nomeEquippe) {

		List<Equipe> result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		Query q = session
				.createQuery("from Equipe where Nome like  :parametro");
		q.setParameter("parametro", nomeEquippe + "%");

		result = q.list();

		session.close();
		return result;
	}


	public Equipe procurarPorId(int id) {

		Equipe result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		result = (Equipe) session.get(Equipe.class, id);

		session.close();
		return result;
	}


	public Equipe procurarPorNome(String Nome) {
		// TODO Auto-generated method stub

		Equipe result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		result = (Equipe) session.get(Equipe.class, Nome);
		if (result == null) {

		}
		session.close();
		return result;
	}


	public void remover(Equipe equipe) {

		try {
			session = null;
			tx = null;
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(equipe);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
	}


	public List<Equipe> listarEquipesSemProposta() {
		

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		Query q = session.createSQLQuery(
				" select * from equipe e" + " where e.id not in"
						+ " (select id_equipe from proposta)").addEntity(
				Equipe.class);

		List<Equipe> result = q.list();

		session.close();
		return result;
	}

}