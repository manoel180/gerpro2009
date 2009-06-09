package br.com.gerpro.action;

/**
 * @author M3R
 *
 */
 

import java.util.List;

import javax.faces.component.UIData;
import javax.swing.JOptionPane;

import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.dao.impl.UsuarioDao;
import br.com.gerpro.model.TipoUsuario;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.util.ApplicationSecurityManager;



public class UsuarioBean{
	private UIData objDatatableUsuario;// componente da tela - JSP
	private List<Usuario> listaUsuarios;
	private Usuario usuario = new Usuario();
	private FacadeUsuario usuarioDao = new UsuarioDao();	
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
			getUsuarioDao().salvar(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prepararBean();
	}

	public String alterar() {
		try {
			getUsuarioDao().salvar(usuario);
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

	public String logar(){
		String  homeUsuario = "home";		 
		Usuario usuarioBD = usuarioDao.procurarPorMatricula(usuario.getMatricula());
		
		if (usuario == null) {
			JOptionPane.showMessageDialog(null, "Usuário inválido");
			return null;
		}else{
			if (usuario.getSenha().equals(usuarioBD.getSenha())) {
				homeUsuario += usuarioBD.getTipoUsuario().getNome();				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Senha inválida");
				return null;
			}				
		}	
				
		applicationSecurityManager.setUsuario(usuario);		
		return homeUsuario;
	}
	//TODO Retirar item Tela Inicial de todos os menus.
	

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
