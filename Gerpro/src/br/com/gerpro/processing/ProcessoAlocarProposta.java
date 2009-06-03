/**
 * 
 */
package br.com.gerpro.processing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.CorrecaoId;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Usuario;

/**
 * @author M3R Classe que implementa o processo para a alocação dinamica das
 *         proposta aos professores Que farão a correção das mesmas.
 * 
 */
public class ProcessoAlocarProposta {
	private FacadeProposta propostaDao = new PropostaDao();
	private int qtdeProfessoresSelecionados;
	private int qtdeTotalPropostas;
	private int qtdePropostasPorProfessor;
	private boolean correcaoEmGrupo;
	private Correcao correcao = new Correcao();
	private Set<Correcao> listaCorrecao = new HashSet();

	public void ProcessoAlocarProposta(List professoresSelecionados, boolean emGrupo) {

		if (getQtdeProfessoresSelecionados() == 1) {

		}

		setCorrecaoEmGrupo(emGrupo);

		setQtdeProfessoresSelecionados(professoresSelecionados.size());

		// Cria lista de todas as proposta submetidas pelos alunos e ainda sem
		// correção.
		List<Proposta> listaTotalPropostas = propostaDao
				.listarPropostasConcluidas();

		// Quantidade totral de propostas
		setQtdeTotalPropostas(listaTotalPropostas.size());

		// Quantidade de professores selecionados
		setQtdeProfessoresSelecionados(qtdeProfessoresSelecionados);

		// Caso a correção seja em grupo
		if (isCorrecaoEmGrupo()) {
			for (Proposta proposta : listaTotalPropostas) {

			}

		} else {

		}

		float t = getQtdeTotalPropostas() / getQtdeProfessoresSelecionados();

		setQtdePropostasPorProfessor(qtdePropostasPorProfessor);

	}

	/***************************************************************************
	 * Método para geração de Correcoes para um dado professor
	 * 
	 * @return Lista de correcoes para o banco
	 */
	public Set<Correcao> geraCorrecao(Usuario professor, Proposta proposta) {
		
		
		
		for (int item = 1; item <= 5; item++) {
			CorrecaoId correcaoId = new CorrecaoId();
			correcaoId.setIdItem(item);
			correcaoId.setIdProposta(proposta.getId());
			correcaoId.setMatriculaProfessor(professor.getMatricula());
			
			//Switch para preencher informações sobre a pergunta
			
			
			
			
			
			switch (item) {
			case 1:
				correcaoId.setIdPergunta(4);			
				break;
			case 2:
				correcaoId.setIdPergunta(5);			
				break;
			case 3:
				correcaoId.setIdPergunta(3);			
				break;
			case 4:
				correcaoId.setIdPergunta(6);			
				break;
			case 5:
				correcaoId.setIdPergunta(8);			
				break;
			default:
				break;
			}
			
			correcao.setId(correcaoId);
			
			
			
			listaCorrecao.add(correcao);
			
			

			
			
			
		}
				
		return null;

	}

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
