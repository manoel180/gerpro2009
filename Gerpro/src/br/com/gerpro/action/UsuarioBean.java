package br.com.gerpro.action;

/**
 * @author M3R
 *
 */
 

import java.util.List;

import javax.faces.component.UIData;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.dao.impl.UsuarioDao;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.util.ApplicationSecurityManager;



public class UsuarioBean{
	private UIData objDatatableUsuario;// componente da tela - JSP
	private List<Usuario> listaUsuarios;
	private Usuario usuario = new Usuario();
	private FacadeUsuario usuarioDao = new UsuarioDao();
	private HttpServletRequest requestScope; 
	private ApplicationSecurityManager applicationSecurityManager = new ApplicationSecurityManager();
	
	public String prepararBean() {
		usuario = new Usuario();
		listaUsuarios = getUsuarioDao().listar();
		return null;

		}

	public String preperarInclusao() {
		usuario = new Usuario();
		return "incluir";
	}

	public String preperarEdicao() {
		usuario = (Usuario) objDatatableUsuario.getRowData();
		return "alterar";
	}

	public void pesquisar() {
		listaUsuarios = getUsuarioDao().listarPorNome(usuario.getNome());
	}

	public String salvar() {
		try {
			getUsuarioDao().inserir(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prepararBean();
	}

	public String alterar() {
		try {
			getUsuarioDao().alterar(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "visualizar";
	}

	
	public String excluir() {
		usuario = (Usuario) objDatatableUsuario.getRowData();
		getUsuarioDao().remover(usuario);
		return prepararBean();
	}
	
<<<<<<< .mine
	public String logar(){		
		//(Usuario) objDatatableUsuario.getRowData();
=======
	public String logar(){
//		applicationSecurityManager.setUser(request, usuario);
//		Usuario usuario = (Usuario) get
//		getRequestScope().put("cidade", cidade);
>>>>>>> .r132
		
		return usuarioDao.logar(usuario);
	}

	/*
	 * Getters and Setters
	 */

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuarios;
	}

	public UIData getObjDatatableUsuario() {
		return objDatatableUsuario;
	}

	public void setObjDatatableEquipe(UIData objDatatableUsuario) {
		this.objDatatableUsuario = objDatatableUsuario;
	}

	public FacadeUsuario getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(FacadeUsuario usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
