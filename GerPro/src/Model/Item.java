package Model;

// Generated 18/04/2009 12:04:57 by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Item generated by hbm2java
 */
public class Item implements java.io.Serializable {

	private Integer id;
	private String nome;
	private Set<Pergunta> perguntas = new HashSet<Pergunta>(0);
	private Set<PropostaItem> propostaItems = new HashSet<PropostaItem>(0);

	public Item() {
	}

	public Item(String nome) {
		this.nome = nome;
	}

	public Item(String nome, Set<Pergunta> perguntas,
			Set<PropostaItem> propostaItems) {
		this.nome = nome;
		this.perguntas = perguntas;
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

	public Set<Pergunta> getPerguntas() {
		return this.perguntas;
	}

	public void setPerguntas(Set<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public Set<PropostaItem> getPropostaItems() {
		return this.propostaItems;
	}

	public void setPropostaItems(Set<PropostaItem> propostaItems) {
		this.propostaItems = propostaItems;
	}

}
