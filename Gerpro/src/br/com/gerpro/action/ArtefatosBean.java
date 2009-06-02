package br.com.gerpro.action;

import java.util.List;

import javax.faces.component.UIData;

import br.com.gerpro.dao.FacadeArtefatos;
import br.com.gerpro.dao.impl.ArtefatosDao;
import br.com.gerpro.model.Artefatos;


public class ArtefatosBean {
	private UIData objDatatableArtefatos;// componente da tela - JSP
	private List<Artefatos> listaArtefatos;
	private Artefatos artefatos = new Artefatos();
	private FacadeArtefatos daoArtefatos = new ArtefatosDao();
	
	public String prepararBean() {

		artefatos = new Artefatos();
		listaArtefatos = getDaoArtefatos().listar();
	
		return "go_manterArtefatos";
	}

	public String preperarInclusao() {
		artefatos = new Artefatos();
		return "incluir";
	}

	public String preperarEdicao() {
		artefatos = (Artefatos) objDatatableArtefatos.getRowData();
		return "alterar";
	}

	public void pesquisar() {
		listaArtefatos = getDaoArtefatos().listarPorNome(artefatos.getNome());
	}

	public String salvar() {
		try {
			getDaoArtefatos().salvar(artefatos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prepararBean();
	}

	
	public String excluir() {
		artefatos = (Artefatos) objDatatableArtefatos.getRowData();
		getDaoArtefatos().remover(artefatos);
		return prepararBean();
	}

	/*
	 * Getters and Setters
	 */

	public Artefatos getArtefatos() {
		return artefatos;
	}

	public void setArtefatos(Artefatos artefatos) {
		this.artefatos = artefatos;
	}

	public void setListaArtefatos(List<Artefatos> listaArtefatos) {
		this.listaArtefatos = listaArtefatos;
	}

	public List<Artefatos> getListaArtefatos() {
		return listaArtefatos;
	}

	public UIData getObjDatatableArtefatos() {
		return objDatatableArtefatos;
	}

	public void setObjDatatableArtefatos(UIData objDatatableArtefatos) {
		this.objDatatableArtefatos = objDatatableArtefatos;
	}

	public FacadeArtefatos getDaoArtefatos() {
		return daoArtefatos;
	}

	public void setDaoArtefatos(FacadeArtefatos daoArtefatos) {
		this.daoArtefatos = daoArtefatos;
	}

}
