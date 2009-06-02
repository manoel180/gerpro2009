package br.com.gerpro.dao.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

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
	public void alterar(Proposta proposta) {
		// TODO Auto-generated method stub
	
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(proposta);
			tx.commit();
			JOptionPane.showMessageDialog(null, "Alteração Realizada com sucesso", "GerPro - Alteração Realizada com Sucesso", 2);
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
		
	//consulta 3
	//consulta
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
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu algum erro!");
		} finally {
			session.close();
		}
	}
	
	@Override
	public void gerarRelatorio() {
		try {
		//	printPdfUISub();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*session=null;
		tx = null;
		
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
		HashMap map = new HashMap();		

		 FacesContext context = FacesContext.getCurrentInstance();  
		       HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();  
		         
		         
		       ServletContext servletContext = (ServletContext)context.getExternalContext().getContext();  
		
		try {
			URL jasper  = this.getClass().getResource("/br/com/gerpro/relatorios/proposta.jasper");
			 JasperPrint impressao = JasperFillManager.fillReport(jasper.getPath(), map, session.connection());
			byte[] bytes = JasperExportManager.exportReportToPdf(impressao);
			  response.setContentType("application/pdf");  
			          response.setContentLength(bytes.length);  
			            
			          ServletOutputStream ouputStream = response.getOutputStream();  
			          ouputStream.write(bytes, 0, bytes.length);  
			          ouputStream.flush();  
			          ouputStream.close();  
			          response.flushBuffer();
			
			
		//	JasperFillManager.fillReportToFile(jasper.getPath(), map, session.connection());
			
			
			//URL jrprint = this.getClass().getResource("/br/com/gerpro/relatorios/proposta.jrprint");
			//JasperExportManager.exportReportToPdfFile(jrprint.getPath(),(this.getClass().getResource("/br/com/gerpro/relatorios/").toString()));
			//JasperViewer.viewReport(jrprint.getPath(),false, false);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			session.close();
		}*/
		
	}
	
	@Override
	public void printPdfUISub(HttpServletResponse httpResponse)
			throws Exception {

			       /** por spring.... transforme para o que vc quiser
			        SessionHolder sessionHolder = (SessionHolder)
			TransactionSynchronizationManager.getResource(getSessionFactory());

			        if(sessionHolder == null){
			            TransactionSynchronizationManager.bindResource
			(getSessionFactory(),new SessionHolder(getSessionFactory().openSession
			()));
			            sessionHolder = (SessionHolder)
			TransactionSynchronizationManager.getResource(getSessionFactory());
			        }
			        */

			        //retorna a conexao da sessao pelo spring..... vc pode fazer como quiser
			       // Connection conn = sessionHolder.getSession().connection();
			        try {
			        	tx = null;
			    		
			    		session = HibernateUtil.getSession();
			    		tx = session.beginTransaction();
			            //inserindo parametros no subRelatorio para o main
			          //  for(String element : paramSub.keySet()){
			            //    param.put(element, (JasperReport) JRLoader.loadObject((String)(paramSub.get(element))));
			            //}

			            //indincando o path com os arquivos .jasper
			        	HashMap map = new HashMap();		

			            JasperReport report = (JasperReport) JRLoader.loadObject( this.getClass().getResource("/br/com/gerpro/relatorios/proposta.jasper"));
			            JasperPrint printRel = JasperFillManager.fillReport	( report,map, session.connection() );
			            byte[] bytes = JasperExportManager.exportReportToPdf(printRel);

			            //indicando ao cliente que será um pdf, e que terá que	abrir com o programa apropriado.
			            httpResponse.setHeader("Content-Disposition","attachment;filename=\""+ report.getName() + ".pdf" +"\";");
			            httpResponse.setContentLength(bytes.length);
			            httpResponse.setContentType("application/pdf");

			            //envia para o cliente
			            ServletOutputStream ouputStream =	httpResponse.getOutputStream();
			            ouputStream.write(bytes, 0, bytes.length);
			            ouputStream.flush();
			            ouputStream.close();

			        } catch (Exception e) {
			            throw new RuntimeException("Erro ao gerar relatório.",e);
			        }
			    } 
	
	

}