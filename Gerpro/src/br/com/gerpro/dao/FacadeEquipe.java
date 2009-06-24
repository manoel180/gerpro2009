/**
 * 
 */
package br.com.gerpro.dao;

import java.util.List;

import br.com.gerpro.model.Equipe;


/**
 * @author Manoel
 *
 */
public interface FacadeEquipe {
	
	public void salvar (Equipe equipe);
	
	public Equipe procurarPorId(int idEquipe);
	
	public void remover (Equipe equipe);
		
	public List<Equipe> listar();
	
	public List<Equipe> listarEquipesSemProposta();

	public List<Equipe> listarPorNome(String nomeEquipe);
	
	public Equipe procurarPorNome(String Nome);
}
