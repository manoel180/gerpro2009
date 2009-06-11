/**
 * 
 */
package br.com.gerpro.test;

import java.util.List;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.dao.FacadeCorrecao;
import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.dao.impl.CorrecaoDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.dao.impl.UsuarioDao;

import br.com.gerpro.processing.ProcessoCorrecao;

/**
 * @author msouza
 *
 */
public class TestProcessoCorrecao {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
		
		FacadeUsuario usuarioDao= new UsuarioDao();
		FacadeCorrecao correcaoDao = new CorrecaoDao();
		FacadeProposta propostaDao = new PropostaDao();
		
		
		Usuario professor =  usuarioDao.procurarPorMatricula("2");
		Proposta proposta = propostaDao.procurarPorId(4);		
		

		List<Correcao> listaCorrecao = correcaoDao.procurarPorCorrecao(professor, proposta);
				

		ProcessoCorrecao processoCorrecao = new ProcessoCorrecao();
		
		processoCorrecao.calcularStatusPropostaAtual(professor, proposta);	
		
		for (Correcao cor : listaCorrecao) {
			System.out.println("****************Id Proposta da Correcao " + cor.getId().getMatriculaProfessor());
			
		}				
	}
}
