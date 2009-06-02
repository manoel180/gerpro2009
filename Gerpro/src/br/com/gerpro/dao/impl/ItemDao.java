package br.com.gerpro.dao.impl;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.dao.FacadeItem;
import br.com.gerpro.model.Item;
import br.com.gerpro.util.HibernateUtil;



public class ItemDao implements FacadeItem {

	
	private static	Session session = null;
	private static Transaction tx = null;
	
	@Override
	public void salvar(Item item) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(item);
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
	public List<Item> listar() {

		List<Item> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery(" from Item ");
		
		result = q.list();
		
		session.close();
		return result;
	}
			
	@Override	
	public List<Item> listarPorNome(String nomeEquippe) {
		// TODO Auto-generated method stub
		List<Item> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery("from Item where Nome like  :parametro");
		q.setParameter("parametro", nomeEquippe+"%");
		
		result = q.list();
		
		session.close();
		return result;
	}

	   

	@Override
	public  Item procurarPorId(int id) {
		// TODO Auto-generated method stub

		Item result = null;

		Session session = HibernateUtil.getSession();
		result = (Item) session.get(Item.class, id);
	
		session.close();
		return result;
	}

	@Override
	public Item procurarPorNome(String Nome) {
		// TODO Auto-generated method stub

		Item result = null;

		Session session = HibernateUtil.getSession();
		result = (Item) session.get(Item.class, Nome);
		if (result == null) {
			JOptionPane.showMessageDialog(null, "Não encontrado");
		}
		session.close();
		return result;
	}
	
	@Override
	public  void remover(Item equipe) {

		try {
			session=null;
			tx = null;
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(equipe);
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