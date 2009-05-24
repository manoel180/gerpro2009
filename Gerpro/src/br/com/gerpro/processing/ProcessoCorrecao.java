/**
 * 
 */
package br.com.gerpro.processing;

import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Proposta;


/**
 * @author msouza
 *
 */
public class ProcessoCorrecao implements IProcessoCorrecao {
	
	private FacadeProposta propostaDao = new PropostaDao();	
	
	
	/**
	 * Processamento nº1
	 * Algoritmo para o processamento do status da proposta com base na correção atual.
	 */	
	public void processaStatus(Correcao correcaoView){
		if (
				(correcaoView.getResposta().getId() ==  2 && correcaoView.getPergunta().getId() == 7)
				|| (correcaoView.getResposta().getId() ==  2 && correcaoView.getPergunta().getId() == 3
				&& correcaoView.getResposta().getId() ==  2 && correcaoView.getPergunta().getId() == 5
				&& correcaoView.getResposta().getId() ==  2 && correcaoView.getPergunta().getId() == 6)
				){
			System.out.println("PROPOSTA REPROVADA");
			//correcaoView.getPropostaItem().getProposta().getStatus().setId(5);
			
		}
		else if(
				(correcaoView.getResposta().getId() ==  2 && correcaoView.getPergunta().getId() == 3
				|| correcaoView.getResposta().getId() ==  2 && correcaoView.getPergunta().getId() == 5
				|| correcaoView.getResposta().getId() ==  2 && correcaoView.getPergunta().getId() == 6)
				&& (correcaoView.getResposta().getId() ==  1 && correcaoView.getPergunta().getId() == 7)){
			//correcaoView.getPropostaItem().getProposta().getStatus().setId(5);
			System.out.println("PROPOSTA APROVADA COM RESSALVA");
		}
		else
			System.out.println("PROPOSTA APROVADA");		
	}
	
	/**
	 * Processamento nº2
	 * Método para calculo do status da proposta com base na nova correção. 
	 */
	public void calculaStatusProposta(Correcao correcaoView) {
		Proposta propostaBD = propostaDao.procurarPorId(correcaoView.getPropostaItem().getProposta().getId());
		
		if(vericaSePrimeiraCorrecaodaProposta(correcaoView)){
			propostaBD.getStatus().setId(correcaoView.getPropostaItem().getProposta().getStatus().getId());
		}
		else {
			if(propostaBD.getStatus().getId() == 3){
				if(correcaoView.getPropostaItem().getProposta().getStatus().getId() == 3){
					propostaBD.getStatus().setId(3);
				}
				
				if(correcaoView.getPropostaItem().getProposta().getStatus().getId() == 4){
					propostaBD.getStatus().setId(3);
				}
				
				if(correcaoView.getPropostaItem().getProposta().getStatus().getId() == 5){
					propostaBD.getStatus().setId(4);
				}
				
				propostaDao.alterar(propostaBD);				
				return;				
			}
			
			// Se proposta do banco = APROVADA COM RESSALVA
			if(propostaBD.getStatus().getId() == 4){
				if(correcaoView.getPropostaItem().getProposta().getStatus().getId() == 3){
					propostaBD.getStatus().setId(3);
				}
				
				if(correcaoView.getPropostaItem().getProposta().getStatus().getId() == 4){
					propostaBD.getStatus().setId(4);
				}
				
				if(correcaoView.getPropostaItem().getProposta().getStatus().getId() == 5){
					propostaBD.getStatus().setId(5);
				}
				propostaDao.alterar(propostaBD);
				return;
			}
			
			// Se proposta do banco = REPROVADA
			if(propostaBD.getStatus().getId() == 5){
				if(correcaoView.getPropostaItem().getProposta().getStatus().getId() == 3){
					propostaBD.getStatus().setId(4);
				}
				
				if(correcaoView.getPropostaItem().getProposta().getStatus().getId() == 4){
					propostaBD.getStatus().setId(5);
				}
				
				if(correcaoView.getPropostaItem().getProposta().getStatus().getId() == 5){
					propostaBD.getStatus().setId(5);
				}
				propostaDao.alterar(propostaBD);
				return;
			}
		}
		propostaDao.alterar(propostaBD);
	}
	
	
	
	/**
	 * Verifica se há correções anteriores para esta proposta
	 */
	public boolean vericaSePrimeiraCorrecaodaProposta(Correcao correcao){
		if(correcao.getPropostaItem().getProposta().getStatus().getId() == 2 ){
			return true;			
		}		
		return false;
	}
	
	
	
	
	@Override
	public int verificaCorrecoesAnteriores(Proposta propostaView) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
