/**
 * 
 */
package br.com.gerpro.dao;

import java.util.List;

import br.com.gerpro.model.Usuario;


public interface FacadeUsuario {
	public void salvar(Usuario usuario);

	public Usuario procurarPorMatricula(String matricula);		

	public List<Usuario> listar();

	public List<Usuario> listarPorNome(String nomeStatus);

	public Usuario procurarPorNome(String nome);
	
	/**
	 * @param id
	 * @return Lista de usuarios do tipo Aluno de uma determinada equipe
	 */
	public List<Usuario> listarPorEquipe(int id);

	/**
	 * @return Lista de usuario do tipo Professor
	 */
	public List<Usuario> listarProfessores();
	
	public List<Usuario> listarProfessoresParaCorrecao();

	/**
	 * @return
	 */
	public List<Usuario> listarAlunos();
}
