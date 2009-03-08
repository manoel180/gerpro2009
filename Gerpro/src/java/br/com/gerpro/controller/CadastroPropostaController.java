/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.controller;

import br.com.gerpro.model.Equipe;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.service.PropostaService;
import br.com.gerpro.service.UsuarioService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/** 
 *
 * @author M2R
 */
public class CadastroPropostaController extends SimpleFormController {

    private int id;

    public CadastroPropostaController() {
        setCommandClass(Proposta.class);
        setCommandName("proposta");
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        /*if(request.getParameter() != null
        && request.getParameter(id).trim().length() >0 ){
        return propostaService.findById(matricula);
        }*/
        Proposta propostaForm = (Proposta) super.formBackingObject(request);
        Equipe equipe = new Equipe();
        Set alunos = new HashSet();
        equipe.setUsuarios(alunos);
        propostaForm.setEquipe(equipe);

        return propostaForm;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map referenceData = new HashMap();
        referenceData.put("alunosSemEquipe", usuarioService.listAlunosSemEquipe());

        return referenceData;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command,
            BindException errors) throws Exception {
        Proposta proposta = (Proposta) command;
        propostaService.createProposta(proposta);//, proposta.getEquipe(),(List) proposta.getEquipe().getUsuarios());

        return new ModelAndView(getSuccessView());
    }
    
    private PropostaService propostaService;

    public void setPropostaService(PropostaService propostaService) {
        this.propostaService = propostaService;
    }
    private UsuarioService usuarioService;

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    
}