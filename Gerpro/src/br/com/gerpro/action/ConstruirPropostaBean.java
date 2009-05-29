package br.com.gerpro.action;

import java.util.List;

import javax.faces.component.UIData;
import javax.swing.JOptionPane;

import br.com.gerpro.dao.FacadeEquipe;
import br.com.gerpro.dao.impl.EquipeDao;
import br.com.gerpro.model.Equipe;


public class ConstruirPropostaBean {
	private UIData objDatatableEquipe;// componente da tela - JSP
	private List<Equipe> listaEquipe;
	private Equipe equipe = new Equipe();
	private FacadeEquipe daoEquipe = new EquipeDao();
	private String teste;
	
	public String prepararBean() {
		equipe = new Equipe();
		listaEquipe = getDaoEquipe().listar();
	
		return "go_ConstruirProposta";
	}

	public String prepararMetodologia() {
		return "construirMetodologia";
	}
	
	public String prepararMissao() {
		return "construirMissao";
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
	
	public void teste(){
		JOptionPane.showMessageDialog(null, teste);
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

	/**
	 * @return the teste
	 */
	public String getTeste() {
		return teste;
	}

	/**
	 * @param teste the teste to set
	 */
	public void setTeste(String teste) {
		this.teste = teste;
	}

}
