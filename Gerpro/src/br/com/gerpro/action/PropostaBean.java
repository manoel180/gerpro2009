package br.com.gerpro.action;

import java.util.ArrayList;
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
import br.com.gerpro.model.Usuario;
import br.com.gerpro.util.ApplicationSecurityManager;


public class PropostaBean {
	private UIData objDatatableProposta;
	private List<Proposta> listaProposta;
	private List<Proposta> listaPorProfessor;
	private Proposta proposta = new Proposta();
	private FacadeProposta propostaDao = new PropostaDao() ;
	private FacadeEquipe equipeDao = new EquipeDao();
	private FacadeStatus statusDao = new StatusDao();
	private Equipe equipe = new Equipe();
	private Status status = new Status();
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
	
		
	public String prepararBean() {

		proposta = new Proposta();
		listaProposta = getPropostaDao().listar();
		listaPorProfessor = getListaPorProfessor();
	
		return "go_manterProposta";
	}

	public String preperarInclusao() {
		proposta = new Proposta();
		return "incluir";
	}

	public String preperarEdicao() {
		proposta = (Proposta) objDatatableProposta.getRowData();
		status = proposta.getStatus();
		equipe = proposta.getEquipe();
		
		return "alterar";
	}

	public void pesquisar() {
		listaProposta = getPropostaDao().listarPorNome(proposta.getNome());
	
	}

	public String salvar() {
		try {
			status.setId(1);
			proposta.setEquipe(equipe);
			proposta.setStatus(status);
			getPropostaDao().salvar(proposta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prepararBean();
	}

	
	public String excluir() {
		proposta = (Proposta) objDatatableProposta.getRowData();
		getPropostaDao().remover(proposta);
		return prepararBean();
	}
	
	public String listaPorProfessor(){		
		Usuario usuario = applicationSecurityManager.getUsuario();		
		listaPorProfessor = getPropostaDao().listarPorProfessor(usuario);
		
		return "listarPropostas";
		
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

	public FacadeProposta getPropostaDao() {
		return propostaDao;
	}

	public void setPropostaDao(FacadeProposta propostaDao) {
		this.propostaDao = propostaDao;
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


	public FacadeEquipe getEquipeDao() {
		return equipeDao;
	}


	public void setEquipeDao(FacadeEquipe equipeDao) {
		this.equipeDao = equipeDao;
	}

	public FacadeStatus getStatusDao() {
		return statusDao;
	}

	public void setStatusDao(FacadeStatus statusDao) {
		this.statusDao = statusDao;
	}

	public List<Proposta> getListaPorProfessor() {
		return listaPorProfessor;
	}

	public void setListaPorProfessor(
			List<Proposta> listaPorProfessor) {
		this.listaPorProfessor = listaPorProfessor;
	}

}
