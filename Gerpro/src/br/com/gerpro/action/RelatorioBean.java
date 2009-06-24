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
	private boolean desabilitar1,desabilitar2,desabilitar3;
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

	public String prepararRelatorioPropostaEquipe() {

		tipo = 1;
		desabilitar1 = false;
		desabilitar2 = true;
		desabilitar3 = true;
		return "go_relatorio";
	}

	public String prepararRelatorioResultadoProposta() {

		tipo = 2;

		desabilitar1 = true;
		desabilitar2 = false;
		desabilitar3 = true;
		return "go_relatorio";
	}

	public String prepararRelatorioProfessorProposta() {

		tipo = 3;

		desabilitar1 = true;
		desabilitar2 = true;
		desabilitar3 = false;
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
		if (tipo == 1) {

		} else {

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

	/**
	 * @return the desabilitar1
	 */
	public boolean isDesabilitar1() {
		return desabilitar1;
	}

	/**
	 * @param desabilitar1 the desabilitar1 to set
	 */
	public void setDesabilitar1(boolean desabilitar1) {
		this.desabilitar1 = desabilitar1;
	}

	/**
	 * @return the desabilitar2
	 */
	public boolean isDesabilitar2() {
		return desabilitar2;
	}

	/**
	 * @param desabilitar2 the desabilitar2 to set
	 */
	public void setDesabilitar2(boolean desabilitar2) {
		this.desabilitar2 = desabilitar2;
	}

	/**
	 * @return the desabilitar3
	 */
	public boolean isDesabilitar3() {
		return desabilitar3;
	}

	/**
	 * @param desabilitar3 the desabilitar3 to set
	 */
	public void setDesabilitar3(boolean desabilitar3) {
		this.desabilitar3 = desabilitar3;
	}

}
