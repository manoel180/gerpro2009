package br.com.gerpro.action;


import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.model.SelectItem;

import br.com.gerpro.dao.FacadeCorrecao;
import br.com.gerpro.dao.FacadeEquipe;
import br.com.gerpro.dao.FacadeItem;
import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.FacadePropostaItem;
import br.com.gerpro.dao.FacadeStatus;
import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.dao.impl.CorrecaoDao;
import br.com.gerpro.dao.impl.EquipeDao;
import br.com.gerpro.dao.impl.ItemDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.dao.impl.PropostaItemDao;
import br.com.gerpro.dao.impl.StatusDao;
import br.com.gerpro.dao.impl.UsuarioDao;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Equipe;
import br.com.gerpro.model.Item;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.PropostaItem;
import br.com.gerpro.model.Status;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.util.ApplicationSecurityManager;


public class SubmeterCorrecaoBean {
	private UIData objDatatablePropostaItem;
	private UIData objDatatableCorrecao;
	private List<PropostaItem> listaPropostaItem;
	private List<Usuario> listaUsuarios;
	
	private Proposta proposta = new Proposta();
	private Item item = new Item();
	private PropostaItem propitem = new PropostaItem();
	private Equipe equipe = new Equipe();
	private Status status = new Status();
	
	private FacadeProposta propostaDao = new PropostaDao() ;
	private FacadeCorrecao correcaoDao = new CorrecaoDao() ;
	private FacadeItem itemDao = new ItemDao();
	private FacadePropostaItem propitemDao = new PropostaItemDao();
	
	private FacadeEquipe equipeDao = new EquipeDao();
	private FacadeStatus statusDao = new StatusDao();
	private FacadeUsuario usuarioDao = new UsuarioDao();
	private ApplicationSecurityManager applicationSecurityManager = new ApplicationSecurityManager();
	
	
	
	//ComboBox Equipes
	public SelectItem[] getEquipesCombo(){
		List<Equipe> le = getEquipeDao().listar();
		List<SelectItem> itens = new ArrayList<SelectItem>(le.size());

		for( Equipe e : le ){
			itens.add( new SelectItem(e.getId(),e.getNome()));
		}// for end
		return itens.toArray( new SelectItem[itens.size()] );
	}
	
	//ComboBox Status
	public SelectItem[] getStatusCombo(){
		List<Status> le = getStatusDao().listar();
		List<SelectItem> itens = new ArrayList<SelectItem>(le.size());

		for( Status e : le ){
			itens.add( new SelectItem(e.getId(),e.getNome()));
		}// for end
		return itens.toArray( new SelectItem[itens.size()] );
	}
	
	
	
	public String prepararBean() {
		
		Proposta proposta = (Proposta) applicationSecurityManager.getProposta();
		Usuario professor = (Usuario) applicationSecurityManager.getUsuario();
		
		List<Correcao> listaCorrecao = correcaoDao.procurarPorCorrecao(professor, proposta);
				
		status =  proposta.getStatus();
		equipe = proposta.getEquipe();
		
		return listaCorrecao();
	}
	
