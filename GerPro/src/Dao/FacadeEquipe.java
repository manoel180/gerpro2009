/**
 * 
 */
package Dao;

import java.util.List;

import Model.Equipe;

/**
 * @author Manoel
 *
 */
public interface FacadeEquipe {
	
	public void inserir (Equipe equipe);
	
	public Equipe procurarPorId(int idEquipe);
	
	public void remover (Equipe equipe);
	
	public void alterar (Equipe equipe);
	
	public List<Equipe> listar();

	public List<Equipe> listarPorNome(String nomeEquipe);

	public List<Equipe> listarOrdemAlfabetica();

	public List<Equipe> listar2();
	
	public Equipe procurarPorNome(String Nome);
}
