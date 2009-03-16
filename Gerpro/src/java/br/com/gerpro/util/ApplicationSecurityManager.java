package br.com.gerpro.util;

import br.com.gerpro.command.ApplicationConstants;
import javax.servlet.http.HttpServletRequest;

/**
 * Gerencia a implantação, retorno e remoção de um objeto Usuario da sessão
 */
public class ApplicationSecurityManager
{

    public static final String USER = "usuario";



    public Object getUsuario(HttpServletRequest request)
    {
        return request.getSession(true).getAttribute(ApplicationConstants.USER_OBJECT);
    }

    public void setUsuario(HttpServletRequest request, Object usuario)
    {
        request.getSession(true).setAttribute(ApplicationConstants.USER_OBJECT,
                usuario);
    }

    public void removeUsuario(HttpServletRequest request)
    {
        request.getSession(true).removeAttribute(ApplicationConstants.USER_OBJECT);
    }
}
