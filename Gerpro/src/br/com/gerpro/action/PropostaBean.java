package br.com.gerpro.action;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.model.SelectItem;

import br.com.gerpro.dao.FacadeCorrecao;
import br.com.gerpro.dao.FacadeEquipe;
import br.com.gerpro.dao.FacadeListaFuncao;
import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.FacadePropostaItem;
import br.com.gerpro.dao.FacadeStatus;
import br.com.gerpro.dao.FacadeTipoFuncao;
import br.com.gerpro.dao.impl.CorrecaoDao;
import br.com.gerpro.dao.impl.EquipeDao;
import br.com.gerpro.dao.impl.ListaFuncaoDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.dao.impl.PropostaItemDao;
import br.com.gerpro.dao.impl.StatusDao;
import br.com.gerpro.dao.impl.TipoFuncaoDao;
import br.com.gerpro.mensagens.MessageManagerImpl;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Equipe;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.PropostaItem;
import br.com.gerpro.model.PropostaItemId;
import br.com.gerpro.model.Status;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.util.ApplicationSecurityManager;

public class PropostaBean {

	private UIData objDatatableProposta;
	private List<Proposta> listaProposta;
	private List<Correcao> listaCorrecao;
	private List<Proposta> listaPorProfessor;
	private Proposta proposta = new Proposta();
	private FacadeProposta propostaDao = new PropostaDao();
	private FacadeEquipe equipeDao = new EquipeDao();
	private FacadeStatus statusDao = new StatusDao();
	private Equipe equipe = new Equipe();
	private Status status = new Status();
	private ApplicationSecurityManager applicationSecurityManager = new ApplicationSecurityManager();
	private String tipo = new String();
	private String busca = new String();
	private boolean viewDes = false;
	private boolean viewint = true;

	//Variaveis proposta item
	private PropostaItemId PropItemId = new PropostaItemId();
	private PropostaItem propostaItem = new PropostaItem();
	
	private FacadeProposta daoProposta = new PropostaDao();
	private FacadePropostaItem daoPropItem = new PropostaItemDao();
	private FacadeTipoFuncao daoTipoFuncao = new TipoFuncaoDao();
	private FacadeListaFuncao daoListaFuncao = new ListaFuncaoDao();
	private FacadeCorrecao daoCorrecao = new CorrecaoDao();
	
	
	// ComboBox Equipes
	public SelectItem[] getEquipesCombo() {
		List<Equipe> le = getEquipeDao().listar();
		List<SelectItem> itens = new ArrayList<SelectItem>(le.size());

		for (Equipe e : le) {
			itens.add(new SelectItem(e.getId(), e.getNome()));
		}// for end
		return itens.toArray(new SelectItem[itens.size()]);
	}
		
	
	public SelectItem[] getItensPesqCombo() {
		List<SelectItem> itens = new ArrayList<SelectItem>(2);		
		itens.add(new SelectItem(1, "Nome"));
		itens.add(new SelectItem(2, "Equipe"));
		return itens.toArray(new SelectItem[itens.size()]);
	}

	public String prepararBean() {
		tipo = "2";
		busca = null;
		proposta = new Proposta();
		listaProposta = getPropostaDao().listar();
		listaPorProfessor = getListaPorProfessor();

		return "pesquisarProposta";
	}

	public String prepararInclusao() {
		proposta = new Proposta();
		return "incluirProposta";
	}

	public String prepararEdicao() {
		proposta = (Proposta) objDatatableProposta.getRowData();
		status = proposta.getStatus();
		equipe = proposta.getEquipe();

		return "alterarProposta";
	}
	
	public String prepararCorrecao() {
		proposta = (Proposta) objDatatableProposta.getRowData();
		applicationSecurityManager.setProposta(proposta);
		return new CorrecaoBean().prepararCorrecao();
	}

	public String irConstruirProposta(){
		proposta = (Proposta) objDatatableProposta.getRowData();
		ApplicationSecurityManager.PROPOSTA = proposta.getId().toString();
		
		return new ConstruirPropostaBean().prepararBean();
		
	}
	
	
	public void alterarComponente() {

		if (tipo.equals("1")||tipo.equals("2")) {
			viewDes = true;
			viewint = false;
			setBusca("");
		}

	}

	public void pesquisar() {	

		if (tipo.equals("1")) {
			listaProposta = getPropostaDao().listarPorNome(busca.toString());
		}
		if (tipo.equals("2")) {
			equipe.setNome(busca.toString());
			listaProposta = getPropostaDao().listarPorEquipe(equipe.getNome());
		}

	}

