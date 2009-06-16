/**
 * 
 */
package br.com.gerpro.dao;

import java.util.List;

import br.com.gerpro.model.Usuario;


public interface FacadeUsuario {
	public void salvar(Usuario usuario);

	public Usuario procurarPorMatricula(String matricula);

	public void remover(Usuario usuario);	

	public List<Usuario> listar();

	public List<Usuario> listarPorNome(String nomeStatus);

	public Usuario procurarPorNome(String nome);

	
	/**
	 * @param id
	 * @return
	 */
	public List<Usuario> listarPorEquipe(int id);
}
