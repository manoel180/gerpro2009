package br.com.gerpro.dao.impl;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.dao.FacadePropostaItem;
import br.com.gerpro.model.PropostaItem;
import br.com.gerpro.util.HibernateUtil;



public class PropostaItemDao implements FacadePropostaItem{

	
	private static	Session session = null;
	private static Transaction tx = null;
	
	@Override
	public void alterar(PropostaItem propitem) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(propitem);
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

	//Funcionando
	@Override
	public void inserir(PropostaItem propitem) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(propitem);
			tx.commit();
			JOptionPane.showMessageDialog(null, "\"Cadastrado com Sucesso\"");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
		} finally {
			session.close();
		}
	}
	@Override
	public List<PropostaItem> listar() {

		List<PropostaItem> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery(" from PropostaItem ");
		
		result = q.list();
		
		session.close();
		return result;
	}
	//Consulta 1
	@Override
	public List<PropostaItem> listarOrdemAlfabetica() {

		List<PropostaItem> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery(" from PropostaItem order by nome ");
		
		result = q.list();
		
		session.close();
		return result;
		
	}
	
	//consulta 2
	//Lista por letra
	@Override
	public List<PropostaItem> listar2() {

		List<PropostaItem> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery(" from PropostaItem order by nome ");
		
		result = q.list();
		
		session.close();
		return result;
	}
		
	//consulta 3
	//consulta
	@Override	
	public List<PropostaItem> listarPorNome(String nomeEquippe) {
		// TODO Auto-generated method stub
		List<PropostaItem> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery("from PropostaItem where Nome like  :parametro");
		q.setParameter("parametro", nomeEquippe+"%");
		
		result = q.list();
		
		session.close();
		return result;
	}

	   

	@Override
	public  PropostaItem procurarPorId(int id) {
		// TODO Auto-generated method stub

		PropostaItem result = null;

		Session session = HibernateUtil.getSession();
		result = (PropostaItem) session.get(PropostaItem.class, id);
	
		session.close();
		return result;
	}

	@Override
	public PropostaItem procurarPorNome(String Nome) {
		// TODO Auto-generated method stub

		PropostaItem result = null;

		Session session = HibernateUtil.getSession();
		result = (PropostaItem) session.get(PropostaItem.class, Nome);
		if (result == null) {
			JOptionPane.showMessageDialog(null, "Não encontrado");
		}
		session.close();
		return result;
	}
	
	@Override
	public  void remover(PropostaItem equipe) {

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