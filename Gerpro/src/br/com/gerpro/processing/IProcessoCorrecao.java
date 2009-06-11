package br.com.gerpro.processing;

import java.util.List;

import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Usuario;

public interface IProcessoCorrecao {

	/**
	 * Processamento nº1: Método que processa a correção atual,
	 * verificando as repostas dadas aos itens
	 * e atualizando o status da proposta para esta correção
	 * com base nas regras de negócio informadas pelo cliente.
	 * 
	 *  O Método calcularStatusPropostaAtua() é chamado
	 *  para atualizar o status final da proposta no banco de dados 
	 */
	public abstract void calcularStatusPropostaAtual(Usuario professor, Proposta propostaView );

	/**
	 * Processamento nº2: Método para cáculo do status da proposta com base na
	 * nova correção.
	 */
	public abstract void calcularStatusFinalProposta(Proposta propostaView);	
	
	/**
	 * Alterar o status das correcoes referentes aos itens de uma dada proposta e professor	 
	 */
	public void alteraStatusCorrecoes(List<Correcao> listaCorrecao);

	/**
	 * Verifica se há correções anteriores para esta proposta
	 * ou se a correção atual é a primeira correção.
	 * 
	 * Retorna true se esta for a primeira correção para a proposta em questão.
	 *   
	 * @param correcao
	 * @return boolean
	 */
	public abstract boolean vericaSePrimeiraCorrecaodaProposta(Proposta proposta);

}