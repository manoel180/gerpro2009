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

    /*
     * Método
     *
     */

    public String validaLoginUsuario(Usuario usuario) {
        Usuario usuarioDb = usuarioDao.read(usuario.getMatricula());

        if (!usuarioDb.getSenha().equals(usuario.getSenha())) {
            return "erro";
        }
        return usuarioDb.getTipoUsuario().getNome();
    }

    public String updateUsuario(Usuario usuario) {
        usuarioDao.update(usuario);

        return usuario.getTipoUsuario().getNome() + " atualizado com sucesso";
    }

    public String createUsuario(Usuario usuarioTransiente, int tipo) {

        //Cria objeto TipoUsuario proveniente do banco de dados.
        TipoUsuario tipoUsuario = tipoUsuarioDao.read(tipo);


        usuarioTransiente.setTipoUsuario(tipoUsuario);

        if (usuarioDao.read(usuarioTransiente.getMatricula()) != null) {
            return usuarioTransiente.getTipoUsuario().getNome() + " já cadastrado";
        }       

        usuarioDao.create(usuarioTransiente);
        return usuarioTransiente.getTipoUsuario().getNome() + " cadastrado com sucesso";
    }

    //Métodos para listagem
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