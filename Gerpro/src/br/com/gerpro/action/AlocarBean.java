package br.com.gerpro.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.model.SelectItem;

import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.dao.impl.UsuarioDao;
import br.com.gerpro.mensagens.MessageManagerImpl;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.processing.IProcessoAlocarProposta;
import br.com.gerpro.processing.ProcessoAlocarProposta;

public class AlocarBean {

	private List<String> listProfessores = new ArrayList<String>();
	private FacadeUsuario daoUsuario = new UsuarioDao();
	private IProcessoAlocarProposta alocarProposta = new ProcessoAlocarProposta();
	private boolean desabilitar;
	private boolean desabilitarTodos;
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

	public String prepararBean() {
		correcaoGrupo = true;
		return "alocarProposta";
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

}
