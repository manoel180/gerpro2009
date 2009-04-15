/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gerpro.service.impl;

import br.com.gerpro.dao.PropostaDao;
import br.com.gerpro.dao.PropostaItemDao;
import br.com.gerpro.dao.StatusDao;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Status;
import br.com.gerpro.service.EquipeService;
import br.com.gerpro.service.PropostaService;
import br.com.gerpro.service.UsuarioService;
import java.util.List;
import junit.framework.TestCase;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.transaction.support.TransactionTemplate;

/**
 *
 * @author Marcelo
 */
public class PropostaServiceImplTest extends TestCase {
    
    public PropostaServiceImplTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Test of createProposta method, of class PropostaServiceImpl.
     */
    public void testCreateProposta() {
        System.out.println("createProposta");
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext ( "web/WEB-INF/gerpro-service.xml" );
        PropostaService propostaService = (PropostaService)factory.getBean("propostaService");

        Proposta proposta = new Proposta();
        proposta.setNome("TesteUnitarioDeProposta");

        String expResult = "Ok";
        String result = propostaService.createProposta(proposta);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of updateProposta method, of class PropostaServiceImpl.
     */
    public void testUpdateProposta() {
        System.out.println("updateProposta");
        Proposta proposta = null;
        PropostaServiceImpl instance = new PropostaServiceImpl();
        instance.updateProposta(proposta);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of changeStatusProposta method, of class PropostaServiceImpl.
     */
    /*public void testChangeStatusProposta() {
    System.out.println("changeStatusProposta");
    Proposta proposta = null;
    PropostaServiceImpl instance = new PropostaServiceImpl();
    instance.changeStatusProposta(proposta);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/

    /**
     * Test of findById method, of class PropostaServiceImpl.
     */
    /*public void testFindById() {
    System.out.println("findById");
    int id = 0;
    PropostaServiceImpl instance = new PropostaServiceImpl();
    Proposta expResult = null;
    Proposta result = instance.findById(id);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/

    /**
     * Test of listAll method, of class PropostaServiceImpl.
     */
    public void testListAll() {
        System.out.println("listAll");
        PropostaServiceImpl instance = new PropostaServiceImpl();
        List expResult = null;
        List result = instance.listAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listPropostaByStatus method, of class PropostaServiceImpl.
     */
    public void testListPropostaByStatus() {
        System.out.println("listPropostaByStatus");
        Status status = null;
        PropostaServiceImpl instance = new PropostaServiceImpl();
        List expResult = null;
        List result = instance.listPropostaByStatus(status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEquipeService method, of class PropostaServiceImpl.
     */
    public void testSetEquipeService() {
        System.out.println("setEquipeService");
        EquipeService equipeService = null;
        PropostaServiceImpl instance = new PropostaServiceImpl();
        instance.setEquipeService(equipeService);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPropostaDao method, of class PropostaServiceImpl.
     */
    public void testSetPropostaDao() {
        System.out.println("setPropostaDao");
        PropostaDao propostaDao = null;
        PropostaServiceImpl instance = new PropostaServiceImpl();
        instance.setPropostaDao(propostaDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuarioService method, of class PropostaServiceImpl.
     */
    public void testSetUsuarioService() {
        System.out.println("setUsuarioService");
        UsuarioService usuarioService = null;
        PropostaServiceImpl instance = new PropostaServiceImpl();
        instance.setUsuarioService(usuarioService);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTransactionTemplate method, of class PropostaServiceImpl.
     */
    public void testSetTransactionTemplate() {
        System.out.println("setTransactionTemplate");
        TransactionTemplate transactionTemplate = null;
        PropostaServiceImpl instance = new PropostaServiceImpl();
        instance.setTransactionTemplate(transactionTemplate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatusDao method, of class PropostaServiceImpl.
     */
    public void testSetStatusDao() {
        System.out.println("setStatusDao");
        StatusDao statusDao = null;
        PropostaServiceImpl instance = new PropostaServiceImpl();
        instance.setStatusDao(statusDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPropostaItemDao method, of class PropostaServiceImpl.
     */
    public void testSetPropostaItemDao() {
        System.out.println("setPropostaItemDao");
        PropostaItemDao propostaItemDao = null;
        PropostaServiceImpl instance = new PropostaServiceImpl();
        instance.setPropostaItemDao(propostaItemDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
