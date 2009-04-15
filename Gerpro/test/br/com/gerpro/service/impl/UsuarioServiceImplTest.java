/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.service.impl;

import br.com.gerpro.dao.TipoUsuarioDao;
import br.com.gerpro.dao.UsuarioDao;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.service.UsuarioService;
import java.util.List;
import junit.framework.TestCase;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Marcelo
 */
public class UsuarioServiceImplTest extends TestCase {

    public UsuarioServiceImplTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Test of validaLoginUsuario method, of class UsuarioServiceImpl.
     */
    public void testValidaLoginUsuario() {
        System.out.println("validaLoginUsuario");
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/ApplicationContext-test.xml");

        UsuarioService usuarioService = (UsuarioServiceImpl) factory.getBean("usuarioService");
        TipoUsuarioDao tipoUsuarioDao = (TipoUsuarioDao) factory.getBean("tipoUsuarioDao");

        Usuario usuario = new Usuario("06139981", tipoUsuarioDao.read(1), "Marcelo de Souza", "281075");

        String result = usuarioService.validaLoginUsuario(usuario);

        String expResult = "Aluno";

        assertEquals(expResult, result);

    }

    /**
     * Test of updateUsuario method, of class UsuarioServiceImpl.
     */
    public void testUpdateUsuario() {
        System.out.println("updateUsuario");
        Usuario usuario = null;
        UsuarioServiceImpl instance = new UsuarioServiceImpl();
        String expResult = "";
        String result = instance.updateUsuario(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createUsuario method, of class UsuarioServiceImpl.
     */
    public void testCreateUsuario() {
        System.out.println("createUsuario");
        Usuario usuarioTransiente = null;
        int tipo = 0;
        UsuarioServiceImpl instance = new UsuarioServiceImpl();
        String expResult = "";
        String result = instance.createUsuario(usuarioTransiente, tipo);
        assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
    }

    /**
     * Test of listAll method, of class UsuarioServiceImpl.
     */
    public void testListAll() {
        System.out.println("listAll");
        UsuarioServiceImpl instance = new UsuarioServiceImpl();
        List expResult = null;
        List result = instance.listAll();
        assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
    }

    /**
     * Test of listByTipo method, of class UsuarioServiceImpl.
     */
    public void testListByTipo() {
        System.out.println("listByTipo");
        String tipo = "";
        UsuarioServiceImpl instance = new UsuarioServiceImpl();
        List expResult = null;
        List result = instance.listByTipo(tipo);
        assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario method, of class UsuarioServiceImpl.
     */
    public void testGetUsuario() {
        System.out.println("getUsuario");
        String matricula = "";
        UsuarioServiceImpl instance = new UsuarioServiceImpl();
        Usuario expResult = null;
        Usuario result = instance.getUsuario(matricula);
        assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
    }

    /**
     * Test of listAlunosSemEquipe method, of class UsuarioServiceImpl.
     */
    public void testListAlunosSemEquipe() {
        System.out.println("listAlunosSemEquipe");
        UsuarioServiceImpl instance = new UsuarioServiceImpl();
        List expResult = null;
        List result = instance.listAlunosSemEquipe();
        assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuarioDao method, of class UsuarioServiceImpl.
     */
    public void testSetUsuarioDao() {
        System.out.println("setUsuarioDao");
        UsuarioDao usuarioDao = null;
        UsuarioServiceImpl instance = new UsuarioServiceImpl();
        instance.setUsuarioDao(usuarioDao);
// TODO review the generated test code and remove the default call to fail.
//fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoUsuarioDao method, of class UsuarioServiceImpl.
     */
    public void testSetTipoUsuarioDao() {
        System.out.println("setTipoUsuarioDao");
        TipoUsuarioDao tipoUsuarioDao = null;
        UsuarioServiceImpl instance = new UsuarioServiceImpl();
        instance.setTipoUsuarioDao(tipoUsuarioDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
