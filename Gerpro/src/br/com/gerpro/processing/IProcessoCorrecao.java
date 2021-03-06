package br.com.gerpro.processing;

import java.util.List;

import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Usuario;

public interface IProcessoCorrecao {

	/**
	 * Processamento n�1: M�todo que processa a corre��o atual,
	 * verificando as repostas dadas aos itens
	 * e atualizando o status da proposta para esta corre��o
	 * com base nas regras de neg�cio informadas pelo cliente.
	 * 
	 *  O M�todo calcularStatusPropostaAtua() � chamado
	 *  para atualizar o status final da proposta no banco de dados 
	 */
	public abstract void calcularStatusPropostaAtual(Usuario professor, Proposta propostaView );

	/**
	 * Processamento n�2: M�todo para c�culo do status da proposta com base na
	 * nova corre��o.
	 */
	public abstract void calcularStatusFinalProposta(Proposta propostaView);	
	
	/**
	 * Alterar o status das correcoes referentes aos itens de uma dada proposta e professor	 
	 */
	public void alteraStatusCorrecoes(List<Correcao> listaCorrecao);

	/**
	 * Verifica se h� corre��es anteriores para esta proposta
	 * ou se a corre��o atual � a primeira corre��o.
	 * 
	 * Retorna true se esta for a primeira corre��o para a proposta em quest�o.
	 *   
	 * @param correcao
	 * @return boolean
	 */
	public abstract boolean vericaSePrimeiraCorrecaodaProposta(Proposta proposta);

}