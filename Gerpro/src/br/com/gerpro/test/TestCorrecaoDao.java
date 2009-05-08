/**
 * 
 */
package br.com.gerpro.test;

import java.util.List;

import br.com.gerpro.dao.impl.CorrecaoDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.processing.IProcessoCorrecao;
import br.com.gerpro.processing.ProcessoCorrecao;

/**
 * @author Clã dos Souza
 *
 */
public class TestCorrecaoDao {
	
	
	
	public static void main(String[] args) {
		Proposta proposta = new Proposta();
		Correcao correcao = new Correcao();
		CorrecaoDao correcaoDao = new CorrecaoDao();
		PropostaDao propostaDao = new PropostaDao();
		IProcessoCorrecao processoCorrecao = new ProcessoCorrecao();
		
		proposta.setId(1);
		int t = processoCorrecao.verificaCorrecoesAnteriores(proposta);
		
		//proposta = propostaDao.procurarPorId(1);		
		//List<Correcao> lista= correcaoDao.procurarPorIdProposta(1);
		
		//System.out.println(correcao.getObservacao());
		
		
	}
	
	

}
