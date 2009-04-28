package Dao.Impl;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Dao.FacadeEquipe;
import Model.Equipe;
import Util.HibernateUtil;


public class daoEquipe implements FacadeEquipe {

	
	private static	Session session = null;
	private static Transaction tx = null;
	
	@Override
	public void alterar(Equipe equipe) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(equipe);
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
	public void inserir(Equipe equipe) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(equipe);
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
	public List<Equipe> listar() {

		List<Equipe> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery(" from Equipe ");
		
		result = q.list();
		
		session.close();
		return result;
	}
	//Consulta 1
	@Override
	public List<Equipe> listarOrdemAlfabetica() {

		List<Equipe> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery(" from Equipe order by nome ");
		
		result = q.list();
		
		session.close();
		return result;
		
	}
	
	//consulta 2
	//Lista por letra
	@Override
	public List<Equipe> listar2() {

		List<Equipe> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery(" from Equipe order by nome ");
		
		result = q.list();
		
		session.close();
		return result;
	}
		
	//consulta 3
	//consulta
	@Override	
	public List<Equipe> listarPorNome(String nomeEquippe) {
		// TODO Auto-generated method stub
		List<Equipe> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery("from Equipe where Nome like  :parametro");
		q.setParameter("parametro", nomeEquippe+"%");
		
		result = q.list();
		
		session.close();
		return result;
	}

	   

	@Override
	public  Equipe procurarPorId(int id) {
		// TODO Auto-generated method stub

		Equipe result = null;

		Session session = HibernateUtil.getSession();
		result = (Equipe) session.get(Equipe.class, id);
	
		session.close();
		return result;
	}

	@Override
	public Equipe procurarPorNome(String Nome) {
		// TODO Auto-generated method stub

		Equipe result = null;

		Session session = HibernateUtil.getSession();
		result = (Equipe) session.get(Equipe.class, Nome);
		if (result == null) {
			JOptionPane.showMessageDialog(null, "Não encontrado");
		}
		session.close();
		return result;
	}
	
	@Override
	public  void remover(Equipe equipe) {

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