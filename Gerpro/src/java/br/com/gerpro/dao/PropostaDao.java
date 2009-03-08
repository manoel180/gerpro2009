/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.dao;

import br.com.gerpro.model.Proposta;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface PropostaDao extends GenericDao<Proposta, Integer> {
    
    List<Proposta> findByStatus();
    List<Proposta> findAll();
}
