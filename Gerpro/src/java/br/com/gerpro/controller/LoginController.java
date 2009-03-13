/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.controller;

import br.com.gerpro.model.Usuario;
import br.com.gerpro.service.impl.UsuarioServiceImpl;
import br.com.gerpro.util.ApplicationSecurityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Marcelo
 * 
 */
public class LoginController extends MultiActionController {

    public LoginController() {}

    public ModelAndView display(HttpServletRequest request, HttpServletResponse response) {
        Usuario usuario = new Usuario();
        ServletRequestDataBinder binder = new ServletRequestDataBinder(usuario);
        binder.bind(request);       
        return new ModelAndView("loginView", "usuario", usuario);
    }

    public ModelAndView valida(HttpServletRequest request, HttpServletResponse response, Usuario usuario) {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(usuario);
        binder.bind(request);
        String successView = usuarioService.validaLoginUsuario(usuario);

        if(successView.equals("erro")){
            return new ModelAndView("erro");
        }
       
        applicationSecurityManager.setUsuario(request, usuario);
        
        successView = "bemVindo" + successView;
        return new ModelAndView(successView);
    }

    private UsuarioServiceImpl usuarioService;



    public void setUsuarioService(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    private ApplicationSecurityManager applicationSecurityManager;

    public void setApplicationSecurityManager(ApplicationSecurityManager applicationSecurityManager) {
        this.applicationSecurityManager = applicationSecurityManager;
    }

}