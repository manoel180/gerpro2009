/**
 * 
 */
package br.com.gerpro.processing;

import java.util.List;

import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.model.Proposta;

/**
 * @author msouza
 *
 */
public class ProcessoAlocarProposta {
	private FacadeProposta propostaDao = new PropostaDao();
	private List<Proposta> listaPropostasConcluidas;
	
	/***
	 * M�todo para processamento e distribui��o de propostas
	 * entre os professores selecionados para a corre��o destas.
	 * 
	 * @param qtdeProfessoresSelecionados
	 */
	public void alocarProposta(int qtdeProfessoresSelecionados){
		
		//Lista com todas as propostas com status "Conclu�do".
		listaPropostasConcluidas = propostaDao.listarPropostasConcluidas();
		
		//Quantidade de propostas comm status "Conclu�da".
		int totalPropostasConcluidas = listaPropostasConcluidas.size();
		
		
		//float quociente = totalPropostasConcluidas / qtdeProfessoresSelecionados;
		
		double qtdePropostasPorProfessor = Math.floor( totalPropostasConcluidas / qtdeProfessoresSelecionados);
		int contadorVoltas = 0;
		
		while(contadorVoltas <= qtdePropostasPorProfessor ){
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