	public String salvar() {
		try {
			status.setId(1);
			proposta.setEquipe(equipe);
			proposta.setStatus(status);
			proposta.setDataCriacao(new Date());
			
			
			if(proposta.getId()==null){
				getPropostaDao().salvar(proposta);
				
			//Adiciona os Itens a proposta criada
				for(int i=1;i<=6;i++){
					PropItemId.setIdItem(i);
					PropItemId.setIdProposta(proposta.getId());
					status.setId(1);
					propostaItem.setStatus(status);
					propostaItem.setId(PropItemId);
					getDaoPropItem().salvar(propostaItem);
				}
				
				MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_INFO, "sucesso", "sucesso.cadastro.proposta_detail");
				
			}else{
				
				getPropostaDao().salvar(proposta);
				
				MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_INFO, "sucesso", "sucesso.cadastro.proposta_detail");
			}
		} catch (Exception e) {
			
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR, "erro", "erro.cadastro.proposta_detail");			
			
		}
		return prepararBean();
	}	

	public String listaPorProfessor() {
		Usuario usuario = applicationSecurityManager.getUsuario();
		listaPorProfessor = getPropostaDao().listarPorProfessor(usuario);
		
		return "listarPropostas";
	}	
	

	/*
	 * Getters and Setters
	 */
	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	public void setListaProposta(List<Proposta> listaProposta) {
		this.listaProposta = listaProposta;
	}

	public List<Proposta> getListaProposta() {
		return listaProposta;
	}

	public UIData getObjDatatableProposta() {
		return objDatatableProposta;
	}

	public void setObjDatatableProposta(UIData objDatatableProposta) {
		this.objDatatableProposta = objDatatableProposta;
	}

	public FacadeProposta getPropostaDao() {
		return propostaDao;
	}

	public void setPropostaDao(FacadeProposta propostaDao) {
		this.propostaDao = propostaDao;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public FacadeEquipe getEquipeDao() {
		return equipeDao;
	}

	public void setEquipeDao(FacadeEquipe equipeDao) {
		this.equipeDao = equipeDao;
	}

	public FacadeStatus getStatusDao() {
		return statusDao;
	}

	public void setStatusDao(FacadeStatus statusDao) {
		this.statusDao = statusDao;
	}

	public List<Proposta> getListaPorProfessor() {
		return listaPorProfessor;
	}

	public void setListaPorProfessor(List<Proposta> listaPorProfessor) {
		this.listaPorProfessor = listaPorProfessor;
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
	 * @return the daoProposta
	 */
	public FacadeProposta getDaoProposta() {
		return daoProposta;
	}

	/**
	 * @param daoProposta the daoProposta to set
	 */
	public void setDaoProposta(FacadeProposta daoProposta) {
		this.daoProposta = daoProposta;
	}

	/**
	 * @return the daoPropItem
	 */
	public FacadePropostaItem getDaoPropItem() {
		return daoPropItem;
	}

	/**
	 * @param daoPropItem the daoPropItem to set
	 */
	public void setDaoPropItem(FacadePropostaItem daoPropItem) {
		this.daoPropItem = daoPropItem;
	}

	/**
	 * @return the daoTipoFuncao
	 */
	public FacadeTipoFuncao getDaoTipoFuncao() {
		return daoTipoFuncao;
	}

	/**
	 * @param daoTipoFuncao the daoTipoFuncao to set
	 */
	public void setDaoTipoFuncao(FacadeTipoFuncao daoTipoFuncao) {
		this.daoTipoFuncao = daoTipoFuncao;
	}

	/**
	 * @return the daoListaFuncao
	 */
	public FacadeListaFuncao getDaoListaFuncao() {
		return daoListaFuncao;
	}

	/**
	 * @param daoListaFuncao the daoListaFuncao to set
	 */
	public void setDaoListaFuncao(FacadeListaFuncao daoListaFuncao) {
		this.daoListaFuncao = daoListaFuncao;
	}

	public List<Correcao> getListaCorrecao() {
		return listaCorrecao;
	}

	public void setListaCorrecao(List<Correcao> listaCorrecao) {
		this.listaCorrecao = listaCorrecao;
	}

	public FacadeCorrecao getDaoCorrecao() {
		return daoCorrecao;
	}

	public void setDaoCorrecao(FacadeCorrecao daoCorrecao) {
		this.daoCorrecao = daoCorrecao;
	}
	
	
	
	

}
