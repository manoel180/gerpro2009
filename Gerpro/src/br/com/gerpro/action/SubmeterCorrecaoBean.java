package br.com.gerpro.action;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;

import br.com.gerpro.dao.FacadeCorrecao;
import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.dao.impl.CorrecaoDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.dao.impl.UsuarioDao;
import br.com.gerpro.mensagens.MessageManagerImpl;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Equipe;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.PropostaItem;
import br.com.gerpro.model.Status;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.processing.ProcessoCorrecao;
import br.com.gerpro.util.ApplicationSecurityManager;


public class SubmeterCorrecaoBean {
	private UIData objDatatablePropostaItem;
	private UIData objDatatableCorrecao;
	private List<Correcao> listaCorrecao;
	private List<PropostaItem> listaPropostaItem;
	private boolean desabilita;
	private Proposta proposta = new Proposta();	
	private Equipe equipe = new Equipe();
	private Status status = new Status();	
	private FacadeProposta propostaDao = new PropostaDao() ;
	private FacadeCorrecao correcaoDao = new CorrecaoDao() ;
	private FacadeUsuario usuarioDao = new UsuarioDao();
	private ApplicationSecurityManager applicationSecurityManager = new ApplicationSecurityManager();
	private ProcessoCorrecao processoCorrecao = new ProcessoCorrecao(); 
	
	

	public String prepararBean() {
		
		Proposta proposta = applicationSecurityManager.getProposta();
		Usuario professor = applicationSecurityManager.getUsuario();
		
		setListaCorrecao(correcaoDao.procurarPorCorrecao(professor, proposta));
				
		status =  proposta.getStatus();
		equipe = proposta.getEquipe();
		
		return "submeterCorrecao";
		}
	
	public String listaCorrecao(){		
		
		return "submeterCorrecao";
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
	
	private void verificarItens(){
		int cont = 0;
		for(Correcao correcao  : listaCorrecao){
			if(correcao.getStatus().getId() == 7){
				cont++;								
			}
		}
		
		if(cont == 8 && (proposta.getStatus().getId()== 2) ){
			desabilita = false;
		}
		else{
			desabilita = true;
			if(cont < 8){
				MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_WARN, "aviso", "itens.nao.concluidos");				
			}else{
				MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_WARN, "aviso", "proposta.submetida");				
			}			
		}
	}
	
	public void corrigirProposta(){
		Usuario professor = applicationSecurityManager.getUsuario();
		Proposta proposta = applicationSecurityManager.getProposta();		
		
		//Executa o processo de correcao da proposta pelo professor
		processoCorrecao.calcularStatusPropostaAtual(professor, proposta);
		
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

	/**
	 * @return the listaCorrecao
	 */
	public List<Correcao> getListaCorrecao() {
		return listaCorrecao;
	}

	/**
	 * @param listaCorrecao the listaCorrecao to set
	 */
	public void setListaCorrecao(List<Correcao> listaCorrecao) {
		this.listaCorrecao = listaCorrecao;
	}

	/**
	 * @return the processoCorrecao
	 */
	public ProcessoCorrecao getProcessoCorrecao() {
		return processoCorrecao;
	}

	/**
	 * @param processoCorrecao the processoCorrecao to set
	 */
	public void setProcessoCorrecao(ProcessoCorrecao processoCorrecao) {
		this.processoCorrecao = processoCorrecao;
	}

	/**
	 * @return the desabilita
	 */
	public boolean isDesabilita() {
		return desabilita;
	}

	/**
	 * @param desabilita the desabilita to set
	 */
	public void setDesabilita(boolean desabilita) {
		this.desabilita = desabilita;
	}	

}
