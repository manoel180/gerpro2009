/**
 * 
 */
package br.com.gerpro.util;

/**
 * @author M3R
 *
 */

import javax.servlet.http.HttpServletRequest;


public class ApplicationSecurityManager
{
    public static final String USER = "user";

    public Object getUser(HttpServletRequest request)
    {
        return request.getSession(true).getAttribute(USER);
    }

    public void setUser(HttpServletRequest request, Object usuario)
    {
        request.getSession(true).setAttribute(USER, usuario);
    }

    public void removeUser(HttpServletRequest request)
    {
        request.getSession(true).removeAttribute(USER);
    }
}
