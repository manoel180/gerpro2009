/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.dao;

import br.com.gerpro.model.Usuario;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface UsuarioDao extends GenericDao<Usuario, String> {

    List<Usuario> findAll();

    List<Usuario> findByName(String name);

    List<Usuario> findAllUsuariosByTipo(String tipo);

    List<Usuario> findAlunosSemEquipe();
}
