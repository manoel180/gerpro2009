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
	
	public void inserir (Artefatos artefatos);
	
	public Artefatos procurarPorId(int idArtefatos);
	
	public void remover (Artefatos artefatos);
	
	public void alterar (Artefatos artefatos);
	
	public List<Artefatos> listar();

	public List<Artefatos> listarPorNome(String nomeArtefatos);

	public List<Artefatos> listarOrdemAlfabetica();

	public List<Artefatos> listar2();
	
	public Artefatos procurarPorNome(String Nome);
}
