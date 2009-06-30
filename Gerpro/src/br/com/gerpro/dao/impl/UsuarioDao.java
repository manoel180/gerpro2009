/**
 * 
 */
package br.com.gerpro.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.util.HibernateUtil;

/**
 * @author M3R
 * 
 */
public class UsuarioDao implements FacadeUsuario {

	private static Session session = null;
	private static Transaction tx = null;

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.FacadeUsuario#salvar(br.com.gerpro.model.Usuario)
	 */
	public void salvar(Usuario usuario) {
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(usuario);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();			
			e.printStackTrace();
		} catch (PersistenceException e) {
			tx.rollback();			
			e.printStackTrace();
		} catch (Exception e) {
			tx.rollback();			
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.FacadeUsuario#listar()
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
	List<Usuario> result = null;
		
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		Query q = session.createQuery(" from Usuario ");
		
		result = q.list();
		
		session.close();
		return result;
	}	

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.FacadeUsuario#listarPorNome(java.lang.String)
	 */
	public List<Usuario> listarPorNome(String nome) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public List<Usuario> listarPorEquipe(int id) {
		// TODO Auto-generated method stub
		List<Usuario> result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		// Funcionando mas duplicando linhas
		result = session.createQuery(
				"from Usuario as user" + " where user.equipe.id ="
						 + id ).list();

		session.close();
		return result;
	}

	public List<Usuario> listarProfessores() {		
		List<Usuario> result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		// Funcionando mas duplicando linhas
		result = session.createQuery(
				"from Usuario as user" + " where user.tipoUsuario.id = 2 order by user.nome asc" ).list();

		session.close();
		return result;
	}

	public List<Usuario> listarAlunos() {		
		List<Usuario> result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		// Funcionando mas duplicando linhas
		result = session.createQuery(
				"from Usuario as user" + " where user.tipoUsuario.id = 1 order by user.nome asc" ).list();

		session.close();
		return result;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.FacadeUsuario#procurarPorMatricula(java.lang.String)
	 */
	public Usuario procurarPorMatricula(String matricula) {
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		Usuario usuario = (Usuario)session.get(Usuario.class, matricula);		
		session.close();
		return usuario;
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.FacadeUsuario#procurarPorNome(java.lang.String)
	 */
	public Usuario procurarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarProfessoresParaCorrecao(){
		List<Usuario> result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		
		result = session.createQuery("from Usuario as user"
				+ " where user.tipoUsuario.id = 2"
				+ " or user.tipoUsuario.id = 3"
				+ " order by user.nome asc" )
				.list();

		session.close();
		return result;

		
	}
	
}
