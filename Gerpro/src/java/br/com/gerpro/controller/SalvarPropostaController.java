/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gerpro.controller;


import br.com.gerpro.model.Proposta;
import br.com.gerpro.service.PropostaService;
import br.com.gerpro.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindException;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


/**
 *
 * @author M2R
 */
public class SalvarPropostaController extends SimpleFormController{//extends AbstractCommandController{

    public SalvarPropostaController() {
        setCommandClass(Proposta.class);
        setCommandName("proposta");
        setFormView("cadastroPropostaEdit");
        setSuccessView("salvo");
    }

    /*@Override
    protected void doSubmitAction(Object command) throws Exception {
    Proposta proposta = (Proposta) command;
    System.out.println("Proposta: " + proposta.getNome());
    System.out.println("Equipe: " + proposta.getEquipe().getNome());
    propostaService.saveProposta(proposta);
    }*/

    @Override
    protected ModelAndView onSubmit(Object command, BindException errors) throws Exception {
        Proposta proposta = (Proposta) command;
        System.out.println("Proposta: " + proposta.getNome());
        System.out.println("Equipe: " + proposta.getEquipe().getNome());
        propostaService.createProposta(proposta);
        return new ModelAndView(getSuccessView());
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        Proposta proposta = (Proposta)super.formBackingObject(request);
        return proposta;
    }



    /*@Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
    Map referenceData = new HashMap();
    referenceData.put("alunos", alunoService.findByEquipe(propostaService.getEquipe(proposta.getEquipe().))
    return super.referenceData(request);
    }*/




    


    /*protected ModelAndView handle(HttpServletRequest request,
    HttpServletResponse response, Object command, BindException error) throws Exception {
    Proposta proposta = (Proposta) command;
    propostaService.saveProposta(proposta);

    return new ModelAndView("salvo","proposta",proposta);

    }*/

    //Componentes
    private PropostaService propostaService;

    public void setPropostaService(PropostaService propostaService) {
        this.propostaService = propostaService;
    }

    private UsuarioService usuarioService;

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    

}
