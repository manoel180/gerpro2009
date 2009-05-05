package br.com.gerpro.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.model.SelectItem;

import br.com.gerpro.dao.FacadeEquipe;
import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.FacadeStatus;
import br.com.gerpro.dao.impl.EquipeDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.dao.impl.StatusDao;
import br.com.gerpro.model.Equipe;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Status;


public class PropostaBean {
	private UIData objDatatableProposta;
	private List<Proposta> listaProposta;
	private Proposta proposta = new Proposta();
	private FacadeProposta daoProposta = new PropostaDao() ;
	private FacadeEquipe daoEquipe = new EquipeDao();
	private FacadeStatus daoStatus = new StatusDao();
	private Equipe equipe = new Equipe();
	private Status status = new Status();
	
	//ComboBox Equipes
	public SelectItem[] getEquipesCombo(){
		List<Equipe> le = getDaoEquipe().listar();
		List<SelectItem> itens = new ArrayList<SelectItem>(le.size());

		for( Equipe e : le ){
			itens.add( new SelectItem(e.getId(),e.getNome()));
		}// for end
		return itens.toArray( new SelectItem[itens.size()] );
	}
	
	//ComboBox Status
	public SelectItem[] getStatusCombo(){
		List<Status> le = getDaoStatus().listar();
		List<SelectItem> itens = new ArrayList<SelectItem>(le.size());

		for( Status e : le ){
			itens.add( new SelectItem(e.getId(),e.getNome()));
		}// for end
		return itens.toArray( new SelectItem[itens.size()] );
	}
	
	public String prepararBean() {

		proposta = new Proposta();
		listaProposta = getDaoProposta().listar();
	
		return "go_manterProposta";
	}

	public String preperarInclusao() {
		proposta = new Proposta();
		return "incluir";
	}

	public String preperarEdicao() {
		proposta = (Proposta) objDatatableProposta.getRowData();
		return "alterar";
	}

	public void pesquisar() {
		listaProposta = getDaoProposta().listarPorNome(proposta.getNome());
	
	}

	public String salvar() {
		try {
						
			proposta.setDataCriacao(new Date("22/03/04"));
			proposta.setDataSubmissao(new Date("22/03/04"));
			
			proposta.setEquipe(equipe);
			proposta.setStatus(status);
			proposta.setPeriodo("001");			
			getDaoProposta().inserir(proposta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prepararBean();
	}

	public String alterar() {
		try {
			getDaoProposta().alterar(proposta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prepararBean();
	}

	
	public String excluir() {
		proposta = (Proposta) objDatatableProposta.getRowData();
		getDaoProposta().remover(proposta);
		return prepararBean();
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

	public FacadeProposta getDaoProposta() {
		return daoProposta;
	}

	public void setDaoProposta(FacadeProposta daoProposta) {
		this.daoProposta = daoProposta;
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


	public FacadeEquipe getDaoEquipe() {
		return daoEquipe;
	}


	public void setDaoEquipe(FacadeEquipe daoEquipe) {
		this.daoEquipe = daoEquipe;
	}

	public FacadeStatus getDaoStatus() {
		return daoStatus;
	}

	public void setDaoStatus(FacadeStatus daoStatus) {
		this.daoStatus = daoStatus;
	}

}
