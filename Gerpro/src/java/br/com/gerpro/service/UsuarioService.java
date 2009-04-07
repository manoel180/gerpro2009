/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.service;

import br.com.gerpro.model.Usuario;
import java.util.List;

/**
 *
 * @author Marcelo&Marcela
 */
public interface UsuarioService {

    public String validaLoginUsuario(Usuario usuario);

    public String createUsuario(Usuario usuario, int tipo);

    public String updateUsuario(Usuario usuario);

    public List listAll();

    public List listByTipo(String tipo);

    public List listAlunosSemEquipe();

    public Usuario getUsuario(String matricula);
}
