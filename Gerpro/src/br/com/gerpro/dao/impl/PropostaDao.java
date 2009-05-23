package br.com.gerpro.dao.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.util.HibernateUtil;



public class PropostaDao implements FacadeProposta {

	
	private static	Session session = null;
	private static Transaction tx = null;
	
	@Override
	public void alterar(Proposta proposta) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(proposta);
			tx.commit();
			JOptionPane.showMessageDialog(null, "Alteração Realizada com sucesso");
		} catch (Exception e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	//Funcionando
	@Override
	public void inserir(Proposta proposta) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(proposta);
			tx.commit();
			JOptionPane.showMessageDialog(null, "\"Cadastrado com Sucesso\"");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
		} finally {
			session.close();
		}
	}
	@Override
	public List<Proposta> listar() {

		List<Proposta> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery(" from Proposta ");
		
		result = q.list();
		
		session.close();
		return result;
	}
	//Consulta 1
	@Override
	public List<Proposta> listarOrdemAlfabetica() {

		List<Proposta> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery(" from Proposta order by nome ");
		
		result = q.list();
		
		session.close();
		return result;
		
	}
	
	//consulta 2
	//Lista por letra
	@SuppressWarnings("unchecked")
	@Override
	public List<Proposta> listarPorProfessor(Usuario professor){

		List<Proposta> result = null;
		
		Session session = HibernateUtil.getSession();
				 
		result = session.createSQLQuery(" select *" +
				" from proposta p" +
				" inner join correcao co on co.id_proposta = p.id" +
				" where co.matricula_professor like ? ")
				.addEntity(Proposta.class)
				.setParameter(0, professor.getMatricula())
				.list();	
		
		session.close();
		return result;
	}
		
	//consulta 3
	//consulta
	@SuppressWarnings("unchecked")
	@Override	
	public List<Proposta> listarPorNome(String nomeProposta) {
		// TODO Auto-generated method stub
		List<Proposta> result = null;
		
		Session session = HibernateUtil.getSession();
		
		//Query q = session.createQuery("from Proposta where Nome like  :parametro");
		
		Query q = session.createQuery(
				" FROM Proposta " 
				);		
		//q.setParameter("parametro", nomeProposta+"%");
		
		result = q.list();
		
		for (Proposta proposta : result) {
			proposta.getEquipe().getNome();
			
		}
			
		
		
		
		session.close();
		return result;
	}

	   

	@Override
	public  Proposta procurarPorId(int id) {
		// TODO Auto-generated method stub

		Proposta result = null;

		Session session = HibernateUtil.getSession();
		result = (Proposta) session.get(Proposta.class, id);
	
		session.close();
		return result;
	}

	@Override
	public Proposta procurarPorNome(String Nome) {
		// TODO Auto-generated method stub

		Proposta result = null;

		Session session = HibernateUtil.getSession();
		result = (Proposta) session.get(Proposta.class, Nome);
		if (result == null) {
			JOptionPane.showMessageDialog(null, "Não encontrado");
		}
		session.close();
		return result;
	}
	
	@Override
	public  void remover(Proposta proposta) {

		try {
			session=null;
			tx = null;
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(proposta);
			tx.commit();
			JOptionPane.showMessageDialog(null, "Eliminado com sucesso");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu algum erro!");
		} finally {
			session.close();
		}
	}
	@Override
	public JasperPrint gerarRelatorio() {
		JasperPrint rel = null;
		try {
			session=null;
			tx = null;
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			
		
			//Connection con = gConexao.getConexao();
			HashMap map = new HashMap();
			
			// Verificar como chamar da pasta do projeto
		//	String arquivoJasper =  System.getProperty("java.class.path") + "/br/com/gerpro/relatorios/proposta.jasper";	
			

			//String rootDir = "./br/com/gerpro/relatorios/"; 
			java.util.Map parameters = new HashMap(); 
			//parameters.put("rootDir", rootDir+ java.io.File.separator); 
			ServletContext objto = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
			String path =  objto + "/br/com/gerpro/relatorios/proposta.jasper";
//			JasperReport jasperReport =	JasperCompileManager.compileReport(arquivoJasper);
			//JasperReport relatorio = JasperManager.loadReport(path);
		
			/*InputStream reportSource = this.getClass().getResourceAsStream(arquivoJasper);
			JasperReport jasperReport2 =	JasperCompileManager.compileReport(arquivoJasper);*/
			rel = JasperFillManager.fillReport(path, map, session.connection());
		} catch (JRException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return rel;
	}

}