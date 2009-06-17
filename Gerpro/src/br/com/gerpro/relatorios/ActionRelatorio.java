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
	 * Prefixo do nome do recurso para relatórios compilados.
	 */
	private String SUB = path;


	/**
	 * 
	 * Sufixo do nome do recurso para relatórios compilados.
	 * 
	 */
	private static final String SUFFIX = ".jasper";

	public void gerarRelatorioProposta(String periodo) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("logo", logo.getImage());
		params.put("periodo", periodo);

		try {
			gerarRelatorioPDF("proposta", params);
		} catch (Exception e) {

			System.err.println(e.getMessage());
		}
	}
		
	public void gerarRelatorioResultadosProposta(String periodo) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		CriarGrafico grafico = new CriarGrafico();
		ArrayList nomes = new ArrayList();
        ArrayList valores = new ArrayList();
        Image imagen = null;

        nomes.addAll(new ListaResultados().preecherNomes());
        valores.addAll(new ListaResultados().preecherValores(periodo));
       
        imagen = grafico.pizza3DStatic(nomes,valores,"Resultados das Propostas").getScaledInstance(600, 800, 0);//.getSubimage(0, 100,300, 150);
        params.put("logo", logo.getImage());
        params.put("imagen", imagen);
		gerarRelatorioPDF("Resultado_Propostas", params);
		
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
