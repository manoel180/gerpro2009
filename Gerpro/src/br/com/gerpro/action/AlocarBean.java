package br.com.gerpro.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.model.SelectItem;

import br.com.gerpro.dao.FacadeEquipe;
import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.dao.impl.EquipeDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.dao.impl.UsuarioDao;
import br.com.gerpro.mensagens.MessageManagerImpl;
import br.com.gerpro.model.Equipe;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.TipoUsuario;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.processing.IProcessoAlocarProposta;
import br.com.gerpro.processing.ProcessoAlocarProposta;

public class AlocarBean {

	private List<String> listProfessores = new ArrayList<String>();
	private List<String> listAlunos = new ArrayList<String>();
	private FacadeUsuario daoUsuario = new UsuarioDao();
	private FacadeEquipe equipeDao = new EquipeDao();
	private Equipe equipe = new Equipe();
	private Usuario usuario = new Usuario();
	private IProcessoAlocarProposta alocarProposta = new ProcessoAlocarProposta();
	private FacadeProposta propostaDao = new PropostaDao();
	private boolean desabilitar;
	private boolean desabilitarTodos;
	private boolean desabilitarBotaoAlocar;
	private boolean correcaoGrupo;

	public void desabilitar() {
		if (listProfessores.size() >= 2) {
			desabilitarTodos = true;
			desabilitar = true;
		} else {
			desabilitarTodos = false;
			desabilitar = false;
		}
	}
	
	private void desabilitarBotaoAlocar() {
		if (semPropostaParaAlocar()) {
			desabilitarBotaoAlocar = true;
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_INFO,
					"aviso",
					"sem.proposta.para.alocar");
		} else {
			desabilitarBotaoAlocar = false;
			
		}
	}

	public String prepararBean() {
		correcaoGrupo = true;
		desabilitarBotaoAlocar();
		return "alocarProposta";
	}
	
	public String preparaAlocarAlunoEquipe(){
	equipe = new Equipe();
	listAlunos = new ArrayList<String>();
		return "alocarAlunoEquipe";
	}
	
	// ComboBox Equipes
	public SelectItem[] getEquipesCombo() {
		List<Equipe> le = equipeDao.listar();
		List<SelectItem> itens = new ArrayList<SelectItem>(le.size());

		for (Equipe e : le) {
			itens.add(new SelectItem(e.getId(), e.getNome()));
		}// for end
		return itens.toArray(new SelectItem[itens.size()]);
	}
	
	
	// Lista de Professores
	public SelectItem[] getProfessorCombo() {
		List<Usuario> lu = daoUsuario.listarProfessoresParaCorrecao();
		List<SelectItem> itens = new ArrayList<SelectItem>(lu.size());

		for (Usuario u : lu) {
			itens.add(new SelectItem(u.getMatricula(), u.getNome()));
		}// for end
		if (lu.size() < 2) {
			desabilitarTodos = false;
		} else {
			desabilitarTodos = true;
		}
		return itens.toArray(new SelectItem[itens.size()]);
	}

	// Lista de Alunos
	public SelectItem[] getAlunosCombo() {
		List<Usuario> lu = daoUsuario.listarAlunos();
		List<SelectItem> itens = new ArrayList<SelectItem>(lu.size());

		for (Usuario u : lu) {
			itens.add(new SelectItem(u.getMatricula(), u.getNome()));
		}// for end
		return itens.toArray(new SelectItem[itens.size()]);
	}
	
	
	public void alocar() {
		try {
			alocarProposta.alocaProposta(listProfessores, correcaoGrupo);
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_INFO,
					"sucesso", "sucesso.alocar.proposta_detail");			
			
		} catch (Exception e) {
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
					"erro", "erro.alocar.propostas");
		}		
	}
	
	public void alocarAlunos() {
		int i=0;
		TipoUsuario tipoUsuario = new TipoUsuario();
		try {
			for (i=0;i<listAlunos.size();i++) {
				usuario=daoUsuario.procurarPorMatricula(listAlunos.get(i).toString());
				
				usuario.setEquipe(equipe);
				System.out.println(usuario.getMatricula()+" "+usuario.getEquipe().getId());
				daoUsuario.salvar(usuario);
			}
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_INFO,
					"sucesso", "sucesso.alocar.proposta_detail");			
			
		} catch (Exception e) {
			System.out.println(e);
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
					"erro", "erro.alocar.propostas");
		}		
	}
	
	@SuppressWarnings("unchecked")
	public boolean semPropostaParaAlocar(){
		List<Proposta> listaPropostaConcluidas = propostaDao.listarPropostasConcluidas();
		if(listaPropostaConcluidas.isEmpty()){
			return true;
		}else
			return false;
	}
	

	/**
	 * @return the listProfessores
	 */
	public List<String> getListProfessores() {
		return listProfessores;
	}

	/**
	 * @param listProfessores
	 *            the listProfessores to set
	 */
	public void setListProfessores(List<String> listProfessores) {
		this.listProfessores = listProfessores;
	}

	/**
	 * @return the desabilitar
	 */
	public boolean isDesabilitar() {
		return desabilitar;
	}

	/**
	 * @param desabilitar
	 *            the desabilitar to set
	 */
	public void setDesabilitar(boolean desabilitar) {
		this.desabilitar = desabilitar;
	}

	/**
	 * @return the desabilitarTodos
	 */
	public boolean isDesabilitarTodos() {
		return desabilitarTodos;
	}

	/**
	 * @param desabilitarTodos
	 *            the desabilitarTodos to set
	 */
	public void setDesabilitarTodos(boolean desabilitarTodos) {
		this.desabilitarTodos = desabilitarTodos;
	}

	/**
	 * @return the correcaoGrupo
	 */
	public boolean isCorrecaoGrupo() {
		return correcaoGrupo;
	}

	/**
	 * @param correcaoGrupo the correcaoGrupo to set
	 */
	public void setCorrecaoGrupo(boolean correcaoGrupo) {
		this.correcaoGrupo = correcaoGrupo;
	}

	/**
	 * @return the listAlunos
	 */
	public List<String> getListAlunos() {
		return listAlunos;
	}

	/**
	 * @param listAlunos the listAlunos to set
	 */
	public void setListAlunos(List<String> listAlunos) {
		this.listAlunos = listAlunos;
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
	 * @return the desabilitarBotaoAlocar
	 */
	public boolean isDesabilitarBotaoAlocar() {
		return desabilitarBotaoAlocar;
	}

	/**
	 * @param desabilitarBotaoAlocar the desabilitarBotaoAlocar to set
	 */
	public void setDesabilitarBotaoAlocar(boolean desabilitarBotaoAlocar) {
		this.desabilitarBotaoAlocar = desabilitarBotaoAlocar;
	}
	
	

}
