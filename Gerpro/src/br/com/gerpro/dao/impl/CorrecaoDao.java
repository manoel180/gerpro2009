/**
 * 
 */
package br.com.gerpro.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import br.com.gerpro.dao.FacadeCorrecao;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.util.HibernateUtil;

/**
 * @author M3R
 *
 */
public class CorrecaoDao implements FacadeCorrecao {
	private static	Session session = null;
	private static Transaction tx = null;


	/* (non-Javadoc)
	 * @see br.com.gerpro.dao.FacadeCorrecao#procurarPorId(int)
	 */
	public Correcao procurarPorIdProposta(Correcao correcao) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.gerpro.dao.FacadeCorrecao#procurarPorNomeProfessor(java.lang.String)
	 */
	public Correcao procurarPorNomeProfessor(String Nome) {
		
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.com.gerpro.dao.FacadeCorrecao#remover(br.com.gerpro.model.Correcao)
	 */
	public void remover(Correcao correcao) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Correcao> procurarPorIdProposta(int idProposta) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Correcao> procurarPorCorrecao(Correcao correcao) {
		List<Correcao> listaCorrecao = null;;
		
		try {
			session = HibernateUtil.getSession();
			if(session.isOpen()){
				tx = session.beginTransaction();
				
				listaCorrecao = session.createCriteria(Correcao.class)
							.add(Example.create(correcao)).list();

				tx.commit();				
			}
			else
				System.out.println("Erro na sessao");
			
			
			JOptionPane.showMessageDialog(null, "****************************");
			return listaCorrecao;
			
		} catch (Exception e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void salvar(Correcao correcao) {
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(correcao);
			tx.commit();
			JOptionPane.showMessageDialog(null,
					"Alteração Realizada com sucesso",
					"GerPro - Alteração Realizada com Sucesso", 2);
		} catch (HibernateException e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Erro",
					"GerPro - Ocorreu um erro" + e, 1);
			e.printStackTrace();
		} catch (PersistenceException e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Erro",
					"GerPro - Ocorreu um erro" + e, 1);
			e.printStackTrace();
		} catch (Exception e) {
			tx.rollback();
			JOptionPane.showMessageDialog(null, "Erro",
					"GerPro - Ocorreu um erro" + e, 1);
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	public void inserirConjuntoDeCorrecao(int idProposta, String matriculaProfessor){		
		List<Proposta> result = null;
		Session session = HibernateUtil.getSession();
		session.getNamedQuery("inserirConjuntoDeCorrecoes")
			.setInteger("id_proposta", idProposta)
			.setString("matricula_professor", matriculaProfessor)
			.executeUpdate();

		session.close();		
	}
}
