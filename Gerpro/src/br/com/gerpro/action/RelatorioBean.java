package br.com.gerpro.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.relatorios.ActionRelatorio;

public class RelatorioBean {
	private ActionRelatorio rel = new ActionRelatorio();
	private List<Proposta> listaProposta;
	private int tipo;
	private Proposta proposta = new Proposta();
	private FacadeProposta daoProposta = new PropostaDao();

	// ComboBox Periodos
	public SelectItem[] getPeriodoCombo() {
		List<Proposta> lp = daoProposta.listarPeriodo();
		List<SelectItem> itens = new ArrayList<SelectItem>(lp.size());

		for (Proposta p : lp) {
			itens.add(new SelectItem(p.getPeriodo()));
		}// for end
		return itens.toArray(new SelectItem[itens.size()]);
	}

	public String prepararRelatorio() {
		tipo = 1;
		return "go_relatorio";
	}

	public void exibir() {

		switch (tipo) {
		case 1:
			rel.gerarRelatorioProposta(proposta.getPeriodo());
			break;
		case 2:
			rel.gerarRelatorioResultadosProposta(proposta.getPeriodo());
			break;
		case 3:
			rel.gerarRelatorioProfessorProposta(proposta.getPeriodo());
			break;

		default:
			break;
		}
	}

	/*
	 * Getters and Setters
	 */

	/**
	 * @return the listaProposta
	 */
	public List<Proposta> getListaProposta() {
		return listaProposta;
	}

	/**
	 * @param listaProposta
	 *            the listaProposta to set
	 */
	public void setListaProposta(List<Proposta> listaProposta) {
		this.listaProposta = listaProposta;
	}

	/**
	 * @return the proposta
	 */
	public Proposta getProposta() {
		return proposta;
	}

	/**
	 * @param proposta
	 *            the proposta to set
	 */
	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	/**
	 * @return the tipo
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


}
