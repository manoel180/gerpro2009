/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gerpro.dao;

import br.com.gerpro.model.Equipe;
import java.util.Iterator;
import java.util.List;
import junit.framework.TestCase;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Marcelo
 */
public class EquipeDaoTest extends TestCase {
    
    public EquipeDaoTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Test of findAll method, of class EquipeDao.
     */
    public void testFindAll() {
        System.out.println("findAll");
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext ( "web/WEB-INF/gerpro-data.xml" );
        EquipeDao equipeDao = (EquipeDao)factory.getBean("equipeDao");        
        List<Equipe> result = equipeDao.findAll();

        Iterator iterator = result.iterator();
        while( iterator.hasNext()){
           System.out.println(((Equipe)iterator.next()).getNome());
        }
        assertNotNull(result);
        
    }

}
