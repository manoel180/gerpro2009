/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.controller;


import br.com.gerpro.model.Usuario;
import br.com.gerpro.service.UsuarioService;
import java.util.Map;
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