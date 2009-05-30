package br.com.gerpro.dao;

import java.util.List;

import br.com.gerpro.model.ListaFuncao;

/**
 * @author M3R
 *
 */
public interface FacadeListaFuncao {
	public void inserir (ListaFuncao listafuncao);
	
	public ListaFuncao procurarPorId(int idlistafuncao);
	
	public void remover (ListaFuncao listafuncao);
	
	public void alterar (ListaFuncao listafuncao);
	
	public List<ListaFuncao> listar();

	public List<ListaFuncao> listarPorNome(String nomelistafuncao);

	public ListaFuncao procurarPorNome(String Nome);
	

}
