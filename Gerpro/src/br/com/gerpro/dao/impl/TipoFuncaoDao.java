package br.com.gerpro.dao.impl;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.dao.FacadeTipoFuncao;
import br.com.gerpro.model.TipoFuncao;
import br.com.gerpro.util.HibernateUtil;



public class TipoFuncaoDao implements FacadeTipoFuncao {

	
	private static	Session session = null;
	private static Transaction tx = null;
	
	@Override
	public void salvar(TipoFuncao tipofuncao) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(tipofuncao);
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
	public List<TipoFuncao> listar() {

		List<TipoFuncao> result = null;
		
		session = HibernateUtil.getSession();
		
		Query q = session.createQuery(" from TipoFuncao ");
		
		result = q.list();
		
		session.close();
		return result;
	}
		
		
	@Override	
	public List<TipoFuncao> listarPorNome(String nomeTipoFuncao) {
		// TODO Auto-generated method stub
		List<TipoFuncao> result = null;
		
		session = HibernateUtil.getSession();
		
		Query q = session.createQuery("from TipoFuncao where Nome like  :parametro");
		q.setParameter("parametro", nomeTipoFuncao+"%");
		
		result = q.list();
		
		session.close();
		return result;
	}

	   

	@Override
	public  TipoFuncao procurarPorId(int id) {
		// TODO Auto-generated method stub

		TipoFuncao result = null;

		session = HibernateUtil.getSession();
		result = (TipoFuncao) session.get(TipoFuncao.class, id);
	
		session.close();
		return result;
	}

	@Override
	public TipoFuncao procurarPorNome(String Nome) {
		// TODO Auto-generated method stub

		TipoFuncao result = null;

		session = HibernateUtil.getSession();
		result = (TipoFuncao) session.get(TipoFuncao.class, Nome);
		if (result == null) {
			JOptionPane.showMessageDialog(null, "Não encontrado");
		}
		session.close();
		return result;
	}
	
	@Override
	public  void remover(TipoFuncao Tipofuncao) {

		try {
			session=null;
			tx = null;
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(Tipofuncao);
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