package br.com.gerpro.action;

import java.util.List;

import javax.faces.component.UIData;

import br.com.gerpro.dao.FacadeEquipe;
import br.com.gerpro.dao.impl.EquipeDao;
import br.com.gerpro.model.Equipe;



public class EquipeBean {
	private UIData objDatatableEquipe;// componente da tela - JSP
	private List<Equipe> listaEquipe;
	private Equipe equipe = new Equipe();
	private FacadeEquipe equipeDao = new EquipeDao();
	
	public String prepararBean() {

		equipe = new Equipe();
		listaEquipe = getEquipeDao().listar();
	
		return "go_manterEquipe";
	}

	public String preperarInclusao() {
		equipe = new Equipe();
		return "incluir";
	}

	public String preperarEdicao() {
		equipe = (Equipe) objDatatableEquipe.getRowData();
		return "alterar";
	}

	public void pesquisar() {
		listaEquipe = getEquipeDao().listarPorNome(equipe.getNome());
	}

	public String salvar() {
		try {
			getEquipeDao().inserir(equipe);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prepararBean();
	}

	public String alterar() {
		try {
			getEquipeDao().alterar(equipe);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "visualizar";
	}

	
	public String excluir() {
		equipe = (Equipe) objDatatableEquipe.getRowData();
		getEquipeDao().remover(equipe);
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

	public FacadeEquipe getEquipeDao() {
		return equipeDao;
	}

	public void setEquipeDao(FacadeEquipe equipeDao) {
		this.equipeDao = equipeDao;
	}

}
