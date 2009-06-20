package br.com.gerpro.action;

/**
 * @author M3R
 *
 */

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.model.SelectItem;

import br.com.gerpro.dao.FacadeEquipe;
import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.dao.impl.EquipeDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.dao.impl.UsuarioDao;
import br.com.gerpro.mensagens.MessageManagerImpl;
import br.com.gerpro.model.Equipe;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.TipoUsuario;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.util.ApplicationSecurityManager;
import br.com.gerpro.util.Criptografia;

public class UsuarioBean {
	private UIData objDatatableUsuario;// componente da tela - JSP
	private List<Usuario> listaUsuarios;
	private Criptografia criptografia;
	private Usuario usuario = new Usuario();
	private TipoUsuario tipoUsuario = new TipoUsuario();
	private FacadeUsuario usuarioDao = new UsuarioDao();
	private FacadeEquipe equipeDao = new EquipeDao();
	private Usuario logado = new Usuario();
	
	private ApplicationSecurityManager applicationSecurityManager = new ApplicationSecurityManager();
	private boolean desabilitar;
	
	public void desabilitarComponente(){
		if(tipoUsuario.getId()==1){
			desabilitar = true;
		}else{
			desabilitar = false;
		}
	}
	
	private boolean verificarUsuario(){
	
		try {

			Usuario usuarioBD = usuarioDao.procurarPorMatricula(usuario
					.getMatricula());
			if(){}
			usuario.setSenha(criptografia.criptografar(usuario.getSenha()));
			if (usuario.getSenha().equals(usuarioBD.getSenha())) {
				homeUsuario += usuarioBD.getTipoUsuario().getNome();
				applicationSecurityManager.setUsuario(usuarioBD);
				setLogado(usuarioBD);

				if (usuarioBD.getTipoUsuario().getId() == 1) {
					Proposta proposta = new Proposta();
					FacadeProposta propostaDao = new PropostaDao();
					proposta = propostaDao.listarPorIdEquipe(usuarioBD
							.getEquipe().getId());
					applicationSecurityManager.setProposta(proposta);
				}

			}else {
				MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR, "usuario.invalido", "usuario.invalido_detail");				
			}
		} catch (NullPointerException nullPointerException) {			
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR, "usuario.invalido", "usuario.invalido_detail");
		
	}
		return false;
	}
	
	// ComboBox Equipes
	public SelectItem[] getEquipesCombo() {
		List<Equipe> le = equipeDao.listar();
		List<SelectItem> itens = new ArrayList<SelectItem>(le.size());

		for (Equipe e : le) {
			itens.add(new SelectItem(e.getId(), e.getNome()));
		}// for end
		return itens.toArray(new SelectItem[itens.size()]);
	}
	
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
			usuario.setTipoUsuario(tipoUsuario);
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

	/***************************************************************************
	 * Método para validação simples de login do usuário
	 * 
	 * @return String contendo o nome da página Home do usuário que realizou o
	 *         login
	 */

	public String logar() {
		String homeUsuario = "home";
		try {

			Usuario usuarioBD = usuarioDao.procurarPorMatricula(usuario
					.getMatricula());
			usuario.setSenha(criptografia.criptografar(usuario.getSenha()));
			if (usuario.getSenha().equals(usuarioBD.getSenha())) {
				homeUsuario += usuarioBD.getTipoUsuario().getNome();
				applicationSecurityManager.setUsuario(usuarioBD);
				setLogado(usuarioBD);

				if (usuarioBD.getTipoUsuario().getId() == 1) {
					Proposta proposta = new Proposta();
					FacadeProposta propostaDao = new PropostaDao();
					proposta = propostaDao.listarPorIdEquipe(usuarioBD
							.getEquipe().getId());
					applicationSecurityManager.setProposta(proposta);
				}

			}else {
				MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR, "usuario.invalido", "usuario.invalido_detail");				
			}
		} catch (NullPointerException nullPointerException) {			
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR, "usuario.invalido", "usuario.invalido_detail");
		}
		return homeUsuario;
	}

	public String sairAplicacao() {

		applicationSecurityManager.removeUsuario();

		if (applicationSecurityManager.getProposta() != null) {
			applicationSecurityManager.removeProposta();
		}

		return "logoff";
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

	/**
	 * @return the desabilitar
	 */
	public boolean isDesabilitar() {
		return desabilitar;
	}

	/**
	 * @param desabilitar the desabilitar to set
	 */
	public void setDesabilitar(boolean desabilitar) {
		this.desabilitar = desabilitar;
	}

	/**
	 * @return the logado
	 */
	public Usuario getLogado() {
		return logado;
	}

	/**
	 * @param logado the logado to set
	 */
	public void setLogado(Usuario logado) {
		this.logado = logado;
	}

	/**
	 * @return the tipoUsuario
	 */
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * @param tipoUsuario the tipoUsuario to set
	 */
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
}
