/**
 * 
 */
package br.com.gerpro.action;

import java.util.List;

import javax.faces.component.UIData;

import br.com.gerpro.dao.FacadeCorrecao;
import br.com.gerpro.dao.impl.CorrecaoDao;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.CorrecaoId;
import br.com.gerpro.model.Equipe;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Status;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.util.ApplicationSecurityManager;

/**
 * @author M3R
 * 
 */
public class CorrecaoBean {

	private UIData objDatatableCorrecao;// componente da tela - JSP
	private List<Correcao> listaCorrecao;
	private Correcao correcao = new Correcao();
	private FacadeCorrecao correcaoDao = new CorrecaoDao();
	private ApplicationSecurityManager applicationSecurityManager = new ApplicationSecurityManager();

	public String prepararBean() {

		correcao = new Correcao();
		List<Correcao> listaCorrecoesBanco = correcaoDao.procurarPorIdProposta(1);

		return null;// "go_manterEquipe";
	}

	public String preperarInclusao() {
		correcao = new Correcao();
		return "incluir";
	}

	public String preperarEdicao() {
		correcao = (Correcao) objDatatableCorrecao.getRowData();
		return "alterar";
	}
	
	public String preperarCorrecao() {
		Proposta proposta = applicationSecurityManager.getProposta();
		Status status = proposta.getStatus();
		Equipe equipe = proposta.getEquipe();
		return "corrigirProposta";
	}

	public String salvar() {
		try {
			getCorrecaoDao().salvar(correcao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prepararBean();
	}

	public String excluir() {
		correcao = (Correcao) objDatatableCorrecao.getRowData();
		getCorrecaoDao().remover(correcao);
		return prepararBean();
	}	

	public boolean propostaEmCorrecao(Proposta proposta) {

		Usuario professor = applicationSecurityManager.getUsuario();		
		
		listaCorrecao = getCorrecaoDao().procurarPorCorrecao(professor, proposta);

		int contadorItensCorridos = 0;

		for (Correcao correcao : listaCorrecao) {
			System.out.println("Status = " + correcao.getStatus().getNome());
			if (correcao.getStatus().getId() == 7) {
				contadorItensCorridos++;
			}
		}

		if (contadorItensCorridos == 8) {
			return false;
		}
		return true;
	}	

	public UIData getObjDatatableCorrecao() {
		return objDatatableCorrecao;
	}

	public void setObjDatatableCorrecao(UIData objDatatableCorrecao) {
		this.objDatatableCorrecao = objDatatableCorrecao;
	}

	public List<Correcao> getListaCorrecao() {
		return listaCorrecao;
	}

	public void setListaCorrecao(List<Correcao> listaCorrecao) {
		this.listaCorrecao = listaCorrecao;
	}

	public Correcao getCorrecao() {
		return correcao;
	}

	public void setCorrecao(Correcao correcao) {
		this.correcao = correcao;
	}

	public FacadeCorrecao getCorrecaoDao() {
		return correcaoDao;
	}

	public void setCorrecaoDao(FacadeCorrecao correcaoDao) {
		this.correcaoDao = correcaoDao;
	}

}
