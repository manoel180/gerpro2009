/**
 * 
 */
package br.com.gerpro.processing;

import java.util.List;

import br.com.gerpro.dao.FacadeCorrecao;
import br.com.gerpro.dao.impl.CorrecaoDao;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Proposta;

/**
 * @author msouza
 *
 */
public class ProcessoCorrecao implements IProcessoCorrecao {
	/* (non-Javadoc)
	 * @see br.com.gerpro.processing.IProcessoCorrecao#verificaCorrecoesAnteriores(br.com.gerpro.model.Proposta)
	 */
	public int verificaCorrecoesAnteriores(Proposta propostaView){
		FacadeCorrecao correcaoDao = new CorrecaoDao();
		//FacadeProposta propostaDao = new PropostaDao();
		//Proposta propostaBanco;
		
		/**
		 * Verifica  se existem correcoes para uma proposta
		 */		
		List<Correcao> listaCorrecoesRealizadas = correcaoDao.procurarPorIdProposta(propostaView.getId());
		
		if (listaCorrecoesRealizadas.isEmpty()) {
			System.out.println("Não há correções");
			return 0;			
		}else
			System.out.println("Há correções");		
		
		return listaCorrecoesRealizadas.size();
		
	}

	/* (non-Javadoc)
	 * @see br.com.gerpro.processing.IProcessoCorrecao#compararCorrecaoItem(br.com.gerpro.model.Correcao, java.util.List)
	 */
	@Override
	public void compararCorrecaoItem(Correcao correcao, List<Correcao> listaBanco) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see br.com.gerpro.processing.IProcessoCorrecao#executar(br.com.gerpro.model.Correcao)
	 */
	@Override
	public void executar(Correcao correcao) {
		/**
		 * verificar se a proposta já possue correcao e quantas correções já foram feitas.
		 */
		
	}

}
