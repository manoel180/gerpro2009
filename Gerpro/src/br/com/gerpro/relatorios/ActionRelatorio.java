/*
 * ActionReport.java
 *
 * Created on December 7, 2007, 8:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.gerpro.relatorios;

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

import br.com.gerpro.util.HibernateUtil;

/**
 * 
 * @author vista
 */
public class ActionRelatorio {

	private static Session session = null;
	private static Transaction tx = null;
	private ImageIcon logo = new ImageIcon(getClass().getResource(
			"/br/com/gerpro/relatorios/logo.jpg"));

	String path = this.getClass().getResource("/br/com/gerpro/relatorios")
			.getPath();

	/**
	 * <p>
	 * Prefixo do nome do recurso para relat�rios compilados.
	 * </p>
	 */
	private String SUB = path;

	/**
	 * <p>
	 * Sufixo do nome do recurso para relat�rios compilados.
	 * </p>
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
//		return "";
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
