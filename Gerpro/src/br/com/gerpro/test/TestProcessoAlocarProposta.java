
package br.com.gerpro.test;

import java.util.ArrayList;
import java.util.List;

import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.dao.impl.UsuarioDao;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.processing.IProcessoAlocarProposta;
import br.com.gerpro.processing.ProcessoAlocarProposta;

public class TestProcessoAlocarProposta {	
	
	public static void main(String[] args) {
		
		FacadeUsuario usuarioDao = new UsuarioDao();
		
		IProcessoAlocarProposta alocar = new ProcessoAlocarProposta();
		
		boolean emGrupo = false;
		
		
		
		
		String professor1 = "1";
		
		String professor2 = "2";
		
		
		List<String> lista = new ArrayList<String>();
		
		lista.add(professor1);
		lista.add(professor2);
		
		alocar.alocaProposta(lista, emGrupo);
	}
}