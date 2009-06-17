package br.com.gerpro.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.model.SelectItem;
import javax.imageio.ImageIO;

import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.relatorios.ActionRelatorio;

public class RelatorioBean {
	private UIData objDatatableEquipe;// componente da tela - JSP
	private ActionRelatorio rel = new ActionRelatorio();
	private List<Proposta> listaProposta;
	private BufferedImage imagen = new BufferedImage(400, 400, 1);
	private Proposta proposta = new Proposta();
	private FacadeProposta daoProposta = new PropostaDao();

	// ComboBox Periodos
	public SelectItem[] getPeriodoCombo() {
		List<Proposta> lp = daoProposta.listarPeriodo();
		List<SelectItem> itens = new ArrayList<SelectItem>(lp.size());

		for (Proposta p : lp) {
			itens.add(new SelectItem(p.getPeriodo()));
		}// for end
		return itens.toArray(new SelectItem[itens.size()]);
	}

	public String prepararBean() {

		listaProposta = daoProposta.listarPeriodo();
		imagen = rel.gerarRelatorioResultadosPropostaImage(proposta
				.getPeriodo()).getSubimage(400, 400, 200,200);
		return "go_relatorioResultadoProposta";
	}

	public void paint(OutputStream out, Object data) throws IOException {

		// MediaData paintData = (MediaData) data;
		BufferedImage img = rel.gerarRelatorioResultadosPropostaImage(proposta
				.getPeriodo());
		// Graphics2D graphics2D = img.createGraphics();
		/*
		 * graphics2D.setBackground(paintData.getBackground());
		 * graphics2D.setColor(paintData.getDrawColor());
		 * graphics2D.clearRect(0,0,paintData.getWidth(),paintData.getHeight());
		 * graphics2D.drawLine(5,5,paintData.getWidth()-5,paintData.getHeight()-5);
		 * graphics2D.drawChars(new
		 * String("RichFaces").toCharArray(),0,9,40,15);
		 * graphics2D.drawChars(new
		 * String("mediaOutput").toCharArray(),0,11,5,45);
		 */ImageIO.write(img, "jpeg", out);
	}

	/*
	 * Getters and Setters
	 */

	public UIData getObjDatatableEquipe() {
		return objDatatableEquipe;
	}

	public void setObjDatatableEquipe(UIData objDatatableEquipe) {
		this.objDatatableEquipe = objDatatableEquipe;
	}

	/**
	 * @return the listaProposta
	 */
	public List<Proposta> getListaProposta() {
		return listaProposta;
	}

	/**
	 * @param listaProposta
	 *            the listaProposta to set
	 */
	public void setListaProposta(List<Proposta> listaProposta) {
		this.listaProposta = listaProposta;
	}

	/**
	 * @return the proposta
	 */
	public Proposta getProposta() {
		return proposta;
	}

	/**
	 * @param proposta
	 *            the proposta to set
	 */
	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	/**
	 * @return the imagen
	 */
	public BufferedImage getImagen() {
		return imagen;
	}

	/**
	 * @param imagen
	 *            the imagen to set
	 */
	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}

}
