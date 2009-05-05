/**
 * 
 */
package br.com.gerpro.dao;

import java.util.List;

import br.com.gerpro.model.Status;
import br.com.gerpro.model.Usuario;


public interface FacadeUsuario {
	public void inserir(Usuario usuario);

	public Status procurarPorMatricula(String matricula);

	public void remover(Usuario usuario);

	public void alterar(Usuario usuario);

	public List<Usuario> listar();

	public List<Usuario> listarPorNome(String nomeStatus);

	public List<Usuario> listarPorOrdemAlfabetica();

	public List<Usuario> listar2();

	public Status procurarPorNome(String nome);
	
	public String logar(Usuario usuario);

}
