package br.com.gerpro.model;

// Generated 31/05/2009 15:44:42 by Hibernate Tools 3.2.2.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Proposta generated by hbm2java
 */
public class Proposta implements java.io.Serializable {

	private Integer id;
	private Equipe equipe;
	private Status status;
	private String nome;
	private Date dataCriacao;
	private Date dataSubmissao;
	private String periodo;
	private Set propostaItems = new HashSet(0);

	public Proposta() {
	}

	public Proposta(Equipe equipe, Status status, String nome,
			Date dataCriacao, String periodo) {
		this.equipe = equipe;
		this.status = status;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.periodo = periodo;
	}

	public Proposta(Equipe equipe, Status status, String nome,
			Date dataCriacao, Date dataSubmissao, String periodo,
			Set propostaItems) {
		this.equipe = equipe;
		this.status = status;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.dataSubmissao = dataSubmissao;
		this.periodo = periodo;
		this.propostaItems = propostaItems;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Equipe getEquipe() {
		return this.equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataSubmissao() {
		return this.dataSubmissao;
	}

	public void setDataSubmissao(Date dataSubmissao) {
		this.dataSubmissao = dataSubmissao;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Set getPropostaItems() {
		return this.propostaItems;
	}

	public void setPropostaItems(Set propostaItems) {
		this.propostaItems = propostaItems;
	}

}
