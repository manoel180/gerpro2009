package Model;

// Generated 18/04/2009 12:04:57 by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Status generated by hbm2java
 */
public class Status implements java.io.Serializable {

	private Integer id;
	private String nome;
	private Set<Proposta> propostas = new HashSet<Proposta>(0);
	private Set<PropostaItem> propostaItems = new HashSet<PropostaItem>(0);

	public Status() {
	}

	public Status(String nome) {
		this.nome = nome;
	}

	public Status(String nome, Set<Proposta> propostas,
			Set<PropostaItem> propostaItems) {
		this.nome = nome;
		this.propostas = propostas;
		this.propostaItems = propostaItems;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Proposta> getPropostas() {
		return this.propostas;
	}

	public void setPropostas(Set<Proposta> propostas) {
		this.propostas = propostas;
	}

	public Set<PropostaItem> getPropostaItems() {
		return this.propostaItems;
	}

	public void setPropostaItems(Set<PropostaItem> propostaItems) {
		this.propostaItems = propostaItems;
	}

}