/**
 * 
 */
package br.com.gerpro.processing;

import java.util.List;

import br.com.gerpro.dao.FacadeCorrecao;
import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.FacadeStatus;
import br.com.gerpro.dao.impl.CorrecaoDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.dao.impl.StatusDao;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Proposta;

/**
 * @author M3R
 * 
 */
public class ProcessoCorrecao implements IProcessoCorrecao {
	
	private FacadeProposta propostaDao = new PropostaDao();
	private FacadeCorrecao correcaoDao = new CorrecaoDao();
	private List<Correcao> listaCorrecao = null;
	private FacadeStatus statusDao = new StatusDao();
	

	/* (non-Javadoc)
	 * @see br.com.gerpro.processing.IProcessoCorrecao#calcularStatusPropostaAtual(br.com.gerpro.model.Correcao)
	 */
	public void calcularStatusPropostaAtual(Correcao correcao) {
		listaCorrecao = correcaoDao.procurarPorCorrecao(correcao);
		
		correcao = listaCorrecao.get(1);
		
		Proposta proposta = propostaDao.procurarPorId(correcao.getPropostaItem().getProposta().getId());		

		for (Correcao correcaoView : listaCorrecao) {
			System.out.println(correcaoView.getPergunta().getId() + " "
					+ correcaoView.getResposta().getId());
			
			//Verificação de proposta reprovada
			if (correcaoView.getResposta().getId() == 2 && correcaoView.getPergunta().getId() == 7){				
				proposta.setStatus(statusDao.procurarPorId(5));		
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
										proposta.setStatus(statusDao.procurarPorId(5));		
										calcularStatusFinalProposta(proposta);		
										return;										
										
									}//Fim do if
								}//fim do terceiro FOR
								
							}//Fim do if
						}//fim do segundo FOR					
						
					}//Fim do if
				}//fim do primeiro FOR
			
			
			//Verificação de proposta aprovada com ressalva
			if (correcaoView.getResposta().getId() == 1 && correcaoView.getPergunta().getId() == 7){
				for (Correcao correcaoView1 : listaCorrecao) {
					
					if(	correcaoView1.getResposta().getId()    == 2	 && correcaoView1.getPergunta().getId() == 3
						|| correcaoView1.getResposta().getId() == 2  && correcaoView1.getPergunta().getId() == 5
						|| correcaoView1.getResposta().getId() == 2  && correcaoView1.getPergunta().getId() == 6){
						
						proposta.setStatus(statusDao.procurarPorId(4));		
						calcularStatusFinalProposta(proposta);						
						return;										
						
					}//Fim do if
				}//fim do FOR 		
				
			}
		}//Fim do FOR GLOBAL		
		proposta.setStatus(statusDao.procurarPorId(3));		
		calcularStatusFinalProposta(proposta);		

	}

	/* (non-Javadoc)
	 * @see br.com.gerpro.processing.IProcessoCorrecao#calcularStatusFinalProposta(br.com.gerpro.model.Proposta)
	 */
	public void calcularStatusFinalProposta(Proposta propostaView) {
		
		Proposta propostaBD = propostaDao.procurarPorId(propostaView.getId());
		System.out.println(propostaBD.getNome());
		
		
		
		/***
		 * Caso seja a primeira correcao da proposta,
		 * o sistema atualiza o status da proposta com o status da proposta atual
		 */
		if (vericaSePrimeiraCorrecaodaProposta(propostaBD)) {			
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

	/* (non-Javadoc)
	 * @see br.com.gerpro.processing.IProcessoCorrecao#vericaSePrimeiraCorrecaodaProposta(br.com.gerpro.model.Proposta)
	 */
	public boolean vericaSePrimeiraCorrecaodaProposta(Proposta proposta) {
		if (proposta.getStatus().getId() == 2) {
			return true;
		}
		return false;
	}	
}//Fim da classe 