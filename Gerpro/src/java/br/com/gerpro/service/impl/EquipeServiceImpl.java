/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gerpro.service.impl;

import br.com.gerpro.dao.EquipeDao;
import br.com.gerpro.model.Equipe;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.service.EquipeService;
import br.com.gerpro.service.UsuarioService;


/**
 *
 * @author M2R
 */
public class EquipeServiceImpl implements EquipeService{

     public Equipe getEquipe(int id) {
        return equipeDao.read(id);
    }

    public void createEquipe(Equipe equipe) {
        equipeDao.create(equipe);
    }

    public void updateEquipe(Equipe equipe) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addAluno(Usuario aluno) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeAluno(Usuario aluno) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    //Componentes
    private EquipeDao equipeDao;

    public void setEquipeDao(EquipeDao equipeDao) {
        this.equipeDao = equipeDao;
    }

    private UsuarioService usuarioService;

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
}