	public String listaCorrecao(){		
		
		return "go_SubmeterProposta";
	}
	
	
	public String salvar() {
		try {
						
			proposta.setEquipe(equipe);
			proposta.setStatus(status);
			getPropostaDao().salvar(proposta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prepararBean();
	}
	
	
	/*
	 * Getters and Setters
	 */

	/**
	 * @return the objDatatablePropostaItem
	 */
	public UIData getObjDatatablePropostaItem() {
		return objDatatablePropostaItem;
	}

	/**
	 * @param objDatatablePropostaItem the objDatatablePropostaItem to set
	 */
	public void setObjDatatablePropostaItem(UIData objDatatablePropostaItem) {
		this.objDatatablePropostaItem = objDatatablePropostaItem;
	}
 
	/**
	 * @return the listaPropostaItem
	 */
	public List<PropostaItem> getListaPropostaItem() {
		return listaPropostaItem;
	}

	/**
	 * @param listaProposta the listaProposta to set
	 */
	public void setListaPropostaItem(List<PropostaItem> listaPropostaItem) {
		this.listaPropostaItem = listaPropostaItem;
	}

	/**
	 * @return the proposta
	 */
	public Proposta getProposta() {
		return proposta;
	}

	/**
	 * @param proposta the proposta to set
	 */
	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @return the propitem
	 */
	public PropostaItem getPropitem() {
		return propitem;
	}

	/**
	 * @param propitem the propitem to set
	 */
	public void setPropitem(PropostaItem propitem) {
		this.propitem = propitem;
	}

	/**
	 * @return the equipe
	 */
	public Equipe getEquipe() {
		return equipe;
	}

	/**
	 * @param equipe the equipe to set
	 */
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the propostaDao
	 */
	public FacadeProposta getPropostaDao() {
		return propostaDao;
	}

	/**
	 * @param propostaDao the propostaDao to set
	 */
	public void setPropostaDao(FacadeProposta propostaDao) {
		this.propostaDao = propostaDao;
	}

	/**
	 * @return the itemDao
	 */
	public FacadeItem getItemDao() {
		return itemDao;
	}

	/**
	 * @param itemDao the itemDao to set
	 */
	public void setItemDao(FacadeItem itemDao) {
		this.itemDao = itemDao;
	}

	/**
	 * @return the propitemDao
	 */
	public FacadePropostaItem getPropitemDao() {
		return propitemDao;
	}

	/**
	 * @param propitemDao the propitemDao to set
	 */
	public void setPropitemDao(FacadePropostaItem propitemDao) {
		this.propitemDao = propitemDao;
	}

	/**
	 * @return the equipeDao
	 */
	public FacadeEquipe getEquipeDao() {
		return equipeDao;
	}

	/**
	 * @param equipeDao the equipeDao to set
	 */
	public void setEquipeDao(FacadeEquipe equipeDao) {
		this.equipeDao = equipeDao;
	}

	/**
	 * @return the statusDao
	 */
	public FacadeStatus getStatusDao() {
		return statusDao;
	}

	/**
	 * @param statusDao the statusDao to set
	 */
	public void setStatusDao(FacadeStatus statusDao) {
		this.statusDao = statusDao;
	}

	
	/**
	 * @return the usuarioDao
	 */
	public FacadeUsuario getUsuarioDao() {
		return usuarioDao;
	}

	/**
	 * @param usuarioDao the usuarioDao to set
	 */
	public void setUsuarioDao(FacadeUsuario usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	/**
	 * @return the listaUsuarios
	 */
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	/**
	 * @param listaUsuarios the listaUsuarios to set
	 */
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	/**
	 * @return the objDatatableCorrecao
	 */
	public UIData getObjDatatableCorrecao() {
		return objDatatableCorrecao;
	}

	/**
	 * @param objDatatableCorrecao the objDatatableCorrecao to set
	 */
	public void setObjDatatableCorrecao(UIData objDatatableCorrecao) {
		this.objDatatableCorrecao = objDatatableCorrecao;
	}

	/**
	 * @return the correcaoDao
	 */
	public FacadeCorrecao getCorrecaoDao() {
		return correcaoDao;
	}

	/**
	 * @param correcaoDao the correcaoDao to set
	 */
	public void setCorrecaoDao(FacadeCorrecao correcaoDao) {
		this.correcaoDao = correcaoDao;
	}

	/**
	 * @return the applicationSecurityManager
	 */
	public ApplicationSecurityManager getApplicationSecurityManager() {
		return applicationSecurityManager;
	}

	/**
	 * @param applicationSecurityManager the applicationSecurityManager to set
	 */
	public void setApplicationSecurityManager(
			ApplicationSecurityManager applicationSecurityManager) {
		this.applicationSecurityManager = applicationSecurityManager;
	}

	

}