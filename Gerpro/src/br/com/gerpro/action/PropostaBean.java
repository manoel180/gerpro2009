package br.com.gerpro.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
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
	
	
	
	//Gerar Relatorio
	public String gerarRelatorio(){
		JasperPrint relat;
		relat = propostaDao.GerarRelatorio();
		JasperViewer.viewReport(relat, false);
		return "OK";
	}
	
	//ComboBox Equipes
	public SelectItem[] getEquipesCombo(){
		List<Equipe> le = getEquipeDao().listar();
		List<SelectItem> itens = new ArrayList<SelectItem>(le.size());

		for( Equipe e : le ){
			itens.add( new SelectItem(e.getId(),e.getNome()));
		}// for end
		return itens.toArray( new SelectItem[itens.size()] );
	}
	
	//ComboBox Status
	public SelectItem[] getStatusCombo(){
		List<Status> le = getStatusDao().listar();
		List<SelectItem> itens = new ArrayList<SelectItem>(le.size());

		for( Status e : le ){
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
		return "alterar";
	}

	public void pesquisar() {
		listaProposta = getPropostaDao().listarPorNome(proposta.getNome());
	
	}

	public String salvar() {
		try {
						
			proposta.setDataCriacao(new Date("22/03/04"));
			proposta.setDataSubmissao(new Date("22/03/04"));
			
			proposta.setEquipe(equipe);
			proposta.setStatus(status);
			proposta.setPeriodo("001");			
			getPropostaDao().inserir(proposta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prepararBean();
	}

	public String alterar() {
		try {
			getPropostaDao().alterar(proposta);
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
		
		//FacesContext context = FacesContext.getCurrentInstance();		
		//HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		//Usuario usuario = (Usuario) session.getAttribute("usuario");
		Usuario usuario = new Usuario();
		usuario.setMatricula("1");
		System.out.println("Passei por aqui ****** Listar Por Professor ****** Professor: "
				+ usuario.getNome()	);
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
