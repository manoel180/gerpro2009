/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gerpro.service;

import br.com.gerpro.model.Equipe;
import br.com.gerpro.model.Proposta;
import java.util.List;

/**
 *
 * @author msouza
 */
public interface PropostaService {
    public void createProposta(final Proposta proposta);
    public Proposta findById(int id);
    public void deleteProposta(Proposta proposta);
    public void updateProposta(Proposta proposta);
    public void changeStatusProposta(Proposta proposta);
    public List listAll();
    public List listPropostaByStatus();
}
