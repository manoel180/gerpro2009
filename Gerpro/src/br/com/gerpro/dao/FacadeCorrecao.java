/**
 * 
 */
package br.com.gerpro.dao;

import java.util.List;

import br.com.gerpro.model.Correcao;

/**
 * @author M3R
 *
 */
public interface FacadeCorrecao {
	public void inserir (Correcao correcao);
	
	public List<Correcao> procurarPorIdProposta(int idProposta);
	
	public void remover (Correcao correcao);
	
	public void alterar (Correcao correcao);
	
	public Correcao procurarPorNomeProfessor(String Nome);
	
	public List<Correcao> procurarPorCorrecao(Correcao correcaoId);

}
