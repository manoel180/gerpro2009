/**
 * 
 */
package br.com.gerpro.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.dao.FacadeCorrecao;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.CorrecaoId;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.util.HibernateUtil;

/**
 * @author M3R
 * 
 */
public class CorrecaoDao implements FacadeCorrecao {
	private static Session session = null;
	private static Transaction tx = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.FacadeCorrecao#procurarPorId(int)
	 */
	public Correcao procurarPorIdProposta(Correcao correcao) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.FacadeCorrecao#procurarPorNomeProfessor(java.lang.String)
	 */
	public Correcao procurarPorNomeProfessor(String Nome) {

		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.gerpro.dao.FacadeCorrecao#remover(br.com.gerpro.model.Correcao)
	 */
	public void remover(Correcao correcao) {
		// TODO Auto-generated method stub

	}
	
	/***
	 * Método para carregar o item para correcao com base em um parametro
	 * onde se especifica o item selecionado.  
	 */

	@Override
	public Correcao procurarPorIdCorrecao(CorrecaoId idCorrecao) {		

		Correcao result = null;

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		result = (Correcao) session.get(Correcao.class, idCorrecao);

		session.close();
		return result;

		/*
		 * // Funcionando mas duplicando linhas result = session.createQuery(
		 * "from Correcao as c where c.status.id = 3 or proposta.status.id = 4
		 * or proposta.status.id = 5" + " and proposta.periodo = '"+periodo
		 */
		/* + "' Group by proposta.id").list(); */

	}

	@SuppressWarnings("unchecked")
	public List<Correcao> procurarPorCorrecao(Usuario professor,
			Proposta proposta) {
		List<Correcao> listaCorrecao = null;
		;

		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			if (session.isOpen()) {
				tx = session.beginTransaction();

				listaCorrecao = session.createSQLQuery(
						"select * from correcao c" + " where c.id_proposta = ?"
								+ " and c.matricula_professor = ?").addEntity(
						Correcao.class).setParameter(0, proposta.getId())
						.setParameter(1, professor.getMatricula()).list();

				tx.commit();
			} else
				System.out.println("Erro na sessao");

			return listaCorrecao;

		} catch (Exception e) {
			tx.rollback();
			System.out.println("Ocorreu um erro");
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
			System.out.println("Alteração realizada com sucesso");
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
}
