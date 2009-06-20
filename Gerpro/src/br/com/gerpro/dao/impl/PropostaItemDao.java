package br.com.gerpro.dao.impl;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.dao.FacadePropostaItem;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.PropostaItem;

import br.com.gerpro.model.PropostaItemId;
import br.com.gerpro.util.HibernateUtil;



public class PropostaItemDao implements FacadePropostaItem{

	
	private static	Session session = null;
	private static Transaction tx = null;
	
	@Override
	public void salvar(PropostaItem propitem) {
		// TODO Retirar os 
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(propitem);
			tx.commit();			
		} catch (Exception e) {
			tx.rollback();			
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public List<PropostaItem> listar() {

		List<PropostaItem> result = null;
		
		 session = HibernateUtil.getSession();
		 tx = session.beginTransaction();		
		Query q = session.createQuery(" from PropostaItem ");
		
		result = q.list();
		
		session.close();
		return result;
	}
		
	@SuppressWarnings("unchecked")
	@Override	
	public List<PropostaItem> listarPorNome(String nomeEquipe) {
		// TODO Auto-generated method stub
		List<PropostaItem> result = null;
		
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery("from PropostaItem where Nome like  :parametro");
		q.setParameter("parametro", nomeEquipe+"%");
		
		result = q.list();
		
		session.close();
		return result;
	}

	   

	@Override
	public  PropostaItem procurarPorId(int id) {
		// TODO Auto-generated method stub

		PropostaItem result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery("from PropostaItem where id_item='1' and id_proposta =  :parametro");
		q.setParameter("parametro", id+"%");
		result = (PropostaItem) q.list();
		
		//result = (PropostaItem) session.get(PropostaItem.class, id);
	
		session.close();
		return result;
	}
	@Override
	public  PropostaItem procurarPorProposta(PropostaItemId id) {

		PropostaItem result = null;
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		
		
		result = (PropostaItem) session.get(PropostaItem.class, id);
	
		session.close();
		return result;
	}
	
	@Override
	public  List<PropostaItem> listarPoridProposta(int id) {

		List<PropostaItem> result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		
		result = session.createQuery(
				"from PropostaItem as propitem" + " where propitem.proposta.id"
						+ "=" + id).list();
		// q.setParameter("parametro", nomeEquipe + "%");

		session.close();
		return result;
	}
	
	public  List<PropostaItem> listarPoridPropostaSemAvaliacaoGeral(int id) {

		List<PropostaItem> result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		
		result = session.createQuery(
				"from PropostaItem as propitem"
				+ " where propitem.item.id <> 6"
				+ " and propitem.proposta.id"
				+ "=" + id).list();
		// q.setParameter("parametro", nomeEquipe + "%");

		session.close();
		return result;
	}


	@Override
	public PropostaItem procurarPorNome(String Nome) {
		// TODO Auto-generated method stub

		PropostaItem result = null;

		session = HibernateUtil.getSession();
		result = (PropostaItem) session.get(PropostaItem.class, Nome);
		if (result == null) {
	//		JOptionPane.showMessageDialog(null, "Não encontrado");
		}
		session.close();
		return result;
	}
	
	@Override
	public  void remover(PropostaItem propostaItem) {

		try {
			session=null;
			tx = null;
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(propostaItem);
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		
		} finally {
			session.close();
		}
	}

}