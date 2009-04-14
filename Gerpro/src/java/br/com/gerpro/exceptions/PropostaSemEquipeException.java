/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gerpro.exceptions;

/**
 *
 * @author Marcelo
 */
public class PropostaSemEquipeException extends Exception{

    public PropostaSemEquipeException(String message) {
        super(message + "Proposta não possue equipe relacionada.");
    }    

}
