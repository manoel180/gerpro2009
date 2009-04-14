/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.dao;

import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Status;
import java.util.Date;
import java.util.List;
import junit.framework.TestCase;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Marcelo
 */
public class PropostaDaoTest extends TestCase {

    public PropostaDaoTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testCreate() {
        System.out.println("create");

        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/gerpro-data.xml");
        PropostaDao propostaDao = (PropostaDao) factory.getBean("propostaDao");
        StatusDao statusDao = (StatusDao) factory.getBean("statusDao");
        EquipeDao equipeDao = (EquipeDao) factory.getBean("equipeDao");

        //new Equipe("TestePropostaCreate")

        Proposta proposta = new Proposta(equipeDao.read(6), statusDao.read(1), "TesteCreateProposta2", new Date(), " ");

        int resultado = propostaDao.create(proposta);

        System.out.println(resultado + "**************");
        assertNotNull(resultado);

    }

    /**
     * Teste do método read estendido da classe HibernateGenericDao.java.
     */
    public void testRead() {
        System.out.println("read");
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/gerpro-data.xml");

        PropostaDao propostaDao = (PropostaDao) factory.getBean("propostaDao");

        Proposta proposta = propostaDao.read(1);

        System.out.println(proposta.getNome() + "**************");
    }

    /**
     * Teste do método update estendido da classe HibernateGenericDao.java.
     */
    public void testUpdate() {
        System.out.println("update");
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/gerpro-data.xml");

        PropostaDao propostaDao = (PropostaDao) factory.getBean("propostaDao");

        Proposta proposta = propostaDao.read(6);



        proposta.setNome(proposta.getNome() + "Atualizado");

        propostaDao.update(proposta);

        System.out.println(proposta.getNome() + "**************");

    }

    /**
     * Teste do método delete estendido da classe HibernateGenericDao.java.
     */
    public void testDelete() {
        System.out.println("delete");
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/gerpro-data.xml");

        PropostaDao propostaDao = (PropostaDao) factory.getBean("propostaDao");

        Proposta proposta = propostaDao.read(7);

        propostaDao.delete(proposta);

        
    }

    /**
     * Test of findByStatus method, of class PropostaDao.
     */
    public void testFindByStatus() {
        System.out.println("findByStatus");
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/gerpro-data.xml");
        PropostaDao propostaDao = (PropostaDao) factory.getBean("propostaDao");
        StatusDao statusDao = (StatusDao) factory.getBean("statusDao");

        Status status = statusDao.read(1);
        List<Proposta> result = propostaDao.findByStatus(status);

        for (Proposta proposta : result) {
            System.out.printf(proposta.getNome());
        }
        assertNotNull(result);


    }

    /**
     * Test of findAll method, of class PropostaDao.
     */
    public void testFindAll() {
        System.out.println("findAll");
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/gerpro-data.xml");
        PropostaDao instance = (PropostaDao) factory.getBean("propostaDao");

        List<Proposta> result = instance.findAll();

        for (Proposta proposta : result) {
            System.out.printf(proposta.getNome());
        }
        assertNotNull(result);

    }
}
