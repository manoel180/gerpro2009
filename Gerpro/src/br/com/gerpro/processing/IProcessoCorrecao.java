package br.com.gerpro.processing;

import java.util.List;

import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.PropostaItem;

public interface IProcessoCorrecao {
	
	public boolean vericaSePrimeiraCorrecaodaProposta(Correcao correcao);

	/**
	 * @see br.com.gerpro.processing.IProcessoCorrecao#verificaCorrecoesAnteriores(br.com.gerpro.model.Proposta)
	 */
	public abstract int verificaCorrecoesAnteriores(Proposta propostaView);
	
	
}