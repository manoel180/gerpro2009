/**
 * 
 */
package br.com.gerpro.util;

/**
 * @author M3R
 *
 */

import javax.faces.context.FacesContext;

import br.com.gerpro.model.Usuario;


public class ApplicationSecurityManager
{
    public static final String USER = "usuario";
    /*private FacesContext context = FacesContext.getCurrentInstance();
    private HttpSession session = (HttpSession) context.getExternalContext().getSession(false);*/

    public Usuario getUsuario(){
    	
        // HttpSession session = (HttpSession) context.getExternalContext().getSession(false);    							
        //return (Usuario) session.getAttribute(USER);
    	
    	return (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(USER);
    }

    public void setUsuario(Object usuario)
    {
    	/*FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
    	session.setAttribute(USER, usuario);*/
    	
    	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(USER,usuario);    	
    	System.out.println("Usuario ***********" + usuario.toString());
    }

    public void removeUsuario()
    {
//    	FacesContext context = FacesContext.getCurrentInstance();
//        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
    	
    	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(USER);
    	
    	//session.removeAttribute(USER);
    }
}