/**
 * 
 */
package br.com.gerpro.dao;

import java.util.List;

import br.com.gerpro.model.Artefatos;


/**
 * @author M3R
 *
 */
public interface FacadeArtefatos {
	
	public void salvar (Artefatos artefatos);
	
	public Artefatos procurarPorId(int idArtefatos);
	
	public void remover (Artefatos artefatos);
	
	public List<Artefatos> listar();

	public List<Artefatos> listarPorNome(String nomeArtefatos);

	public Artefatos procurarPorNome(String Nome);
}
