package br.com.gerpro.service.impl;

import br.com.gerpro.dao.TipoUsuarioDao;
import br.com.gerpro.dao.UsuarioDao;
import br.com.gerpro.model.Equipe;
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

    public String updateUsuario(Usuario usuario) {
        usuarioDao.update(usuario);
        return "Usuário atualizado com sucesso";
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

    public String createUsuario(Usuario usuarioTransinte, int tipo) {
        TipoUsuario tipoUsuario = tipoUsuarioDao.read(tipo);
        usuarioTransinte.setTipoUsuario(tipoUsuario);

        if( usuarioDao.read( usuarioTransinte.getMatricula() ) != null){
            return "Usuario já cadastrado";
        }

        //Usuario do tipo Aluno
        if(tipoUsuario.getNome().equals("Aluno")){
            Equipe equipe = usuarioTransinte.getEquipe();

        }

        usuarioDao.create(usuarioTransinte);
        return "Usuário cadastrado com sucesso";
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