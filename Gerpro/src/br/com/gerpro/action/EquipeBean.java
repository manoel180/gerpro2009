package br.com.gerpro.action;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;

import br.com.gerpro.dao.FacadeEquipe;
import br.com.gerpro.dao.impl.EquipeDao;
import br.com.gerpro.mensagens.PropertiesLoaderImpl;
import br.com.gerpro.model.Equipe;


public class EquipeBean {
	private UIData objDatatableEquipe;// componente da tela - JSP
	private List<Equipe> listaEquipe;
	private Equipe equipe = new Equipe();
	private FacadeEquipe daoEquipe = new EquipeDao();
	
	public String prepararBean() {

		equipe = new Equipe();
		listaEquipe = getDaoEquipe().listar();
	
		return "go_manterEquipe";
	}

	public String prepararInclusao() {
		equipe = new Equipe();
		return "incluirEquipe";
	}

	public String prepararEdicao() {
		equipe = (Equipe) objDatatableEquipe.getRowData();
		return "alterarEquipe";
	}

	public void pesquisar() {
		listaEquipe = getDaoEquipe().listarPorNome(equipe.getNome());
	}

	public String salvar() {
		try {
			getDaoEquipe().salvar(equipe);
			return prepararBean();
		} catch (Exception e) {
			//return new ErroBean().prepararBean("banco_indisponivel");//(PropertiesLoaderImpl.getValor(e.toString()));			
			//e.printStackTrace();
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					PropertiesLoaderImpl.getValor("banco.indisponivel"),PropertiesLoaderImpl.getValor("banco.indisponivel_detail"));
			contexto.addMessage(null, mensagem);			
			
		}
		
		return null;
		
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
