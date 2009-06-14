package br.com.gerpro.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.dao.FacadePergunta;
import br.com.gerpro.model.Pergunta;
import br.com.gerpro.util.HibernateUtil;

public class PerguntaDao implements FacadePergunta {

	private static Session session = null;
	private static Transaction tx = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadePergunta#salvar(br.com.gerpro.model.Pergunta)
	 */
	@Override
	public void salvar(Pergunta pergunta) {
		// TODO Auto-generated method stub

		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(pergunta);
			tx.commit();
			System.out.println("Altera��o realizada com sucesso");
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
	 * @see br.com.gerpro.dao.impl.FacadePergunta#listar()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Pergunta> listar() {

		List<Pergunta> result = null;
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery(" from Pergunta ");

		result = q.list();

		session.close();
		return result;
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadePergunta#listarPorNome(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Pergunta> listarPorNome(String nomePergunta) {
		// TODO Auto-generated method stub
		List<Pergunta> result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		Query q = session
				.createQuery("from Pergunta where Nome like  :parametro");

		q.setParameter("parametro", nomePergunta + "%");

		result = q.list();
		session.close();
		return result;
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadePergunta#procurarPorId(int)
	 */
	@Override
	public Pergunta procurarPorId(int id) {
		// TODO Auto-generated method stub

		Pergunta result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		result = (Pergunta) session.get(Pergunta.class, id);

		session.close();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadePergunta#procurarPorNome(java.lang.String)
	 */
	@Override
	public Pergunta procurarPorNome(String Nome) {
		// TODO Auto-generated method stub

		Pergunta result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		result = (Pergunta) session.get(Pergunta.class, Nome);
		if (result == null) {
			System.out.println("Pergunta n�o encontrada");
		}
		session.close();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.impl.FacadePergunta#remover(br.com.gerpro.model.Pergunta)
	 */
	@Override
	public void remover(Pergunta pergunta) {

		try {
			session = null;
			tx = null;
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(pergunta);
			tx.commit();
			System.out.println("Pergunta excluida com sucesso");
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

	/* (non-Javadoc)
	 * @see br.com.gerpro.dao.FacadePergunta#listarPorItem(int)
	 */
	@Override
	public List<Pergunta> listarPorItem(int id) {
		// TODO Auto-generated method stub
		List<Pergunta> result = null;
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		
		result = session.createQuery(
				"from Pergunta as pergunta where pergunta.item.id = "+id).list();

		session.close();
	
		return result;
		
	}

}