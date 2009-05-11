/**
 * 
 */
package br.com.gerpro.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Usuario;

/**
 * @author Clã dos Souza
 * 
 */
public class TestPropostaDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropostaDao propostaDao = new PropostaDao();
		Usuario professor = new Usuario();
		professor.setMatricula("1");

		List listaPropostas = propostaDao.listarPorProfessor(professor);

		Proposta proposta = new Proposta();

		Iterator<Proposta> iterator = listaPropostas.iterator();

		while (iterator.hasNext()) {
			proposta = (Proposta) iterator.next();
			System.out.println(proposta.getNome());
		}
	}
}
