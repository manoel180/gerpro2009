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
     * Teste do método create estendido da classe HibernateGenericDao.java.
     */
    public void testCreate() {
        System.out.println("create");

        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/gerpro-data.xml");

        UsuarioDao usuarioDao = (UsuarioDao) factory.getBean("usuarioDao");

        TipoUsuarioDao tipoUsuarioDao = (TipoUsuarioDao) factory.getBean("tipoUsuarioDao");

        Usuario usuario = new Usuario("123159", tipoUsuarioDao.read(1), "teste", "senha");

        String resultado = usuarioDao.create(usuario);

        System.out.println(resultado + "**************");
        assertNotNull(resultado);
    }

    /**
     * Teste do método read estendido da classe HibernateGenericDao.java.
     */
    public void testRead() {
        System.out.println("read");
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/gerpro-data.xml");
        UsuarioDao usuarioDao = (UsuarioDao) factory.getBean("usuarioDao");
        Usuario usuario = usuarioDao.read("123159");
        System.out.println(usuario.getNome() + "    **************");
        assertNotNull(usuario);
    }

    /**
     * Teste do método update estendido da classe HibernateGenericDao.java.
     */
    public void testUpdate() {
        System.out.println("update");
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/gerpro-data.xml");
        UsuarioDao usuarioDao = (UsuarioDao) factory.getBean("usuarioDao");
        Usuario usuario = usuarioDao.read("123159");
        usuario.setNome("Teste Atualizado");

        usuarioDao.update(usuario);

        System.out.println(usuario.getNome() + "    **************");

        assertNotNull(usuario);

    }

    /**
     * Teste do método delete estendido da classe HibernateGenericDao.java.
     */
    public void testDelete() {
        System.out.println("delete");
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/gerpro-data.xml");
        UsuarioDao usuarioDao = (UsuarioDao) factory.getBean("usuarioDao");
        Usuario usuario = usuarioDao.read("123159");
        usuario.setNome("Teste Atualizado");

        usuarioDao.delete(usuario);

        System.out.println(usuario.getNome() + "    **************");

        Usuario usuario2 = usuarioDao.read("123159");
        assertNull(usuario2);

    }

    /**
     * Teste do método findAll, da classe UsuarioDao.
     */
    public void testFindAll() {
        System.out.println("findAll");
        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/gerpro-data.xml");
        UsuarioDao usuarioDao = (UsuarioDao) factory.getBean("usuarioDao");
        List<Usuario> result = usuarioDao.findAll();

        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println(((Usuario) iterator.next()).getNome());
        }
        assertNotNull(result);

    }

    /**
     * Teste do método findByName, da classe UsuarioDao.     *
     */
    public void testFindByName() {
        System.out.println("findByName");
        String name = "";

        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/gerpro-data.xml");
        UsuarioDao usuarioDao = (UsuarioDao) factory.getBean("usuarioDao");
        List<Usuario> result = usuarioDao.findByName(name);
        assertNotNull(result);
    }

    /**
     * Teste do método findAllUsuariosByTipo, da classe UsuarioDao.     *
     */
    public void testFindAllUsuariosByTipo() {
        System.out.println("findAllUsuariosByTipo");
        String tipo = "Aluno";

        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/gerpro-data.xml");
        UsuarioDao usuarioDao = (UsuarioDao) factory.getBean("usuarioDao");
        List<Usuario> result = usuarioDao.findAllUsuariosByTipo(tipo);
        assertNotNull(result);

    }

    /**
     * Teste do método findAlunosSemEquipe, da classe UsuarioDao.     *
     */
    public void testFindAlunosSemEquipe() {
        System.out.println("findAlunosSemEquipe");

        FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext("web/WEB-INF/gerpro-data.xml");
        UsuarioDao usuarioDao = (UsuarioDao) factory.getBean("usuarioDao");

        List<Usuario> result = usuarioDao.findAlunosSemEquipe();
        assertNotNull(result);
    }
}
