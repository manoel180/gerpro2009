/**
 * 
 */
package br.com.gerpro.test;

import java.util.HashSet;
import java.util.Set;

import br.com.gerpro.dao.impl.CorrecaoDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.CorrecaoId;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Status;
import br.com.gerpro.processing.ProcessoCorrecao;

/**
 * @author Cl� dos Souza
 * 
 */
public class TestCorrecaoDao {

	public static void main(String[] args) {
		Proposta proposta = new Proposta();

		Correcao correcao = new Correcao();

		CorrecaoDao correcaoDao = new CorrecaoDao();

		PropostaDao propostaDao = new PropostaDao();

		ProcessoCorrecao processoCorrecao = new ProcessoCorrecao();

		CorrecaoId correcaoId = new CorrecaoId();
		correcaoId.setIdProposta(1);

		correcaoId.setMatriculaProfessor("1");

		correcao.setId(correcaoId);

		processoCorrecao.calcularStatusPropostaAtual(correcao);

	}

}
