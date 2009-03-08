package br.com.gerpro.service.impl;

import br.com.gerpro.dao.TipoUsuarioDao;
import br.com.gerpro.dao.UsuarioDao;
import br.com.gerpro.model.TipoUsuario;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.service.UsuarioService;
import java.util.List;

/** 
 * @author M2R
 */
public class UsuarioServiceImpl implements UsuarioService {

    public UsuarioServiceImpl() {
    }

    public String validaLoginUsuario(Usuario usuario) {
        Usuario usuarioDb = usuarioDao.read(usuario.getMatricula());      

        if (!usuarioDb.getSenha().equals(usuario.getSenha())) {
            return "erro";
        }
        return usuarioDb.getTipoUsuario().getNome();
    }

    public void updateUsuario(Usuario usuario) {
        usuarioDao.update(usuario);
    }

    public List listAll() {
        
        return usuarioDao.findAll();
    }
    
    public List listByTipo(String tipo) {        
        return usuarioDao.findAllUsuariosByTipo(tipo);
    }

    public Usuario getUsuario(String matricula) {
        return usuarioDao.read(matricula);
    }

    public List listAlunosSemEquipe() {
        return usuarioDao.findAlunosSemEquipe();
    }

    public void createUsuario(Usuario usuario, int tipo) {
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setId(tipo);
        usuario.setTipoUsuario(tipoUsuario);
        usuarioDao.create(usuario);
    }

    //Componente
    private UsuarioDao usuarioDao;
    private TipoUsuarioDao tipoUsuarioDao;

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public void setTipoUsuarioDao(TipoUsuarioDao tipoUsuarioDao) {
        this.tipoUsuarioDao = tipoUsuarioDao;
    }
}