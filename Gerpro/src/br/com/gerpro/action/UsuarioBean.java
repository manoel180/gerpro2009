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
	private String senhaNova;
	private String senhaConfirmacao;

	private String tipo = new String();
	private String busca = new String();
	private boolean viewDes = false;
	private boolean viewint = true;

	private ApplicationSecurityManager applicationSecurityManager = new ApplicationSecurityManager();
	private boolean desabilitar;
	private Equipe equipe = new Equipe();

	public SelectItem[] getItensPesqCombo() {
		List<SelectItem> itens = new ArrayList<SelectItem>(3);
		itens.add(new SelectItem(1, "Cód."));
		itens.add(new SelectItem(2, "Nome"));
		itens.add(new SelectItem(3, "Equipe"));
		return itens.toArray(new SelectItem[itens.size()]);
	}

	public void desabilitarComponente() {
		if (tipoUsuario.getId() == 1) {
			desabilitar = true;
		} else {
			desabilitar = false;
		}
	}

	public void alterarComponente() {
		if (tipo.equals("1")) {
			viewDes = false;
			viewint = true;
			setBusca("0");
		}
		if (tipo.equals("2") || tipo.equals("3")) {
			viewDes = true;
			viewint = false;
			setBusca("");
		}

	}

	public String alterarSenha() {
		String sair = "";
		try {

			Usuario usuarioBD = usuarioDao.procurarPorMatricula(usuario
					.getMatricula());
			usuario.setSenha(criptografia.criptografar(usuario.getSenha()));
			usuario.setTipoUsuario(usuarioBD.getTipoUsuario());
			if (usuarioBD != null) {

				if (usuario.getSenha().equals(usuarioBD.getSenha())) {
					if (senhaConfirmacao.equals(senhaNova)) {
						usuario.setSenha(criptografia.criptografar(senhaNova));
						usuarioDao.salvar(usuario);
						sair = "logoff";
					} else {
						// Alterar a Mesg
						MessageManagerImpl.setMensagem(
								FacesMessage.SEVERITY_ERROR,
								"usuario.invalido", "usuario.invalido_detail");
					}
				} else {
					MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
							"usuario.invalido", "usuario.invalido_detail");
				}
			} else {
				// Substituir mesg
				MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
						"usuario.invalido", "usuario.invalido_detail");
			}
		} catch (NullPointerException nullPointerException) {
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
					"usuario.invalido", "usuario.invalido_detail");
		}
		return sair;

	}

	public String resetarSenha() {
		usuario.setSenha(criptografia.criptografar("123"));
		usuarioDao.salvar(usuario);
		return prepararBean();
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
		return "homeCoordenador";
	}

	public String prepararPesquisar() {
		usuario = new Usuario();
		listaUsuarios = getUsuarioDao().listar();
		return "go_manterUsuario";
	}

	public String prepararInclusao() {
		tipoUsuario = new TipoUsuario();
		usuario = new Usuario();
		equipe = new Equipe();
		return "incluirUsuario";
	}

	public String prepararAlterarSenha() {
		usuario = new Usuario();
		return "alterarSenha";
	}

	public String prepararEdicao() {

		usuario = (Usuario) objDatatableUsuario.getRowData();
		tipoUsuario = usuario.getTipoUsuario();

		return "alterarUsuario";
	}

	public void pesquisar() {
		listaUsuarios = getUsuarioDao().listarPorNome(usuario.getNome());
	}

	public String salvar() {
		try {
			if (tipoUsuario.getId() == 2
					|| tipoUsuario.getId() == 3) {
				equipe.setId(null);
			}
			usuario.setSenha("202CB962AC59075B964B07152D234B70");
			usuario.setEquipe(equipe);
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
		// getUsuarioDao().remover(usuario);
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

					if (proposta != null) {
						applicationSecurityManager.setProposta(proposta);
					} else
						MessageManagerImpl.setMensagem(
								FacesMessage.SEVERITY_ERROR, "aviso",
								"aluno.sem.proposta");

				}

			} else {
				MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
						"usuario.invalido", "usuario.invalido_detail");
			}
		} catch (NullPointerException nullPointerException) {
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
					"usuario.invalido", "usuario.invalido_detail");
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
	 * @param desabilitar
	 *            the desabilitar to set
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
	 * @param logado
	 *            the logado to set
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
	 * @param tipoUsuario
	 *            the tipoUsuario to set
	 */
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	/**
	 * @return the senhaNova
	 */
	public String getSenhaNova() {
		return senhaNova;
	}

	/**
	 * @param senhaNova
	 *            the senhaNova to set
	 */
	public void setSenhaNova(String senhaNova) {
		this.senhaNova = senhaNova;
	}

	/**
	 * @return the senhaConfirmacao
	 */
	public String getSenhaConfirmacao() {
		return senhaConfirmacao;
	}

	/**
	 * @param senhaConfirmacao
	 *            the senhaConfirmacao to set
	 */
	public void setSenhaConfirmacao(String senhaConfirmacao) {
		this.senhaConfirmacao = senhaConfirmacao;
	}

	/**
	 * @return the objDatatableUsuario
	 */
	public UIData getObjDatatableUsuario() {
		return objDatatableUsuario;
	}

	/**
	 * @param objDatatableUsuario
	 *            the objDatatableUsuario to set
	 */
	public void setObjDatatableUsuario(UIData objDatatableUsuario) {
		this.objDatatableUsuario = objDatatableUsuario;
	}

	/**
	 * @return the listaUsuarios
	 */
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	/**
	 * @param listaUsuarios
	 *            the listaUsuarios to set
	 */
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the busca
	 */
	public String getBusca() {
		return busca;
	}

	/**
	 * @param busca
	 *            the busca to set
	 */
	public void setBusca(String busca) {
		this.busca = busca;
	}

	/**
	 * @return the viewDes
	 */
	public boolean isViewDes() {
		return viewDes;
	}

	/**
	 * @param viewDes
	 *            the viewDes to set
	 */
	public void setViewDes(boolean viewDes) {
		this.viewDes = viewDes;
	}

	/**
	 * @return the viewint
	 */
	public boolean isViewint() {
		return viewint;
	}

	/**
	 * @param viewint
	 *            the viewint to set
	 */
	public void setViewint(boolean viewint) {
		this.viewint = viewint;
	}

	/**
	 * @return the equipe
	 */
	public Equipe getEquipe() {
		return equipe;
	}

	/**
	 * @param equipe
	 *            the equipe to set
	 */
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

}
