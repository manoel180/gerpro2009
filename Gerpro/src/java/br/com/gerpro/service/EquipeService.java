/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gerpro.service;

import br.com.gerpro.model.Equipe;
import br.com.gerpro.model.Usuario;

/**
 *
 * @author Marcelo
 */
public interface EquipeService {
    public Equipe getEquipe(int id);
    public void createEquipe(Equipe equipe);
    public void updateEquipe(Equipe equipe);
    public void addAluno(Usuario aluno);
    public void removeAluno(Usuario aluno);
}
