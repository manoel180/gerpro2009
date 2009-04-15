/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gerpro.service;

import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Status;
import java.util.List;

/**
 * Interface para definição de serviços da classe Proposta.
 * @author M3R
 */
public interface PropostaService {
    /**
     * Método para criação de propostas
     * @param proposta
     * @return Retorna a String contendo a mensagem
     * de confirmação de criação da Proposta
     */
    public String createProposta(final Proposta proposta);

    /**
     * Método para busca de propostas pelo Id.
     * @param id
     * @return Proposta
     */
    public Proposta findById(int id);

    /**
     * Método para atualização de propostas
     * @param proposta
     */
    public void updateProposta(Proposta proposta);

    /**
     * Método para mudança do status da proposta
     * @param proposta
     */
    public void changeStatusProposta(Proposta proposta);

    /**
     * Método para verificar se o nome da proposta já existe.
     * @param string
     */
    public boolean verificaNomeProposta(String nome);

    /**
     * Método para listar todas as propostas
     * @return List
     */
    public List listAll();

    /**
     * Método para listar propostas com um dado status.
     * @param status
     * @return List
     */
    public List listPropostaByStatus(Status status);
}
