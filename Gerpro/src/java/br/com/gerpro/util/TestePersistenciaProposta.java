/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gerpro.util;

import br.com.gerpro.model.Proposta;
import br.com.gerpro.service.impl.PropostaServiceImpl;
import java.util.Date;

/**
 *
 * @author M2R
 */
public class TestePersistenciaProposta {
    public static void main(String [] args){
        PropostaServiceImpl impl = new PropostaServiceImpl();
        Proposta proposta = new Proposta();
        proposta.setNome("Teste 2");
        proposta.setDataCriacao("20/02/2009");
        impl.createProposta(proposta);

    }

}
