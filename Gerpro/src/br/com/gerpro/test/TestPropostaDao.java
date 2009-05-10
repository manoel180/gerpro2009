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
		 Usuario usuario = new Usuario();
		 usuario.setMatricula("1");
		 
		 
		 List listaPropostas = propostaDao.listarPorProfessor(usuario);
		 Set<Correcao> correcoes = null;
		 
		// Iterator iterator = listaPropostas.iterator();
		 
		// Usuario usuarios = propostaDao.listarPorProfessor(usuario);
		 
		
		 
//		 Iterator iterator = usuarios.iterator();
		 
		 Proposta proposta = new Proposta();
		 //while(iterator.hasNext()){
	//		 usuario = (Usuario)iterator.next();

			 
			 Iterator iterator = listaPropostas.iterator();
			 
			 Correcao correcao = new Correcao();
			 
			 while(iterator.hasNext()){
			 //System.out.println( iterator.next());
				 proposta = (Proposta)iterator.next();
				 System.out.println(proposta.getNome());
				 
				 
			 }
			 
			 
			 
			 
	//	 }
	}

}
