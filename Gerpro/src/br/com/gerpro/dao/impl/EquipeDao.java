package br.com.gerpro.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.dao.FacadeEquipe;
import br.com.gerpro.model.Equipe;
import br.com.gerpro.util.HibernateUtil;



public class EquipeDao implements FacadeEquipe {

	
	private static	Session session = null;
	private static Transaction tx = null;
	
	@Override
	public void salvar(Equipe equipe) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(equipe);
			tx.commit();
			JOptionPane.showMessageDialog(null, "Alteração Realizada com sucesso");
		} catch (HibernateException e) {
			//JOptionPane.showMessageDialog(null, "Ocorreu um erro no Hibernate!");
			System.out.println("*************** E " + e.toString());
			System.out.println("*************** E" + e.toString());
			//PropertiesLoaderImpl.getValor(chave)
			tx.rollback();
			
			
			e.printStackTrace();
		} catch (PersistenceException e) {
			//JOptionPane.showMessageDialog(null, "Ocorreu um erro de Persistencia!");
			tx.rollback();
			
			e.printStackTrace();
			}catch (Exception e) {
				tx.rollback();
				//JOptionPane.showMessageDialog(null, "Ocorreu um erro Exception!");
				
				
				e.printStackTrace();
			}
		
		finally {
			session.close();
		}
	}


	@Override
	public List<Equipe> listar() {

		List<Equipe> result = null;
		
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery(" from Equipe ");
		
		result = q.list();
		
		session.close();
		return result;
	}

		
			
	@Override	
	public List<Equipe> listarPorNome(String nomeEquippe) {
		// TODO Auto-generated method stub
		List<Equipe> result = null;
		
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
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

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		result = (Equipe) session.get(Equipe.class, id);
	
		session.close();
		return result;
	}

	@Override
	public Equipe procurarPorNome(String Nome) {
		// TODO Auto-generated method stub

		Equipe result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
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