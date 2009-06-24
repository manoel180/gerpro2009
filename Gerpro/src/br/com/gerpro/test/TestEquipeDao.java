/**
 * 
 */
package br.com.gerpro.test;

import java.util.Iterator;
import java.util.List;

import br.com.gerpro.dao.FacadeEquipe;
import br.com.gerpro.dao.impl.EquipeDao;
import br.com.gerpro.model.Equipe;

/**
 * @author Cl� dos Souza
 * 
 */
public class TestEquipeDao {

	public static void main(String[] args) {
		 

		FacadeEquipe equipeDao = new EquipeDao();
		
		List<Equipe> listaEquipe = equipeDao.listarEquipesSemProposta();
		
		for (Iterator iterator = listaEquipe.iterator(); iterator.hasNext();) {
			Equipe equipe = (Equipe) iterator.next();						
		}
	}

}
