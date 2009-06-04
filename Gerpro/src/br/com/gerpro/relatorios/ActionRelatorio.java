/*
 * ActionReport.java
 *
 * Created on December 7, 2007, 8:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.gerpro.relatorios;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.StateManager;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import net.sf.jasperreports.engine.JasperRunManager;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.processing.CriarGrafico;
import br.com.gerpro.processing.ListaResultados;
import br.com.gerpro.util.HibernateUtil;

/**
 * 
 * @author M3R
 */
public class ActionRelatorio {

	private static Session session = null;
	private static Transaction tx = null;
	private ImageIcon logo = new ImageIcon(getClass().getResource(
			"/br/com/gerpro/relatorios/logo.jpg"));

	String path = this.getClass().getResource("/br/com/gerpro/relatorios")
			.getPath();

	/** 
	 * Prefixo do nome do recurso para relat�rios compilados.
	 */
	private String SUB = path;

	/**
	 * 
	 * Sufixo do nome do recurso para relat�rios compilados.
	 * 
	 */
	private static final String SUFFIX = ".jasper";

	public void gerarRelatorioProposta() {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("logo", logo.getImage());
		/*
		 * params.put("data_inicio",getDt_inicial());
		 * params.put("data_fim",getDt_final());
		 */

		try {
			gerarRelatorioPDF("proposta", params);
		} catch (Exception e) {

			System.err.println(e.getMessage());
		}
	}
	
	
	public void gerarRelatorioResultadosProposta() {
		
		Map<String, Object> params = new HashMap<String, Object>();
		CriarGrafico Grafico = new CriarGrafico();
		ArrayList nomes = new ArrayList();
        ArrayList valores = new ArrayList();
        Image imagen;
	/*	
		JPanel painel = new JPanel();
        JFrame frame = new JFrame();
        ScrollPane scroll = new ScrollPane(1);
      */  
        nomes.addAll(new ListaResultados().preecherNomes());
        valores.addAll(new ListaResultados().preecherValores());
       
        imagen = CriarGrafico.pizza3DStatic(nomes,valores,"Título do Gráfico").getScaledInstance(400, 600, 0);//.getSubimage(0, 100,300, 150);
        params.put("logo", logo.getImage());
        params.put("imagen", imagen);
		gerarRelatorioPDF("Resultado_Propostas", params);
		
        /*painel.add();
        scroll.add(painel);
	frame.getContentPane().add(scroll);
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	frame.setTitle("Título Geral");
	frame.setPreferredSize(new Dimension(750, 520));
	frame.pack();
	frame.setVisible(true);*/
	}

	private void gerarRelatorioPDF(String nome, Map params) {

		session = HibernateUtil.getSession();
		tx = session.beginTransaction();

		try {

			byte[] pdf = JasperRunManager.runReportToPdf(SUB + nome + SUFFIX,
					params, session.connection());

			FacesContext faces = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) faces
					.getExternalContext().getResponse();
			response.setContentType("application/pdf");
			response.setContentLength(pdf.length);
			response.setHeader("Content-disposition", "inline");

			response.setHeader("Cache-Control", "cache, must-revalidate");
			response.setHeader("Pragma", "public");
			ServletOutputStream out = response.getOutputStream();

			out.write(pdf);
			StateManager stateManager = (StateManager) faces.getApplication()
					.getStateManager();
			stateManager.saveSerializedView(faces);
			faces.responseComplete();
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new FacesException(e);
		} finally {
			session.close();
		}

	}

}
