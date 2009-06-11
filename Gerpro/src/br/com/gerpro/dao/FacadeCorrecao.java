/**
 * 
 */
package br.com.gerpro.dao;

import java.util.List;

import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Usuario;

/**
 * @author M3R
 *
 */
public interface FacadeCorrecao {
	public void salvar (Correcao correcao);
	
	public List<Correcao> procurarPorIdProposta(int idProposta);
	
	public void remover (Correcao correcao);
	
	public Correcao procurarPorNomeProfessor(String Nome);
	
	public List<Correcao> procurarPorCorrecao(Usuario professor, Proposta proposta);//Correcao correcaoId);

}
