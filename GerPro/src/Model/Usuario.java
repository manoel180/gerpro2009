package br.com.gerpro.model;

// Generated 18/04/2009 12:04:57 by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

	private String matricula;
	private Equipe equipe;
	private TipoUsuario tipoUsuario;
	private String nome;
	private String senha;
	private Set<Correcao> correcaos = new HashSet<Correcao>(0);

	public Usuario() {
	}

	public Usuario(String matricula, TipoUsuario tipoUsuario, String nome,
			String senha) {
		this.matricula = matricula;
		this.tipoUsuario = tipoUsuario;
		this.nome = nome;
		this.senha = senha;
	}

	public Usuario(String matricula, Equipe equipe, TipoUsuario tipoUsuario,
			String nome, String senha, Set<Correcao> correcaos) {
		this.matricula = matricula;
		this.equipe = equipe;
		this.tipoUsuario = tipoUsuario;
		this.nome = nome;
		this.senha = senha;
		this.correcaos = correcaos;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Equipe getEquipe() {
		return this.equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Correcao> getCorrecaos() {
		return this.correcaos;
	}

	public void setCorrecaos(Set<Correcao> correcaos) {
		this.correcaos = correcaos;
	}

}
