package br.com.gerpro.dao.impl;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.dao.FacadeCronograma;
import br.com.gerpro.model.Cronograma;
import br.com.gerpro.util.HibernateUtil;



public class CronogramaDao implements FacadeCronograma {

	
	private static	Session session = null;
	private static Transaction tx = null;
	
	@Override
	public void salvar(Cronograma cronograma) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(cronograma);
			//session.saveOrUpdate(cronograma);
			tx.commit();
			JOptionPane.showMessageDialog(null, "Operação Realizada com sucesso");
		} catch (Exception e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	
	@Override
	public List<Cronograma> listar() {

		List<Cronograma> result = null;
		
		session = HibernateUtil.getSession();
		
		Query q = session.createQuery(" from Cronograma ");
		
		result = q.list();
		
		session.close();
		return result;
	}
		
		
	@Override	
	public List<Cronograma> listarPorNome(String nomecronograma) {
		// TODO Auto-generated method stub
		List<Cronograma> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery("from Cronograma where Nome like  :parametro");
		q.setParameter("parametro", nomecronograma+"%");
		
		result = q.list();
		
		session.close();
		return result;
	}

	   

	@Override
	public List<Cronograma> procurarPorId(int idProposta, int idItem) {
		// TODO Auto-generated method stub
		List<Cronograma> result = null;
		
		session = HibernateUtil.getSession();
		tx = session.beginTransaction(); 
		Query q = session.createQuery("from Cronograma where id_proposta = :idProposta and " +
				"id_item = :idItem");
		q.setParameter("idProposta", idProposta);
		q.setParameter("idItem", idItem);
		
		result = q.list();
		session.close();
		return result;
	}

	@Override
	public Cronograma procurarPorNome(String Nome) {
		// TODO Auto-generated method stub

		Cronograma result = null;

		session = HibernateUtil.getSession();
		result = (Cronograma) session.get(Cronograma.class, Nome);
		if (result == null) {
			JOptionPane.showMessageDialog(null, "Não encontrado");
		}
		session.close();
		return result;
	}
	
	@Override
	public  void remover(Cronograma cronograma) {

		try {
			session=null;
			tx = null;
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(cronograma);
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