package br.com.gerpro.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.dao.impl.UsuarioDao;
import br.com.gerpro.model.Usuario;

public class AlocarBean {

	private List<Usuario> listProfessores = new ArrayList<Usuario>();
	private FacadeUsuario daoUsuario = new UsuarioDao();
	
	private boolean desabilitar;

	public void desabilitar(){
		if(listProfessores.size()==2){
			desabilitar = true;
		}else{
			desabilitar = false;
		}
	}
	
	// Lista de Professores
	public SelectItem[] getProfessorCombo() {
		List<Usuario> lu = daoUsuario.listarProfessores();
		List<SelectItem> itens = new ArrayList<SelectItem>(lu.size());

		for (Usuario u : lu) {
			itens.add(new SelectItem(u.getMatricula(), u.getNome()));
		}// for end
		return itens.toArray(new SelectItem[itens.size()]);
	}
	public void teste(){
		listProfessores.get(1);
	}
	
	/**
	 * @return the listProfessores
	 */
	public List<Usuario> getListProfessores() {
		return listProfessores;
	}

	/**
	 * @param listProfessores the listProfessores to set
	 */
	public void setListProfessores(List<Usuario> listProfessores) {
		this.listProfessores = listProfessores;
	}

	/**
	 * @return the desabilitar
	 */
	public boolean isDesabilitar() {
		return desabilitar;
	}

	/**
	 * @param desabilitar the desabilitar to set
	 */
	public void setDesabilitar(boolean desabilitar) {
		this.desabilitar = desabilitar;
	}
	
}
