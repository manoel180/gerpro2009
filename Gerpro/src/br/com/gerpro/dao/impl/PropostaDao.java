package br.com.gerpro.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.util.HibernateUtil;

public class PropostaDao implements FacadeProposta {

	private static Session session = null;
	private static Transaction tx = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadeProposta#salvar(br.com.gerpro.model.Proposta)
	 */

	public void salvar(Proposta proposta) {

		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(proposta);
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
		} finally {
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadeProposta#listar()
	 */
	public List<Proposta> listar() {

		List<Proposta> result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery(" from Proposta ");

		result = q.list();

		session.close();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadeProposta#listarPorProfessor(br.com.gerpro.model.Usuario)
	 */
	public List<Proposta> listarPorProfessor(Usuario professor) {

		List<Proposta> result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		// Funcionando mas duplicando linhas
		result = session.createSQLQuery(
				" select *" + " from proposta p"
						+ " inner join correcao co on co.id_proposta = p.id"
						+ " where co.matricula_professor like ? "
						+ " group by p.id ").addEntity(Proposta.class)
				.setParameter(0, professor.getMatricula()).list();

		session.close();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadeProposta#listarPorNome(java.lang.String)
	 */
	public List<Proposta> listarPorNome(String nomeProposta) {
		// TODO Auto-generated method stub
		List<Proposta> result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		Query q = session
				.createQuery("from Proposta where Nome like  :parametro");

		q.setParameter("parametro", nomeProposta + "%");

		result = q.list();

		session.close();
		return result;
	}

	public List<Proposta> listarPorEquipe(String nomeEquipe) {
		List<Proposta> result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		// Funcionando mas duplicando linhas
		result = session.createQuery(
				"from Proposta as proposta" + " where proposta.equipe.nome "
						+ "like '" + nomeEquipe + "%'").list();

		session.close();
		return result;
	}

	public Proposta listarPorIdEquipe(int idEquipe) {
		Proposta result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		// Funcionando mas duplicando linhas
		result = (Proposta) session.createQuery(
				"from Proposta as proposta" + " where proposta.equipe.id" + "="
						+ idEquipe).uniqueResult();

		session.close();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadeProposta#procurarPorId(int)
	 */
	public Proposta procurarPorId(int id) {
		// TODO Auto-generated method stub

		Proposta result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		result = (Proposta) session.get(Proposta.class, id);

		session.close();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadeProposta#procurarPorId(int)
	 */
	public List<Proposta> listarPorPeriodo(String periodo) {
		// TODO Auto-generated method stub

		List<Proposta> result = null;
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();

		result = session
				.createQuery(
						"from Proposta as proposta where proposta.status.id = 3 or proposta.status.id = 4 or proposta.status.id = 5"
								+ " and proposta.periodo = '"
								+ periodo
								+ "' Group by proposta.id").list();
		tx.commit();
		session.close();

		return result;
	}

	public List<Proposta> listarPeriodo() {
		// TODO Auto-generated method stub

		List<Proposta> result = null;
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();

		result = session.createQuery(
				"from Proposta as proposta" + " Group by proposta.periodo")
				.list();

		session.close();

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadeProposta#procurarPorNome(java.lang.String)
	 */
	public Proposta procurarPorNome(String Nome) {

		Proposta result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		result = (Proposta) session.get(Proposta.class, Nome);
		session.close();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadeProposta#remover(br.com.gerpro.model.Proposta)
	 */
	public void remover(Proposta proposta) {

		try {
			session = null;
			tx = null;
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(proposta);
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
		} finally {
			session.close();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadeProposta#listarPropostasConcluidas()
	 */
	public List listarPropostasConcluidas() {

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		List result = session.createQuery(
				" from Proposta as proposta" +
				" where proposta.status.id = 6")
				.list();

		session.close();
		return result;
	}

}