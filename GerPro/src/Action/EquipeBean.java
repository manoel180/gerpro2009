package Action;

import java.util.List;

import javax.faces.component.UIData;

import Dao.FacadeEquipe;
import Dao.Impl.daoEquipe;
import Model.Equipe;

public class EquipeBean {
	private UIData objDatatableEquipe;// componente da tela - JSP
	private List<Equipe> listaEquipe;
	private Equipe equipe = new Equipe();
	private FacadeEquipe daoEquipe = new daoEquipe();
	
	public String prepararBean() {

		equipe = new Equipe();
		listaEquipe = getDaoEquipe().listar();
	
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
