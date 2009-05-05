/**
 * 
 */
package br.com.gerpro.processing;

import br.com.gerpro.dao.FacadeCorrecao;
import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.impl.CorrecaoDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.model.Proposta;

/**
 * @author msouza
 *
 */
public class ProcessoCorrecao {
	public Boolean verificaCorrecoesAnteriores(Proposta propostaView){
		FacadeCorrecao correcaoDao = new CorrecaoDao();
		FacadeProposta propostaDao = new PropostaDao();
		Proposta propostaBanco;
		
		/**
		 * Verifica  se existem correcoes para uma proposta
		 */		
		propostaBanco = propostaDao.procurarPorId(propostaView.getId());
		
		//if (propostaBanco.getPropostaItems().) {
			
		//}
				
		return null;
		
	}

}
