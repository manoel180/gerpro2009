/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gerpro.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 *
 * @author M2R
 */
public class HttpRequestInterceptor extends HandlerInterceptorAdapter
{
    private String loginPage;
    //private ApplicationSecurityManager applicationSecurityManager;

    /**
     * Uses ApplicationSecurityManager to ensure user is logged in; if not,
     * then user is forwarded to the sign-in page.
     * @see ApplicationSecurityManager
     */
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception
    {
        /*Employee employee = (Employee) applicationSecurityManager.getEmployee(request);
        if (employee == null)
        {
        response.sendRedirect(this.signInPage);
        return false;
        }*/

        return true;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    

    /*public ApplicationSecurityManager getApplicationSecurityManager()
    {
    return applicationSecurityManager;
    }

    public void setApplicationSecurityManager(
    ApplicationSecurityManager applicationSecurityManager)
    {
    this.applicationSecurityManager = applicationSecurityManager;
    }*/
}

