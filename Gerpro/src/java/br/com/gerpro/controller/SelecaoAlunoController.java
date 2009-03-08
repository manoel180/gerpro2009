/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.controller;

import br.com.gerpro.model.Usuario;
import br.com.gerpro.service.UsuarioService;
import br.com.gerpro.service.impl.UsuarioServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

/**
 *
 * @author Marcelo
 */
public class SelecaoAlunoController extends AbstractCommandController {

    public SelecaoAlunoController() {
        setCommandClass(Usuario.class);
        setCommandName("usuario");

    }

    @Override
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object command,
            BindException errors) throws Exception {
        String[] matricula = ServletRequestUtils.getStringParameters(request, "list_alunos_selecionados");
        List alunos = new ArrayList();
        for (int i = 0; i < matricula.length; i++) {
            alunos.add(usuarioService.getUsuario(matricula[i]));
        }

        return new ModelAndView("listaAlunosBranco", "alunos", alunos);
    }

    public Object getModel(HttpServletRequest request, String modelName) {
        HttpSession session = request.getSession();
        Object model = session.getAttribute(modelName);
        return model;
    }

    public void saveModel(HttpServletRequest request, String modelName, Object model) {
        HttpSession session = request.getSession();
        session.setAttribute(modelName, model);
    }
    private UsuarioServiceImpl usuarioService;

    public void setUsuarioService(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }
}