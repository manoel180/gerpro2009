package br.com.gerpro.action;

import java.util.List;

import javax.faces.component.UIData;

import br.com.gerpro.dao.FacadeEquipe;
import br.com.gerpro.dao.impl.EquipeDao;
import br.com.gerpro.model.Equipe;


public class ConstruirPropostaBean {
	private UIData objDatatableEquipe;// componente da tela - JSP
	private List<Equipe> listaEquipe;
	private Equipe equipe = new Equipe();
	private FacadeEquipe daoEquipe = new EquipeDao();
	
	public String prepararBean() {
		equipe = new Equipe();
		listaEquipe = getDaoEquipe().listar();
	
		return "go_ConstruirProposta";
	}

	public void preperarMetodologia() {
		// "construirMetodologia";
	}
	
	public String prepararMissao() {
		return "construirMissao";
	}

	public String preperarJustificativa() {
		return "construirJustificativa";
	}
	
	public String preperarCronograma() {
		return "construirCronograma";
	}
	
	public String preperarListaFuncao() {
		return "construirListaFuncao";
	}
	
	
	
	public String preperarEdicao() {
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

	/*
	 * Getters and Setters
	 */

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

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

}