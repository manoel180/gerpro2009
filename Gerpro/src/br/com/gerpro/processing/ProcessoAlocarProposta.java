/**
 * 
 */
package br.com.gerpro.processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.gerpro.dao.FacadeCorrecao;
import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.FacadeStatus;
import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.dao.impl.CorrecaoDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.dao.impl.StatusDao;
import br.com.gerpro.dao.impl.UsuarioDao;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.CorrecaoId;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Usuario;

/**
 *  Classe que implementa o processo para a alocaÃ§Ã£o dinÃ¢mica das
 *         proposta aos professores que farÃ£o a correÃ§Ã£o das mesmas.
 * 
 * @author M3R 
 */
public class ProcessoAlocarProposta implements IProcessoAlocarProposta {
	private int qtdeTotalPropostas;
	private boolean correcaoEmGrupo;
	private int qtdePropostasPorProfessor;
	private int qtdeProfessoresSelecionados;
	private Correcao correcao = new Correcao();

	private FacadeStatus statusDao = new StatusDao();
	private FacadeUsuario usuarioDao = new UsuarioDao();
	private FacadeProposta propostaDao = new PropostaDao();
	private FacadeCorrecao correcaoDao = new CorrecaoDao();

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.processing.IProcessoAlocarProposta#alocaProposta(java.util.List,
	 *      boolean)
	 */

	@SuppressWarnings("unchecked")
	public void alocaProposta(List<String> listaMatriculasProfessores,
			boolean correcaoEmGrupo) {
		
		/**
		 * Seta a variavel local correcaEmGrupo do tipo boolean com o parametro de entrada do metodo
		 */
		setCorrecaoEmGrupo(correcaoEmGrupo);
		
		/**
		 * Cria e popula uma lista de professores selecionados para a correcao
		 */
		List<Usuario> professoresSelecionados = new ArrayList();

		for (String matricula : listaMatriculasProfessores) {
			Usuario usuario = usuarioDao.procurarPorMatricula(matricula);
			professoresSelecionados.add(usuario);
		}
		
		/**
		 * Popula uma lista de propostas com status concluido para serem alocadas
		 */
		List<Proposta> listaPropostasConcluidas = propostaDao
				.listarPropostasConcluidas();

		/**
		 * Verifica se existe proposta na lista. SenÃ£o houver, sai do mÃ©todo.
		 */
		if (listaPropostasConcluidas.isEmpty()) {
			return;
		}
		
		/**
		 * Havendo proposta na lista, verifica quantos professores foram
		 * escolhidos para correÃ§Ã£o.
		 */
		else {
			/**
			 * Existe apenas um professor para correÃ§Ã£o
			 */
			if (professoresSelecionados.size() == 1) {
				Usuario professor = (Usuario) professoresSelecionados.get(0);

				/**
				 * Aloca as propostas para cada professor, gera as correÃ§Ãµes
				 * para a proposta, atualiza o status da proposta para "Em
				 * correcao" e salva a proposta no banco.
				 */
				for (Proposta proposta : listaPropostasConcluidas) {
					geraCorrecao(professor, proposta);
					proposta.setStatus(statusDao.procurarPorId(2));
					propostaDao.salvar(proposta);

				}
			}
			/**
			 * Existe mais de professor para correÃ§Ã£o
			 */
			else {
				/***************************************************************
				 * Verifica se a correÃ§Ã£o Ã© em grupo
				 */
				if (isCorrecaoEmGrupo()) {

					Usuario professor1 = (Usuario) professoresSelecionados
							.get(0);
					Usuario professor2 = (Usuario) professoresSelecionados
							.get(1);

					/***********************************************************
					 * Aloca as proposta dinamicamente para os dois professores,
					 * gera as correcoes para as propostas, atualiza o status da
					 * proposta para "Em correcao" e salva a proposta no banco
					 */
					for (Proposta proposta : listaPropostasConcluidas) {

						geraCorrecao(professor1, proposta);

						geraCorrecao(professor2, proposta);

						proposta.setStatus(statusDao.procurarPorId(2));

						propostaDao.salvar(proposta);
					}

				}
				
				/***************************************************************
				 * Caso a correcao seja individual,a quantidade de propostas Ã©
				 * divida pelo numero de professores.
				 */
				else {
					/**
					 * Caso a quantidade de propostas seja PAR
					 */
					if (listaPropostasConcluidas.size() % 2 == 0) {

						// Loop para alocar dinamicamente propostas entre os
						// professores
						int index = 0;
						for (int i = 0; i < listaPropostasConcluidas.size(); i++) {
							
							geraCorrecao((Usuario) professoresSelecionados.get(index),
									listaPropostasConcluidas.get(i));

							// Atualiza o status da proposta para "Em
							// correcao"
							listaPropostasConcluidas.get(i).setStatus(
									statusDao.procurarPorId(2));
							propostaDao.salvar(listaPropostasConcluidas.get(i));
							
							/**
							 * Alternar os profesores que receberao as propostas
							 */
							if (index == 0) {
								index++;
							} else
								index--;
						}

					} else { // Caso a qtde de propostas seja Ã?MPAR
						/**
						 *  Caso o numero de propostas concluiidas seja igual a 1
						 *
						 */
						
						if (listaPropostasConcluidas.size() == 1) {
							
							
							for (int i = 0; i < professoresSelecionados.size(); i++) {

								geraCorrecao((Usuario) professoresSelecionados.get(i),
										listaPropostasConcluidas.get(0));
							}

							/**
							 * Atualiza o status da proposta para "Em
							 * correcao"
							 */ 
							listaPropostasConcluidas.get(0).setStatus(
									statusDao.procurarPorId(2));
							
							propostaDao.salvar(listaPropostasConcluidas.get(0));

						}
						/**
						 * Caso o numero de propostas concluidas impar e maior que  1 
						 */
						else {
							// Retira a primeira proposta da lista para ser alocada dinamicamente em separado
							Proposta proposta = listaPropostasConcluidas.get(0);
							listaPropostasConcluidas.remove(0);

							// Loop para alocar dinamicamente propostas entre os
							// professores

							int index = 0;
							for (int i = 0; i < listaPropostasConcluidas.size(); i++) {
								geraCorrecao((Usuario) professoresSelecionados
										.get(index), listaPropostasConcluidas
										.get(i));

								// Atualiza o status da proposta para "Em
								// correcao"
								listaPropostasConcluidas.get(i).setStatus(
										statusDao.procurarPorId(2));
								propostaDao.salvar(listaPropostasConcluidas
										.get(i));
								if (index == 0) {
									index++;
								} else
									index--;

							}
							
							// Cria um objeto para escolha randomica
							Random seletor = new Random();

							// Aloca a ultima proposta aleatoriamente para o
							// professor escolhido
							geraCorrecao((Usuario) professoresSelecionados
									.get(seletor.nextInt(2)), proposta);

							// Atualiza o status da proposta para "Em correcao"
							proposta.setStatus(statusDao.procurarPorId(2));
							propostaDao.salvar(proposta);

						}
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.processing.IProcessoAlocarProposta#geraCorrecao(br.com.gerpro.model.Usuario,
	 *      br.com.gerpro.model.Proposta)
	 */
	public void geraCorrecao(Usuario professor, Proposta proposta) {

		// Constroi objetos do tipo Correcao e persiste em banco
		for (int idPergunta = 1; idPergunta <= 8; idPergunta++) {

			CorrecaoId correcaoId = new CorrecaoId();
			
			correcaoId.setIdPergunta(idPergunta);
			
			correcaoId.setIdProposta(proposta.getId());
			
			correcaoId.setMatriculaProfessor(professor.getMatricula());

			// Switch para preenchimento informaÃ§Ãµes sobre o item
			switch (idPergunta) {
			case 1:
				correcaoId.setIdItem(6);
				break;
			case 2:
				correcaoId.setIdItem(6);
				break;
			case 3:
				correcaoId.setIdItem(3);
				break;
			case 4:
				correcaoId.setIdItem(1);
				break;
			case 5:
				correcaoId.setIdItem(2);
				break;
			case 6:
				correcaoId.setIdItem(4);
				break;
			case 7:
				correcaoId.setIdItem(6);
				break;
			case 8:
				correcaoId.setIdItem(5);
				break;
			default:
				break;
			}

			// Seta o id criado no objeto correcao
			correcao.setId(correcaoId);

			// Seta o novo status da correcao
			correcao.setStatus(statusDao.procurarPorId(2));

			// Persiste a correcao no banco de dados
			correcaoDao.salvar(correcao);
		}
	}

	/**
	 * MÃ©todos Get e Set para os objetos da classe.
	 * 
	 */
	public int getQtdeProfessoresSelecionados() {
		return qtdeProfessoresSelecionados;
	}

	public void setQtdeProfessoresSelecionados(int qtdeProfessoresSelecionados) {
		this.qtdeProfessoresSelecionados = qtdeProfessoresSelecionados;
	}

	public int getQtdeTotalPropostas() {
		return qtdeTotalPropostas;
	}

	public void setQtdeTotalPropostas(int qtdeTotalPropostas) {
		this.qtdeTotalPropostas = qtdeTotalPropostas;
	}

	public int getQtdePropostasPorProfessor() {
		return qtdePropostasPorProfessor;
	}

	public void setQtdePropostasPorProfessor(int qtdePropostasPorProfessor) {
		this.qtdePropostasPorProfessor = qtdePropostasPorProfessor;
	}

	public FacadeProposta getPropostaDao() {
		return propostaDao;
	}

	public void setPropostaDao(FacadeProposta propostaDao) {
		this.propostaDao = propostaDao;
	}

	public boolean isCorrecaoEmGrupo() {
		return correcaoEmGrupo;
	}

	public void setCorrecaoEmGrupo(boolean correcaoEmGrupo) {
		this.correcaoEmGrupo = correcaoEmGrupo;
	}
}
