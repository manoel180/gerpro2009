/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.controller;

import br.com.gerpro.model.Usuario;
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
public class LogoffController extends MultiActionController {

    public LogoffController() {}

    public ModelAndView remove(HttpServletRequest request, HttpServletResponse response, Usuario usuario) {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(usuario);
        binder.bind(request);
        
        applicationSecurityManager.removeUsuario(request);
       
        return new ModelAndView("login");
    }

    //Componentes
    ApplicationSecurityManager applicationSecurityManager;

    public void setApplicationSecurityManager(ApplicationSecurityManager applicationSecurityManager) {
        this.applicationSecurityManager = applicationSecurityManager;
    }
}