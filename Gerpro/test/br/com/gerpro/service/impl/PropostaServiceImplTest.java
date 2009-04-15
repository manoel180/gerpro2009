/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.service.impl;

import java.util.List;
import junit.framework.TestCase;
import br.com.gerpro.dao.EquipeDao;
import br.com.gerpro.dao.StatusDao;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.service.PropostaService;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Classe de teste unitário para a classe PropostaSeviceImpl
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
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/ApplicationContext-test.xml");
        PropostaService propostaService = (PropostaService) factory.getBean("propostaService");
        EquipeDao equipeDao = (EquipeDao) factory.getBean("equipeDao");
        StatusDao statusDao = (StatusDao) factory.getBean("statusDao");

        Proposta proposta = new Proposta();
        proposta.setNome("TesteUnitarioDeProposta2");
        proposta.setEquipe(equipeDao.read(6));
        proposta.setPeriodo("2009/01");
        proposta.setStatus(statusDao.read(1));
        String result = propostaService.createProposta(proposta);
        //assertEquals(expResult, result);

        System.out.println(" ***************** " + result + " ***************** ");

    }

    /**
     * Test of updateProposta method, of class PropostaServiceImpl.
     */
    public void testUpdateProposta() {
        System.out.println("updateProposta");
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/ApplicationContext-test.xml");
        PropostaService propostaService = (PropostaService) factory.getBean("propostaService");

        Proposta proposta = propostaService.findById(4);
        proposta.setNome(proposta.getNome() + " de novo");
        propostaService.updateProposta(proposta);

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
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/ApplicationContext-test.xml");
        PropostaService propostaService = (PropostaService) factory.getBean("propostaService");
        List result = propostaService.listAll();
        assertNotNull(result);
    }

    /**
     * Test of listPropostaByStatus method, of class PropostaServiceImpl.
     */
    public void testListPropostaByStatus() {
        System.out.println("listPropostaByStatus");
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/ApplicationContext-test.xml");
        PropostaService propostaService = (PropostaService) factory.getBean("propostaService");
        StatusDao statusDao = (StatusDao) factory.getBean("statusDao");
        List result = propostaService.listPropostaByStatus(statusDao.read(1));
        assertNotNull(result);   
    }

    public void testVerificaNomeProposta() {
        System.out.println("verificaNomeProposta");
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/ApplicationContext-test.xml");
        PropostaService propostaService = (PropostaService) factory.getBean("propostaService");
        if (propostaService.verificaNomeProposta("TesteUnitarioDeProposta")) {
            System.out.println("Nome da Proposta já existe");
        } else {
            System.out.println("Nome da Proposta não existe");
        }
    
    }
}
