/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.controller;


import br.com.gerpro.model.Usuario;
import br.com.gerpro.service.UsuarioService;
<<<<<<< .mine
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
=======
import java.util.Map;
>>>>>>> .r62
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/** 
 *
 * @author Marcelo&Marcela
 */
public class CadastroAlunoController extends SimpleFormController {

      public CadastroAlunoController() {
        setCommandClass(Usuario.class);
        setCommandName("usuario");
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        Usuario usuarioForm = (Usuario) super.formBackingObject(request);
        //Usuario usuarioDB = usuarioService.getUsuario(usuarioForm.getMatricula());
        return usuarioForm;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        List listaAlunos = usuarioService.listByTipo("aluno");
        List listaAlunosSemEquipe = usuarioService.listAlunosSemEquipe();
        List listaAlunosSelecionados = new LinkedList();

        Map cadastroAlunosMap = new HashMap();

        cadastroAlunosMap.put("alunos", listaAlunos);
        cadastroAlunosMap.put("alunosSemEquipe", listaAlunosSemEquipe);
        cadastroAlunosMap.put("alunosSelecionados",listaAlunosSelecionados);

        return cadastroAlunosMap;
    }


    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command,
            BindException errors) throws Exception {
        Usuario usuario = (Usuario) command;

        usuarioService.createUsuario(usuario, 1);

        return new ModelAndView(getSuccessView());
    }

    @Override
    protected void doSubmitAction(Object command) throws Exception {
        super.doSubmitAction(command);
    }

    @Override
    protected Map referenceData(HttpServletRequest request, Object command, Errors errors) throws Exception {
        return super.referenceData(request, command, errors);
    }

    /*@Override
    protected ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
    Usuario usuarioSelecionado = (Usuario) command;

    Usuario usuarioDB = usuarioService.getUsuario(usuarioSelecionado.getMatricula());

    return new ModelAndView("cadastroAluno", "usuario", usuarioDB);

    }*/

    private UsuarioService usuarioService;

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}