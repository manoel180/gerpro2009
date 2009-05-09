package br.com.gerpro.processing;

import java.util.List;

import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Proposta;

public interface IProcessoCorrecao {

	/**
	 * @see br.com.gerpro.processing.IProcessoCorrecao#verificaCorrecoesAnteriores(br.com.gerpro.model.Proposta)
	 */
	public abstract int verificaCorrecoesAnteriores(Proposta propostaView);

	public abstract void compararCorrecaoItem(Correcao correcao,
			List<Correcao> listaBanco);

	public abstract void executar(Correcao correcao);

}