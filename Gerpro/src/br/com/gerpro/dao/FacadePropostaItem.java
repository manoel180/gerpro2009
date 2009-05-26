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
	
	public void inserir (PropostaItem propostaitem);
	
	public PropostaItem procurarPorId(int idPropostaItem);
	
	public void remover (PropostaItem propostaitem);
	
	public void alterar (PropostaItem propostaitem);
	
	public List<PropostaItem> listar();

	public List<PropostaItem> listarPorNome(String nomePropostaItem);

	public List<PropostaItem> listarOrdemAlfabetica();

	public List<PropostaItem> listar2();
	
	public PropostaItem procurarPorNome(String Nome);
}
