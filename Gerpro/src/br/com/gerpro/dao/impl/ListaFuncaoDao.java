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
	
	@Override
	public void alterar(ListaFuncao listafuncao) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(listafuncao);
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
	public void inserir(ListaFuncao listafuncao) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(listafuncao);
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
	public List<ListaFuncao> listar() {

		List<ListaFuncao> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery(" from ListaFuncao ");
		
		result = q.list();
		
		session.close();
		return result;
	}
		
		
	@Override	
	public List<ListaFuncao> listarPorNome(String nomelistafuncao) {
		// TODO Auto-generated method stub
		List<ListaFuncao> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery("from ListaFuncao where Nome like  :parametro");
		q.setParameter("parametro", nomelistafuncao+"%");
		
		result = q.list();
		
		session.close();
		return result;
	}

	   

	@Override
	public  ListaFuncao procurarPorId(int id) {
		// TODO Auto-generated method stub

		ListaFuncao result = null;

		Session session = HibernateUtil.getSession();
		result = (ListaFuncao) session.get(ListaFuncao.class, id);
	
		session.close();
		return result;
	}

	@Override
	public ListaFuncao procurarPorNome(String Nome) {
		// TODO Auto-generated method stub

		ListaFuncao result = null;

		Session session = HibernateUtil.getSession();
		result = (ListaFuncao) session.get(ListaFuncao.class, Nome);
		if (result == null) {
			JOptionPane.showMessageDialog(null, "Não encontrado");
		}
		session.close();
		return result;
	}
	
	@Override
	public  void remover(ListaFuncao listafuncao) {

		try {
			session=null;
			tx = null;
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(listafuncao);
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