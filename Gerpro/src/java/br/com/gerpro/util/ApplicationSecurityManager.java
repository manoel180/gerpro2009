package br.com.gerpro.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Gerencia a implantação, retorno e remoção de um objeto Usuario da sessão
 */
public class ApplicationSecurityManager
{
    public static final String USER = "user";

    public Object getUsuario(HttpServletRequest request)
    {
        return request.getSession(true).getAttribute(USER);
    }

    public void setUsuario(HttpServletRequest request, Object usuario)
    {
        request.getSession(true).setAttribute(USER, usuario);
    }

    public void removeUsuario(HttpServletRequest request)
    {
        request.getSession(true).removeAttribute(USER);
    }
}
