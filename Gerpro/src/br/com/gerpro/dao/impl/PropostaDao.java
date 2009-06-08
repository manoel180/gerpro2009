package br.com.gerpro.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

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
	@Override
	public void salvar(Proposta proposta) {
		// TODO Auto-generated method stub

		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(proposta);
			tx.commit();
			System.out.println("Alteração realizada com sucesso");
		} catch (HibernateException e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Erro",
					"GerPro - Ocorreu um erro" + e, 1);
			e.printStackTrace();
		} catch (PersistenceException e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Erro",
					"GerPro - Ocorreu um erro" + e, 1);
			e.printStackTrace();
		} catch (Exception e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Erro",
					"GerPro - Ocorreu um erro" + e, 1);
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
	@SuppressWarnings("unchecked")
	@Override
	public List<Proposta> listar() {

		List<Proposta> result = null;

		Session session = HibernateUtil.getSession();

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
	@SuppressWarnings("unchecked")
	@Override
	public List<Proposta> listarPorProfessor(Usuario professor) {

		List<Proposta> result = null;

		Session session = HibernateUtil.getSession();

		// Funcionando mas duplicando linhas
		result = session.createSQLQuery(
				" select *" + " from proposta p"
						+ " inner join correcao co on co.id_proposta = p.id"
						+ " where co.matricula_professor like ? ").addEntity(
				Proposta.class).setParameter(0, professor.getMatricula())
				.list();

		session.close();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadeProposta#listarPorNome(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Proposta> listarPorNome(String nomeProposta) {
		// TODO Auto-generated method stub
		List<Proposta> result = null;

		Session session = HibernateUtil.getSession();

		Query q = session
				.createQuery("from Proposta where Nome like  :parametro");

		q.setParameter("parametro", nomeProposta + "%");

		result = q.list();

		for (Proposta proposta : result) {
			proposta.getEquipe().getNome();

		}
		session.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proposta> listarPorEquipe(String nomeEquipe) {
		List<Proposta> result = null;

		Session session = HibernateUtil.getSession();

		// Funcionando mas duplicando linhas
		result = session.createQuery(
				"from Proposta as proposta" + " where proposta.equipe.nome "
						+ "like '" + nomeEquipe + "%'").list();
		// q.setParameter("parametro", nomeEquipe + "%");

		session.close();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadeProposta#procurarPorId(int)
	 */
	@Override
	public Proposta procurarPorId(int id) {
		// TODO Auto-generated method stub

		Proposta result = null;

		Session session = HibernateUtil.getSession();
		result = (Proposta) session.get(Proposta.class, id);

		session.close();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadeProposta#procurarPorNome(java.lang.String)
	 */
	@Override
	public Proposta procurarPorNome(String Nome) {
		// TODO Auto-generated method stub

		Proposta result = null;

		Session session = HibernateUtil.getSession();
		result = (Proposta) session.get(Proposta.class, Nome);
		if (result == null) {
			System.out.println("Proposta não encontrada");
		}
		session.close();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadeProposta#remover(br.com.gerpro.model.Proposta)
	 */
	@Override
	public void remover(Proposta proposta) {

		try {
			session = null;
			tx = null;
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(proposta);
			tx.commit();
			System.out.println("Proposta excluida com sucesso");
		} catch (HibernateException e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Erro" + e,
					"GerPro - Ocorreu um erro", 1);
			e.printStackTrace();
		} catch (PersistenceException e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Erro" + e,
					"GerPro - Ocorreu um erro", 1);
			e.printStackTrace();
		} catch (Exception e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Erro" + e,
					"GerPro - Ocorreu um erro", 1);
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
	@SuppressWarnings("unchecked")
	public List listarPropostasConcluidas() {

		Session session = HibernateUtil.getSession();

		List result = session.createQuery(
				" from Proposta as proposta" + " where proposta.status.id = 6")
				.list();

		session.close();
		return result;
	}

}