package br.com.gerpro.model;

// Generated 18/04/2009 12:04:57 by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

/**
 * TipoUsuario generated by hbm2java
 */
public class TipoUsuario implements java.io.Serializable {

	private Integer id;
	private String nome;
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public TipoUsuario() {
	}

	public TipoUsuario(String nome, Set<Usuario> usuarios) {
		this.nome = nome;
		this.usuarios = usuarios;
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

	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
