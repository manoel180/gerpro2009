/**
 * 
 */
package br.com.gerpro.processing;

import java.util.List;

import br.com.gerpro.dao.FacadeCorrecao;
import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.FacadePropostaItem;
import br.com.gerpro.dao.FacadeStatus;
import br.com.gerpro.dao.impl.CorrecaoDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.dao.impl.PropostaItemDao;
import br.com.gerpro.dao.impl.StatusDao;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Status;

/**
 * @author M3R
 * 
 */
public class ProcessoCorrecao {

	private FacadePropostaItem propostaItemDao = new PropostaItemDao();
	private FacadeProposta propostaDao = new PropostaDao();
	private FacadeCorrecao correcaoDao = new CorrecaoDao();
	private List<Correcao> listaCorrecao = null;
	private FacadeStatus statusDao = new StatusDao();
	

	/**
	 * Processamento n�1 Algoritmo para o processamento do status da proposta
	 * com base na corre��o atual.
	 */
	public void calcularStatusPropostaAtual(Correcao correcao) {
		listaCorrecao = correcaoDao.procurarPorCorrecao(correcao);
		
		correcao = listaCorrecao.get(1);
		
		Proposta proposta = propostaDao.procurarPorId(correcao.getPropostaItem().getProposta().getId());

		Status status = new Status();
		

		for (Correcao correcaoView : listaCorrecao) {
			System.out.println(correcaoView.getPergunta().getId() + " "
					+ correcaoView.getResposta().getId());
			
			//Verifica��o de proposta reprovada
			if (correcaoView.getResposta().getId() == 2 && correcaoView.getPergunta().getId() == 7){
				System.out.println("PROPOSTA REPROVADA");
				status.setId(5);
				status = statusDao.procurarPorId(status.getId());
				proposta.setStatus(status);		
				calcularStatusFinalProposta(proposta);		
				return;
			}
			else
				//Primeiro FOR
				for (Correcao correcaoView2 : listaCorrecao) {
					if(	correcaoView2.getResposta().getId() == 2 && correcaoView2.getPergunta().getId() == 3){
						
						//Segundo FOR
						for (Correcao correcaoView3 : listaCorrecao) {
							if(	correcaoView3.getResposta().getId() == 2 && correcaoView3.getPergunta().getId() == 5){
								
								//Terceiro FOR
								for (Correcao correcaoView4 : listaCorrecao) {
									if(	correcaoView4.getResposta().getId() == 2 && correcaoView4.getPergunta().getId() == 6){
										System.out.println("PROPOSTA REPROVADA");										
										status.setId(5);
										status = statusDao.procurarPorId(status.getId());
										proposta.setStatus(status);		
										calcularStatusFinalProposta(proposta);		
										return;										
										
									}//Fim do if
								}//fim do terceiro FOR
								
							}//Fim do if
						}//fim do segundo FOR					
						
					}//Fim do if
				}//fim do primeiro FOR
			
			
			//Verifica��o de proposta aprovada com ressalva
			if (correcaoView.getResposta().getId() == 1 && correcaoView.getPergunta().getId() == 7){
				for (Correcao correcaoView1 : listaCorrecao) {
					
					if(	correcaoView1.getResposta().getId()    == 2	 && correcaoView1.getPergunta().getId() == 3
						|| correcaoView1.getResposta().getId() == 2  && correcaoView1.getPergunta().getId() == 5
						|| correcaoView1.getResposta().getId() == 2  && correcaoView1.getPergunta().getId() == 6){
						
						System.out.println("PROPOSTA APROVADA COM RESSALVA");						
						status.setId(4);
						status = statusDao.procurarPorId(status.getId());
						proposta.setStatus(status);		
						calcularStatusFinalProposta(proposta);		
						
						return;										
						
					}//Fim do if
				}//fim do FOR 		
				
			}
			}//Fim do FOR GLOBAL			

		System.out.println("PROPOSTA APROVADA");		
		status.setId(3);
		status = statusDao.procurarPorId(status.getId());
		proposta.setStatus(status);		
		calcularStatusFinalProposta(proposta);		

	}

	/**
	 * Processamento n�2 M�todo para calculo do status da proposta com base na
	 * nova corre��o.
	 */
	public void calcularStatusFinalProposta(Proposta propostaView) {
		
		Proposta propostaBD = propostaDao.procurarPorId(propostaView.getId());
		System.out.println(propostaBD.getNome());
		
		
		
		/***
		 * Caso seja a primeira correcao da proposta,
		 * o sistema atualiza o status da proposta com o status da proposta atual
		 */
		if (vericaSePrimeiraCorrecaodaProposta(propostaBD)) {
			
			System.out.println("Primeira Corre��o ****************************");			
			
			propostaBD.setStatus(propostaView.getStatus());
			propostaDao.alterar(propostaBD);
		}
		else {
			if (propostaBD.getStatus().getId() == 3) {
				if (propostaView.getStatus().getId() == 3) {
					
					propostaBD.setStatus(statusDao.procurarPorId(3));
	//				propostaDao.alterar(propostaBD);
					
				}

				if (propostaView.getStatus().getId() == 4) {
					
					propostaBD.setStatus(statusDao.procurarPorId(3));
//					propostaDao.alterar(propostaBD);					
					
				}

				if (propostaView.getStatus().getId() == 5) {
					
					propostaBD.setStatus(statusDao.procurarPorId(4));
					//propostaDao.alterar(propostaBD);					
					
				}

				propostaDao.alterar(propostaBD);
				return;
			}

			// Se proposta do banco = APROVADA COM RESSALVA
			if (propostaBD.getStatus().getId() == 4) {
				if (propostaView.getStatus().getId()  == 3) {
					propostaBD.setStatus(statusDao.procurarPorId(3));
					
					//propostaBD.getStatus().setId(3);
				}

				if (propostaView.getStatus().getId()  == 4) {
					
					propostaBD.setStatus(statusDao.procurarPorId(4));
					//propostaBD.getStatus().setId(4);
				}

				if (propostaView.getStatus().getId()  == 5) {
					
					propostaBD.setStatus(statusDao.procurarPorId(5));
					//propostaBD.getStatus().setId(5);
				}
				propostaDao.alterar(propostaBD);
				return;
			}

			// Se proposta do banco = REPROVADA
			if (propostaBD.getStatus().getId() == 5) {
				if (propostaView.getStatus().getId()  == 3) {
					
					propostaBD.setStatus(statusDao.procurarPorId(4));
					//propostaBD.getStatus().setId(4);
				}

				if (propostaView.getStatus().getId()  == 4) {
					
					propostaBD.setStatus(statusDao.procurarPorId(4));
					
					//propostaBD.getStatus().setId(5);
				}

				if (propostaView.getStatus().getId()  == 5) {
					
					propostaBD.setStatus(statusDao.procurarPorId(5));
					//propostaBD.getStatus().setId(5);
				}
				propostaDao.alterar(propostaBD);
				return;
			}
		}
		//propostaDao.alterar(propostaBD);
	}

	/***************************************************************************
	 * Verifica se h� corre��es anteriores para esta proposta
	 * 
	 * @param correcao
	 * @return
	 */
	public boolean vericaSePrimeiraCorrecaodaProposta(Proposta proposta) {
		if (proposta.getStatus().getId() == 2) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param propostaView
	 * @return
	 */
	public int verificaCorrecoesAnteriores(Proposta propostaView) {
		// TODO Auto-generated method stub
		return 0;
	}

}
