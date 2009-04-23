/**
 * 
 */
package Dao;

import java.util.List;

import Model.Proposta;

/**
 * @author Manoel
 *
 */
public interface FacadeProposta {
	
	public void inserir (Proposta proposta);
	
	public Proposta procurarPorId(int idProposta);
	
	public void remover (Proposta proposta);
	
	public void alterar (Proposta proposta);
	
	public List<Proposta> listar();

	public List<Proposta> listarPorNome(String nomeProposta);

	public List<Proposta> listarOrdemAlfabetica();

	public List<Proposta> listar2();
	
	public Proposta procurarPorNome(String Nome);
}
