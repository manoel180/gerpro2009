package br.com.gerpro.test;

import java.util.ArrayList;
import java.util.List;

import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.dao.impl.UsuarioDao;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.processing.ProcessoAlocarProposta;

public class TestProcessoAlocarProposta {	
	
	public static void main(String[] args) {
		
		FacadeUsuario usuarioDao = new UsuarioDao();
		
		ProcessoAlocarProposta alocar = new ProcessoAlocarProposta();
		
		boolean emGrupo = false;
		
		Usuario professor = usuarioDao.procurarPorMatricula("2");
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		lista.add(professor);
		
		alocar.alocaProposta(lista, emGrupo);
	}
}