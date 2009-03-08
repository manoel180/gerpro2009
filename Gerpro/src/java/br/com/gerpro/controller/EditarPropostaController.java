/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.controller;

import br.com.gerpro.command.DisplayIntIdCommand;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.service.PropostaService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

/** 
 *
 * @author M2R
 */
public class EditarPropostaController extends AbstractCommandController {

    public EditarPropostaController() {
        setCommandClass(DisplayIntIdCommand.class);
    }

@Override
    protected ModelAndView handle(HttpServletRequest request,
    HttpServletResponse response, Object command,
    BindException error) throws Exception {

    DisplayIntIdCommand displayPropostaCommand = (DisplayIntIdCommand) command;

    Proposta proposta = propostaService.findById(displayPropostaCommand.getId());

    return new ModelAndView("cadastroProposta", "proposta", proposta);

    }

    private PropostaService propostaService;

    public void setPropostaService(PropostaService propostaService) {
        this.propostaService = propostaService;
    }    
 
}