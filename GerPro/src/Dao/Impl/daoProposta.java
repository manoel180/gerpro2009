package Dao.Impl;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Dao.FacadeProposta;
import Model.Proposta;
import Util.HibernateUtil;


public class daoProposta implements FacadeProposta {

	
	private static	Session session = null;
	private static Transaction tx = null;
	
	@Override
	public void alterar(Proposta proposta) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(proposta);
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
	public void inserir(Proposta proposta) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(proposta);
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
	public List<Proposta> listar() {

		List<Proposta> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery(" from Proposta ");
		
		result = q.list();
		
		session.close();
		return result;
	}
	//Consulta 1
	@Override
	public List<Proposta> listarOrdemAlfabetica() {

		List<Proposta> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery(" from Proposta order by nome ");
		
		result = q.list();
		
		session.close();
		return result;
		
	}
	
	//consulta 2
	//Lista por letra
	@Override
	public List<Proposta> listar2() {

		List<Proposta> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery(" from Proposta order by status ");
		
		result = q.list();
		
		session.close();
		return result;
	}
		
	//consulta 3
	//consulta
	@SuppressWarnings("unchecked")
	@Override	
	public List<Proposta> listarPorNome(String nomeProposta) {
		// TODO Auto-generated method stub
		List<Proposta> result = null;
		
		Session session = HibernateUtil.getSession();
		
		//Query q = session.createQuery("from Proposta where Nome like  :parametro");
		
		Query q = session.createQuery(
				" FROM Proposta " 
				);		
		//q.setParameter("parametro", nomeProposta+"%");
		
		result = q.list();
		
		for (Proposta proposta : result) {
			proposta.getEquipe().getNome();
			
		}
			
		
		
		
		session.close();
		return result;
	}

	   

	@Override
	public  Proposta procurarPorId(int id) {
		// TODO Auto-generated method stub

		Proposta result = null;

		Session session = HibernateUtil.getSession();
		result = (Proposta) session.get(Proposta.class, id);
	
		session.close();
		return result;
	}

	@Override
	public Proposta procurarPorNome(String Nome) {
		// TODO Auto-generated method stub

		Proposta result = null;

		Session session = HibernateUtil.getSession();
		result = (Proposta) session.get(Proposta.class, Nome);
		if (result == null) {
			JOptionPane.showMessageDialog(null, "Não encontrado");
		}
		session.close();
		return result;
	}
	
	@Override
	public  void remover(Proposta proposta) {

		try {
			session=null;
			tx = null;
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(proposta);
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