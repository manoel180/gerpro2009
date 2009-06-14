/**
 * 
 */
package br.com.gerpro.dao;

import java.util.List;

import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.CorrecaoId;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Usuario;

/**
 * @author M3R
 *
 */
public interface FacadeCorrecao {
	public void salvar (Correcao correcao);
	
	public Correcao procurarPorIdCorrecao(CorrecaoId idCorrecao);
	
	public void remover (Correcao correcao);
	
	public Correcao procurarPorNomeProfessor(String Nome);
	
	public List<Correcao> procurarPorCorrecao(Usuario professor, Proposta proposta);

}
