/**
 * 
 */
package br.com.gerpro.dao;

import java.util.List;

import br.com.gerpro.model.PropostaItem;


/**
 * @author Manoel
 *
 */
public interface FacadePropostaItem {
	
	public void salvar (PropostaItem propostaitem);
	
	public PropostaItem procurarPorId(int idPropostaItem);
	
	public void remover (PropostaItem propostaitem);
	
	public List<PropostaItem> listar();

	public List<PropostaItem> listarPorNome(String nomePropostaItem);
	
	public PropostaItem procurarPorNome(String Nome);
}
