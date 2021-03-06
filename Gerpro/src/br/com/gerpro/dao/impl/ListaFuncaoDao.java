package br.com.gerpro.dao.impl;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.dao.FacadeListaFuncao;
import br.com.gerpro.model.ListaFuncao;
import br.com.gerpro.util.HibernateUtil;



public class ListaFuncaoDao implements FacadeListaFuncao {

	
	private static	Session session = null;
	private static Transaction tx = null;
	
	public void salvar(ListaFuncao listafuncao) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(listafuncao);
			//session.saveOrUpdate(listafuncao);
			tx.commit();		
		} catch (Exception e) {
			tx.rollback();			
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	
	public List<ListaFuncao> listar() {

		List<ListaFuncao> result = null;
		
		 session = HibernateUtil.getSession();
		 tx = session.beginTransaction();
		Query q = session.createQuery(" from ListaFuncao ");
		
		result = q.list();
		
		session.close();
		return result;
	}
		
		
	public List<ListaFuncao> listarPorNome(String nomelistafuncao) {
		// TODO Auto-generated method stub
		List<ListaFuncao> result = null;
		
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery("from ListaFuncao where Nome like  :parametro");
		q.setParameter("parametro", nomelistafuncao+"%");
		
		result = q.list();
		
		session.close();
		return result;
	}

	   

	public List<ListaFuncao> procurarPorId(int idProposta, int idItem) {
		// TODO Auto-generated method stub
		List<ListaFuncao> result = null;
		
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery("from ListaFuncao where id_proposta = :idProposta and " +
				"id_item = :idItem");
		q.setParameter("idProposta", idProposta);
		q.setParameter("idItem", idItem);
		
		result = q.list();
		
		session.close();
		return result;
	}

	public ListaFuncao procurarPorNome(String Nome) {
		// TODO Auto-generated method stub

		ListaFuncao result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		result = (ListaFuncao) session.get(ListaFuncao.class, Nome);
		if (result == null) {			
		}
		session.close();
		return result;
	}
	
	public  void remover(ListaFuncao listafuncao) {

		try {
			session=null;
			tx = null;
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(listafuncao);
			tx.commit();			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();			
		} finally {
			session.close();
		}
	}

}