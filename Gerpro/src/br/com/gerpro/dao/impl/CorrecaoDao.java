/**
 * 
 */
package br.com.gerpro.dao.impl;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import br.com.gerpro.dao.FacadeCorrecao;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.CorrecaoId;
import br.com.gerpro.util.HibernateUtil;

/**
 * @author M3R
 *
 */
public class CorrecaoDao implements FacadeCorrecao {
	private static	Session session = null;
	private static Transaction tx = null;

	/* (non-Javadoc)
	 * @see br.com.gerpro.dao.FacadeCorrecao#alterar(br.com.gerpro.model.Correcao)
	 */
	public void alterar(Correcao correcao) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see br.com.gerpro.dao.FacadeCorrecao#inserir(br.com.gerpro.model.Correcao)
	 */
	public void inserir(Correcao correcao) {
		// TODO Auto-generated method stub

	}

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
	

}



