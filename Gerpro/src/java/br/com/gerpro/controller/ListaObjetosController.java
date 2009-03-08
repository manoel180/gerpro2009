/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.controller;

import br.com.gerpro.service.PropostaService;
import br.com.gerpro.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author M2R
 */
public class ListaObjetosController extends MultiActionController {

    public ModelAndView alunos(HttpServletRequest request, HttpServletResponse response) {

        return new ModelAndView("listaAlunos", "alunos", usuarioService.listByTipo("Aluno"));
    }

    public ModelAndView alunosSemEquipe(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("selecionaAlunos", "alunosSemEquipe", usuarioService.listAlunosSemEquipe());
    }

    public ModelAndView propostas(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("listaPropostas", "propostas", propostaService.listAll());
    }

    /*public ModelAndView professores(HttpServletRequest request, HttpServletResponse response) {
    return new ModelAndView("listaProfessores", "professores", professorDao.listAll());
    }*/
    private UsuarioService usuarioService;

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    private PropostaService propostaService;

    public void setPropostaService(PropostaService propostaService) {
        this.propostaService = propostaService;
    }

    /*private ProfessorDao professorDao;

    public void setProfessorDao(ProfessorDao professorDao) {
    this.professorDao = professorDao;
    }*/
}
