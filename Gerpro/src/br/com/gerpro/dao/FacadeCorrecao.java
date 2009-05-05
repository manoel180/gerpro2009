/**
 * 
 */
package br.com.gerpro.dao;

import br.com.gerpro.model.Correcao;

/**
 * @author M3R
 *
 */
public interface FacadeCorrecao {
	public void inserir (Correcao correcao);
	
	public Correcao procurarPorId(Correcao correcao);
	
	public void remover (Correcao correcao);
	
	public void alterar (Correcao correcao);
	
	public Correcao procurarPorNomeProfessor(String Nome);

}
