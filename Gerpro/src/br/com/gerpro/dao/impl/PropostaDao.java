package br.com.gerpro.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.util.HibernateUtil;



public class PropostaDao implements FacadeProposta {

	
	private static	Session session = null;
	private static Transaction tx = null;
	
	
	@Override
	public void salvar(Proposta proposta) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(proposta);
			tx.commit();
			JOptionPane.showMessageDialog(null, "Alteração Realizada com sucesso", "GerPro - Alteração Realizada com Sucesso", 2);
		}
		catch (HibernateException e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Erro", "GerPro - Ocorreu um erro" + e, 1);
			e.printStackTrace();
		}
		catch (PersistenceException e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Erro", "GerPro - Ocorreu um erro" + e, 1);
			e.printStackTrace();
		} 
		catch (Exception e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Erro", "GerPro - Ocorreu um erro" + e, 1);
			e.printStackTrace();
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
		
	@SuppressWarnings("unchecked")
	@Override
	public List<Proposta> listarPorProfessor(Usuario professor){

		List<Proposta> result = null;
		
		Session session = HibernateUtil.getSession();	
		
		 		
		
		//Funcionando mas duplicando linhas
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
		
	@SuppressWarnings("unchecked")
	@Override	
	public List<Proposta> listarPorNome(String nomeProposta) {
		// TODO Auto-generated method stub
		List<Proposta> result = null;
		
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery("from Proposta where Nome like  :parametro");
		
				
		q.setParameter("parametro", nomeProposta+"%");
		
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
		} 
		catch (HibernateException e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Erro" +e, "GerPro - Ocorreu um erro", 1);
			e.printStackTrace();
		}
		catch (PersistenceException e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Erro"+e, "GerPro - Ocorreu um erro" , 1);
			e.printStackTrace();
		} 
		catch (Exception e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Erro"+e, "GerPro - Ocorreu um erro", 1);
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
}