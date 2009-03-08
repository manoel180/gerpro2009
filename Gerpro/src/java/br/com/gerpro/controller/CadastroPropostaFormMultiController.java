/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.controller;

import br.com.gerpro.model.Proposta;
import br.com.gerpro.service.impl.PropostaServiceImpl;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author M2R
 */
public class CadastroPropostaFormMultiController extends MultiActionController {

    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        List propostas = propostaService.listAll();
        return new ModelAndView("listaPropostas", "propostas", propostas);
    }

    public ModelAndView create(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView();
    }

    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, Proposta command) {
        Proposta propostaForm = (Proposta) command;
        System.out.println(propostaForm.getId() +" \t " + propostaForm.getNome()  );
        ServletRequestDataBinder binder = new ServletRequestDataBinder(propostaForm);
        binder.bind(request);        
        return new ModelAndView("cadastroPropostaEdit", "proposta", propostaForm);//propostaDB);
    }

    public ModelAndView save(HttpServletRequest request, HttpServletResponse response, Proposta propostaForm) {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(propostaForm);
        propostaService.saveProposta(propostaForm);
        binder.bind(request);
        return new ModelAndView("salvo");        
    }

    @Override
    protected Object newCommandObject(Class clazz) throws Exception {
        return super.newCommandObject(Proposta.class);
    }

    private PropostaServiceImpl propostaService;

    public void setPropostaService(PropostaServiceImpl propostaService) {
        this.propostaService = propostaService;
    }   
}