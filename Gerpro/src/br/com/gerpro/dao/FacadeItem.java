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
	
	public void salvar (Item item);
	
	public Item procurarPorId(int idItem);
	
	public void remover (Item item);
	
	public List<Item> listar();

	public List<Item> listarPorNome(String nomeItem);
	
	public Item procurarPorNome(String Nome);
}
