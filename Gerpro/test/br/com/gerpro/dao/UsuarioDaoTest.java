/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gerpro.dao;

import br.com.gerpro.model.Usuario;
import java.util.Iterator;
import java.util.List;
import junit.framework.TestCase;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Marcelo
 */
public class UsuarioDaoTest extends TestCase {
    
    public UsuarioDaoTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Test of findAll method, of class UsuarioDao.
     */
    public void testFindAll() {
        System.out.println("findAll");
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext ( "web/WEB-INF/gerpro-data.xml" );
        UsuarioDao usuarioDao = (UsuarioDao) factory.getBean("usuarioDao");       
        List<Usuario> result = usuarioDao.findAll();
        
        Iterator iterator = result.iterator();
        while( iterator.hasNext()){
           System.out.println(((Usuario)iterator.next()).getNome());
        }
        assertNotNull(result);
       
    }

    /**
     * Test of findByName method, of class UsuarioDao.
     */
    public void testFindByName() {
        System.out.println("findByName");
        String name = "";
       
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext ( "web/WEB-INF/gerpro-data.xml" );
        UsuarioDao usuarioDao = (UsuarioDao) factory.getBean("usuarioDao");
        List<Usuario> result = usuarioDao.findByName(name);
        assertNotNull(result);       
    }

    /**
     * Test of findAllUsuariosByTipo method, of class UsuarioDao.
     */
    public void testFindAllUsuariosByTipo() {
        System.out.println("findAllUsuariosByTipo");
        String tipo = "Aluno";
        
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext ( "web/WEB-INF/gerpro-data.xml" );
        UsuarioDao usuarioDao = (UsuarioDao) factory.getBean("usuarioDao");
        List<Usuario> result = usuarioDao.findAllUsuariosByTipo(tipo);
        assertNotNull(result);
        
    }

    /**
     * Test of findAlunosSemEquipe method, of class UsuarioDao.
     */
    public void testFindAlunosSemEquipe() {
        System.out.println("findAlunosSemEquipe");
        
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext ( "web/WEB-INF/gerpro-data.xml" );
        UsuarioDao usuarioDao = (UsuarioDao) factory.getBean("usuarioDao");

        List<Usuario> result = usuarioDao.findAlunosSemEquipe();
        assertNotNull(result);        
    }

}
