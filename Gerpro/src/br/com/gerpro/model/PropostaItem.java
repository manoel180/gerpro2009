package br.com.gerpro.model;

// Generated 31/05/2009 15:44:42 by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

/**
 * PropostaItem generated by hbm2java
 */
public class PropostaItem implements java.io.Serializable {

	private PropostaItemId id;
	private Item item;
	private Status status;
	private Proposta proposta;
	private String conteudoItem;
	private Set cronogramas = new HashSet(0);
	private Set listaFuncaos = new HashSet(0);
	private Set correcaos = new HashSet(0);

	public PropostaItem() {
	}

	public PropostaItem(PropostaItemId id, Item item, Proposta proposta) {
		this.id = id;
		this.item = item;
		this.proposta = proposta;
	}

	public PropostaItem(PropostaItemId id, Item item, Status status,
			Proposta proposta, String conteudoItem, Set cronogramas,
			Set listaFuncaos, Set correcaos) {
		this.id = id;
		this.item = item;
		this.status = status;
		this.proposta = proposta;
		this.conteudoItem = conteudoItem;
		this.cronogramas = cronogramas;
		this.listaFuncaos = listaFuncaos;
		this.correcaos = correcaos;
	}

	public PropostaItemId getId() {
		return this.id;
	}

	public void setId(PropostaItemId id) {
		this.id = id;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Proposta getProposta() {
		return this.proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	public String getConteudoItem() {
		return this.conteudoItem;
	}

	public void setConteudoItem(String conteudoItem) {
		this.conteudoItem = conteudoItem;
	}

	public Set getCronogramas() {
		return this.cronogramas;
	}

	public void setCronogramas(Set cronogramas) {
		this.cronogramas = cronogramas;
	}

	public Set getListaFuncaos() {
		return this.listaFuncaos;
	}

	public void setListaFuncaos(Set listaFuncaos) {
		this.listaFuncaos = listaFuncaos;
	}

	public Set getCorrecaos() {
		return this.correcaos;
	}

	public void setCorrecaos(Set correcaos) {
		this.correcaos = correcaos;
	}

}
