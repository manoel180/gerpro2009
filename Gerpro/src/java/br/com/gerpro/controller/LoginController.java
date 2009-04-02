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
 * Classe para validação de login do usuario, inserção deste na sessão
 *
 * @author Marcelo
 *
 *
 * 
 */
public class LoginController extends MultiActionController {

    //Construtor  padrão para uso do Spring
    public LoginController() {}

    //Método para a visualização da interface de usuario de login.
    public ModelAndView display(HttpServletRequest request, HttpServletResponse response) {
        //Novo usuario
        Usuario usuario = new Usuario();
        //Relaciona o usuario ao request
        ServletRequestDataBinder binder = new ServletRequestDataBinder(usuario);
        binder.bind(request);

        //Retorna a ModelAndView
        return new ModelAndView("loginView", "usuario", usuario);
    }


    //Valida o usuário no banco de dados e insere o mesmo na sessão
    public ModelAndView valida(HttpServletRequest request, HttpServletResponse response, Usuario usuario) {

        //Relaciona o usuario ao request
        ServletRequestDataBinder binder = new ServletRequestDataBinder(usuario);
        binder.bind(request);

        //Valida o usuario e senha no bando de dados
        String successView = usuarioService.validaLoginUsuario(usuario);

        if(successView.equals("erro")){
            return new ModelAndView("erro");
        }

        //Insere o objeto usuario na sessão
        applicationSecurityManager.setUsuario(request, usuario);

        //Constrói a successView
        successView = "bemVindo" + successView;

        //Retorna a ModelAndView
        return new ModelAndView(successView);
    }

    public ModelAndView remove(HttpServletRequest request, HttpServletResponse response, Usuario usuario) {
        //Relaciona o usuario ao request
        ServletRequestDataBinder binder = new ServletRequestDataBinder(usuario);
        binder.bind(request);

        //Remove o usuario da sessão
        applicationSecurityManager.removeUsuario(request);

        //Retorna a ModelAndView
        return new ModelAndView("login.htm");
    }

    //Componentes
    private UsuarioServiceImpl usuarioService;
    private ApplicationSecurityManager applicationSecurityManager;

    public void setUsuarioService(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }    

    public void setApplicationSecurityManager(ApplicationSecurityManager applicationSecurityManager) {
        this.applicationSecurityManager = applicationSecurityManager;
    }

}