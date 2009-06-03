/**
 * 
 */
package br.com.gerpro.processing;

import java.util.ArrayList;
import java.util.List;

import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.impl.PropostaDao;

/**
 * @author manoel.neto
 *
 */
public class ListaResultados {
	// Aprovados
	 protected List aprovados = new ArrayList();
	
	 // Entregue
	 protected List entregues = new ArrayList();
	
	 // Aprovadas com Ressalva
	 protected List aprovadasRessalva = new ArrayList();
	 
	// Reprovadas
	 protected List reprovadas = new ArrayList();
	 
	 
	 protected FacadeProposta propostaDao = new PropostaDao();
	 
	 
	 
}
