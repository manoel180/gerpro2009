/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gerpro.controller;
import br.com.gerpro.service.PropostaService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author usuario
 */
public class SubmeterPropostaController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("submeterProposta");

}

     private PropostaService propostaService;

    public void setPropostaService(PropostaService propostaService) {
        this.propostaService = propostaService;
    }


}

