package br.com.gerpro.model;

// Generated 31/05/2009 15:44:42 by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Artefatos generated by hbm2java
 */
public class Artefatos implements java.io.Serializable {

	private Integer id;
	private String nome;
	private Set cronogramas = new HashSet(0);

	public Artefatos() {
	}

	public Artefatos(String nome) {
		this.nome = nome;
	}

	public Artefatos(String nome, Set cronogramas) {
		this.nome = nome;
		this.cronogramas = cronogramas;
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

	public Set getCronogramas() {
		return this.cronogramas;
	}

	public void setCronogramas(Set cronogramas) {
		this.cronogramas = cronogramas;
	}

}
