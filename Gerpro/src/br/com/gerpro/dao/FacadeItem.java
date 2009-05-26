/**
 * 
 */
package br.com.gerpro.dao;

import java.util.List;

import br.com.gerpro.model.Item;


/**
 * @author Manoel
 *
 */
public interface FacadeItem {
	
	public void inserir (Item item);
	
	public Item procurarPorId(int idItem);
	
	public void remover (Item item);
	
	public void alterar (Item item);
	
	public List<Item> listar();

	public List<Item> listarPorNome(String nomeItem);

	public List<Item> listarOrdemAlfabetica();

	public List<Item> listar2();
	
	public Item procurarPorNome(String Nome);
}
