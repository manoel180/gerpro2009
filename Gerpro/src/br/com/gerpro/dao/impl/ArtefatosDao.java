package br.com.gerpro.dao.impl;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.dao.FacadeArtefatos;
import br.com.gerpro.model.Artefatos;
import br.com.gerpro.util.HibernateUtil;



public class ArtefatosDao implements FacadeArtefatos {

	
	private static	Session session = null;
	private static Transaction tx = null;
	
	//@Override
	public void salvar(Artefatos artefatos) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(artefatos);
			tx.commit();
			JOptionPane.showMessageDialog(null, "Alteração Realizada com sucesso");
		} catch (Exception e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	
	//@Override
	public List<Artefatos> listar() {

		List<Artefatos> result = null;
		
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery(" from Artefatos ");
		
		result = q.list();
		
		session.close();
		return result;
	}
		
			
	//@Override	
	public List<Artefatos> listarPorNome(String nomeArtefatos) {
		// TODO Auto-generated method stub
		List<Artefatos> result = null;
		
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery("from Artefatos where Nome like  :parametro");
		q.setParameter("parametro", nomeArtefatos+"%");
		
		result = q.list();
		
		session.close();
		return result;
	}

	   

	//@Override
	public  Artefatos procurarPorId(int id) {
		// TODO Auto-generated method stub

		Artefatos result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		result = (Artefatos) session.get(Artefatos.class, id);
	
		session.close();
		return result;
	}

	//@Override
	public Artefatos procurarPorNome(String Nome) {
		// TODO Auto-generated method stub

		Artefatos result = null;

		Session session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		result = (Artefatos) session.get(Artefatos.class, Nome);
		if (result == null) {
			JOptionPane.showMessageDialog(null, "Não encontrado");
		}
		session.close();
		return result;
	}
	
	public  void remover(Artefatos artefatos) {

		try {
			session=null;
			tx = null;
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(artefatos);
			tx.commit();
			JOptionPane.showMessageDialog(null, "Eliminado com sucesso");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu algum erro!");
		} finally {
			session.close();
		}
	}

}