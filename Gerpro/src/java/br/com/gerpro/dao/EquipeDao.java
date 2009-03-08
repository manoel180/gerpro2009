/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gerpro.dao;

import br.com.gerpro.model.Equipe;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface EquipeDao extends GenericDao<Equipe,Integer>{
    List<Equipe> findAll();

}
