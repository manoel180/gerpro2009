/**
 * 
 */
package br.com.gerpro.dao;

import java.util.List;

import br.com.gerpro.model.TipoFuncao;


/**
 * @author Manoel
 *
 */
public interface FacadeTipoFuncao {
	
	public void salvar (TipoFuncao tipofuncao);
	
	public TipoFuncao procurarPorId(int idEquipe);
	
	public void remover (TipoFuncao tipofuncao);
	
	public List<TipoFuncao> listar();

	public List<TipoFuncao> listarPorNome(String nomeTipoFuncao);
	
	public TipoFuncao procurarPorNome(String Nome);
}
