/**
 * 
 */
package Dao;

import java.util.List;

import Model.Status;

/**
 * @author Manoel
 *
 */
public interface FacadeStatus {
	
	public void inserir (Status equipe);
	
	public Status procurarPorId(int idStatus);
	
	public void remover (Status equipe);
	
	public void alterar (Status equipe);
	
	public List<Status> listar();

	public List<Status> listarPorNome(String nomeStatus);

	public List<Status> listarOrdemAlfabetica();

	public List<Status> listar2();
	
	public Status procurarPorNome(String Nome);
}
