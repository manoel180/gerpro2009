package br.com.gerpro.action;

import java.util.List;

import javax.faces.component.UIData;
import javax.persistence.PersistenceException;

import br.com.gerpro.dao.FacadeEquipe;
import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.FacadePropostaItem;
import br.com.gerpro.dao.impl.EquipeDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.dao.impl.PropostaItemDao;
import br.com.gerpro.model.Equipe;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.PropostaItem;
import br.com.gerpro.model.PropostaItemId;


public class ConstruirPropostaBean {
	private UIData objDatatableEquipe;// componente da tela - JSP
	private List<Equipe> listaEquipe;
	private Equipe equipe = new Equipe();
	private Proposta proposta = new Proposta();
	private PropostaItemId PropItemId = new PropostaItemId();
	private PropostaItem propostaItem = new PropostaItem();
	
	private FacadeEquipe daoEquipe = new EquipeDao();
	private FacadeProposta daoProposta = new PropostaDao();
	private FacadePropostaItem daoPropItem = new PropostaItemDao();
	
	public String prepararBean() {
		
		listaEquipe = getDaoEquipe().listar();
	
		return "go_ConstruirProposta";
	}

	public String prepararMetodologia() {
		return "construirMetodologia";
	}
	
	public String prepararMissao() {
		proposta = getDaoProposta().procurarPorId(1);
		equipe = proposta.getEquipe();
	
		//Setando o Id composto do Proposta Item
			PropItemId.setIdItem(1);
			PropItemId.setIdProposta(1);
			propostaItem.setId(PropItemId);
			
		return "construirMissao";
	}
	
	public String SalvarMissao() {

		equipe = proposta.getEquipe();
			
		try {
			//Setando o Id composto do Proposta Item
			PropItemId.setIdItem(1);
				PropItemId.setIdProposta(1);
				propostaItem.setId(PropItemId);
				
				getDaoPropItem().inserir(propostaItem);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prepararBean();
	}

	public String AlterarMissao() {

		equipe = proposta.getEquipe();
			
		try {
			//Setando o Id composto do Proposta Item
			PropItemId.setIdItem(1);
				PropItemId.setIdProposta(1);
				propostaItem.setId(PropItemId);
				
				getDaoPropItem().alterar(propostaItem);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prepararBean();
	}

	public String prepararJustificativa() {
		return "construirJustificativa";
	}
	
	public String prepararCronograma() {
		return "construirCronograma";
	}
	
	public String prepararListaFuncao() {
		return "construirListaFuncoes";
	}
	
	
	
	
	/*public String preperarEdicao() {
		equipe = (Equipe) objDatatableEquipe.getRowData();
		return "alterar";
	}

	public void pesquisar() {
		listaEquipe = getDaoEquipe().listarPorNome(equipe.getNome());
	}

	public String salvar() {
		try {
			getDaoEquipe().inserir(equipe);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prepararBean();
	}

	public String alterar() {
		try {
			getDaoEquipe().alterar(equipe);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "visualizar";
	}

	
	public String excluir() {
		equipe = (Equipe) objDatatableEquipe.getRowData();
		getDaoEquipe().remover(equipe);
		return prepararBean();
	}
*/
	/*
	 * Getters and Setters
	 */


	public void setListaEquipe(List<Equipe> listaEquipe) {
		this.listaEquipe = listaEquipe;
	}

	public List<Equipe> getListaEquipe() {
		return listaEquipe;
	}

	public UIData getObjDatatableEquipe() {
		return objDatatableEquipe;
	}

	public void setObjDatatableEquipe(UIData objDatatableEquipe) {
		this.objDatatableEquipe = objDatatableEquipe;
	}

	public FacadeEquipe getDaoEquipe() {
		return daoEquipe;
	}

	public void setDaoEquipe(FacadeEquipe daoEquipe) {
		this.daoEquipe = daoEquipe;
	}

	/**
	 * @return the propostaItem
	 */
	public PropostaItem getPropostaItem() {
		return propostaItem;
	}

	/**
	 * @param propostaItem the propostaItem to set
	 */
	public void setPropostaItem(PropostaItem propostaItem) {
		this.propostaItem = propostaItem;
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
	 * @return the propItemId
	 */
	public PropostaItemId getPropItemId() {
		return PropItemId;
	}

	/**
	 * @param propItemId the propItemId to set
	 */
	public void setPropItemId(PropostaItemId propItemId) {
		PropItemId = propItemId;
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


}
