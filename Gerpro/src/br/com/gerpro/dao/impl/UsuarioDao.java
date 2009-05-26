/**
 * 
 */
package br.com.gerpro.dao.impl;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.model.Status;
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
	 * @see br.com.gerpro.dao.FacadeUsuario#alterar(br.com.gerpro.model.Usuario)
	 */
	public void alterar(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.FacadeUsuario#inserir(br.com.gerpro.model.Usuario)
	 */
	public void inserir(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.FacadeUsuario#listar()
	 */
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.FacadeUsuario#listar2()
	 */
	public List<Usuario> listar2() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.FacadeUsuario#listarPorNome(java.lang.String)
	 */
	public List<Usuario> listarPorNome(String nomeStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.FacadeUsuario#listarPorOrdemAlfabetica()
	 */
	public List<Usuario> listarPorOrdemAlfabetica() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.FacadeUsuario#procurarPorMatricula(java.lang.String)
	 */
	public Status procurarPorMatricula(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.FacadeUsuario#procurarPorNome(java.lang.String)
	 */
	public Status procurarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.FacadeUsuario#remover(br.com.gerpro.model.Usuario)
	 */
	public void remover(Usuario usuario) {
		// TODO Auto-generated method stub
	}

	public String logar(Usuario usuario) {
		Usuario result = null;
		String pagina = null;		

		session = HibernateUtil.getSession();
		
		result = (Usuario) session.get(Usuario.class, usuario.getMatricula());
		
		if (result == null) {
			JOptionPane.showMessageDialog(null, "Usu�rio inv�lido");
		}

		if (result.getSenha().equals(usuario.getSenha())) {
			pagina = result.getTipoUsuario().getNome();
			
		}
		else
			JOptionPane.showMessageDialog(null, "Senha inv�lida");
		
		session.close();		
		return pagina;

	}
}
