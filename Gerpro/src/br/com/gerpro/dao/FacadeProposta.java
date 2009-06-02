/**
 * 
 */
package br.com.gerpro.dao;

import java.util.List;

import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Usuario;


/**
 * @author Manoel
 *
 */
public interface FacadeProposta {
	
	public void salvar (Proposta proposta);
	
	public Proposta procurarPorId(int idProposta);
	
	public void remover (Proposta proposta);
	
	public List<Proposta> listar();

	public List<Proposta> listarPorNome(String nomeProposta);

	public List<Proposta> listarPorProfessor(Usuario usuario);
	
	public Proposta procurarPorNome(String Nome);

}
