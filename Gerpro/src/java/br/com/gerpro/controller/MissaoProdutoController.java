/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.controller;

import br.com.gerpro.model.PropostaItem;
import br.com.gerpro.service.PropostaService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Marcelo&Marcela
 */
public class MissaoProdutoController extends SimpleFormController {

    public MissaoProdutoController() {

        setFormView("missaoProduto");
        setCommandClass(PropostaItem.class);
        setCommandName("item");
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request)
            throws Exception {
        PropostaItem propostaItem = (PropostaItem) super.formBackingObject(request);

        return propostaItem;
    }

    

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response,
            Object command,
            BindException errors)
            throws Exception {

        PropostaItem propostaItem = (PropostaItem) command;



        return super.onSubmit(request, response, command, errors);
    }

    //Componente
    private PropostaService propostaService;

    public void setPropostaService(PropostaService propostaService) {
        this.propostaService = propostaService;
    }
    

    private PropostaItem propostaItem;

    public void setPropostaItem(PropostaItem propostaItem) {
        this.propostaItem = propostaItem;
    }




}