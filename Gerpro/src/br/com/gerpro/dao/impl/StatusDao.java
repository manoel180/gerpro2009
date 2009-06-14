package br.com.gerpro.dao.impl;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.dao.FacadeStatus;
import br.com.gerpro.model.Status;
import br.com.gerpro.util.HibernateUtil;



public class StatusDao implements FacadeStatus {

	
	private static	Session session = null;
	private static Transaction tx = null;
	
	@Override
	public void salvar(Status equipe) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(equipe);
			tx.commit();
			JOptionPane.showMessageDialog(null, "Alteração Realizada com sucesso");
		} catch (Exception e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Status> listar() {

		List<Status> result = null;
		
		session = HibernateUtil.getSession();
		
		Query q = session.createQuery(" from Status ");
		
		result = q.list();
		
		session.close();
		return result;
	}

	
	@Override	
	public List<Status> listarPorNome(String nomeEquippe) {
		// TODO Auto-generated method stub
		List<Status> result = null;
		
		session = HibernateUtil.getSession();
		
		Query q = session.createQuery("from Status where Nome like  :parametro");
		q.setParameter("parametro", nomeEquippe+"%");
		
		result = q.list();
		
		session.close();
		return result;
	}

	   

	@Override
	public  Status procurarPorId(int id) {
		// TODO Auto-generated method stub

		Status result = null;

		session = HibernateUtil.getSession();
		result = (Status) session.get(Status.class, id);
	
		session.close();
		return result;
	}

	@Override
	public Status procurarPorNome(String Nome) {
		// TODO Auto-generated method stub

		Status result = null;

		session = HibernateUtil.getSession();
		result = (Status) session.get(Status.class, Nome);
		if (result == null) {
			JOptionPane.showMessageDialog(null, "Não encontrado");
		}
		session.close();
		return result;
	}
	
	@Override
	public  void remover(Status status) {

		try {
			session=null;
			tx = null;
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(status);
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