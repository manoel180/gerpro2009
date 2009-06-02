/**
 * 
 */
package br.com.gerpro.dao;

import java.util.List;

import br.com.gerpro.model.Status;


/**
 * @author Manoel
 *
 */
public interface FacadeStatus {
	
	public void salvar (Status equipe);
	
	public Status procurarPorId(int idStatus);
	
	public void remover (Status equipe);
	
	public List<Status> listar();

	public List<Status> listarPorNome(String nomeStatus);
	
	public Status procurarPorNome(String Nome);
}
