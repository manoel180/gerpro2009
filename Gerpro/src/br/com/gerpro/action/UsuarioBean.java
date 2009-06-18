package br.com.gerpro.action;

/**
 * @author M3R
 *
 */
 

import java.util.List;

import javax.faces.component.UIData;

import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.dao.impl.UsuarioDao;
import br.com.gerpro.model.Proposta;
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
	/***
	 * M�todo para valida��o simples de login do usuario 
	 * 
	 * @return String contendo o nome da p�gina Home do Usuario que realizou o login
	 */

	public String logar(){
		String  homeUsuario = "home";		 
		Usuario usuarioBD = usuarioDao.procurarPorMatricula(usuario.getMatricula());
		
		if (usuario == null) {			
			return "erro";
			
		}else{
			if (usuario.getSenha().equals(usuarioBD.getSenha())) {
				homeUsuario += usuarioBD.getTipoUsuario().getNome();
				applicationSecurityManager.setUsuario(usuarioBD);
				if(usuarioBD.getTipoUsuario().getId()==1){
					Proposta proposta = new Proposta();
					FacadeProposta propostaDao = new PropostaDao();
					proposta = propostaDao.listarPorIdEquipe(usuarioBD.getEquipe().getId());
					applicationSecurityManager.setProposta(proposta);
				}
			
			}
			else
			{
				return "erro";
			}				
		}	
				
				
		return homeUsuario;
	}
	
	public String sairAplicacao(){
		
		applicationSecurityManager.removeUsuario();
		
		if(applicationSecurityManager.getProposta() != null){
			applicationSecurityManager.removeProposta();
		}
		
		return "logoff";		
		
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
