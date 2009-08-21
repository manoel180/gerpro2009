package br.com.gerpro.processing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;


/**
 * @author M3R
 *
 */

/**
 * Esta classe tem como objetivo implementar um gráfico com a % com o resultado
 * de várias cruzamentos de informação tais como :
 * 
 * Quantidade de Propostas Entregue ----------------------- Aprovadas
 * ----------------------- Aprovadas com Ressalva -----------------------
 * Reprovadas
 * 
 */

public class CriarGrafico implements ICriarGrafico {

	/**
	 * 
	 * Gera um gráfico de barras 3D Vertical
	 * 
	 * @param tituloGrafico
	 *            String, o titulo do gráfico
	 * 
	 * @param tituloEixoX
	 *            String, o titulo do eixo X
	 * 
	 * @param tituloEixoY
	 *            String, o titulo do eixo Y
	 * 
	 * @param arrayValores
	 *            ArrayList, a lista com os valores para o gráfico
	 * 
	 * @return BufferedImage, a imagem do Gráfico gerada
	 * 
	 * 
	 * 
	 * A classe DefaultCategoryDataset recebe os valores que irão gerar o
	 * gráfico
	 * 
	 * DefaultCategoryDataset.addValue(Number, Comparable, Comparable)
	 * 
	 * DefaultCategoryDataset.addValue(Double, Comparable, Comparable)
	 * 
	 */

/*	public BufferedImage gerarGraficoBarraVertical3D(String tituloGrafico,
			String tituloEixoX, String tituloEixoY, ArrayList arrayValores)
			throws Exception {

		BufferedImage buf = null;

		try {

			DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();

			Iterator iterator = arrayValores.iterator();

			while (iterator.hasNext()) {

			//	VoPropostas modelo = (VoPropostas) iterator.next();

				defaultCategoryDataset.addValue(modelo.getTotal(), modelo
						.getPropostas(), modelo.getPropostas().substring(0, 3));

			}

			JFreeChart chart = ChartFactory.createBarChart3D(tituloGrafico,
					tituloEixoX, tituloEixoY, defaultCategoryDataset,
					PlotOrientation.VERTICAL, true, false, false);

			chart.setBorderVisible(true);

			chart.setBorderPaint(Color.black);

			buf = chart.createBufferedImage(400, 250);

		} catch (Exception e) {

			throw new Exception(e);

		}

		return buf;

	}*/

	/**
	 * 
	 * Gera um gráfico de barras Vertical
	 * 
	 */

/*	public BufferedImage gerarGraficoBarraVertical(String tituloGrafico, String

	tituloEixoX, String tituloEixoY, ArrayList arrayValores) throws Exception {

		BufferedImage buf = null;

		try {

			DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();

			Iterator iterator = arrayValores.iterator();

			while (iterator.hasNext()) {

				VoPropostas modelo = (VoPropostas) iterator.next();

				defaultCategoryDataset.addValue(modelo.getTotal(),

				modelo.getPropostas(), modelo.getPropostas().substring(0, 3)); // verificar
				// o pq
				// do
				// substring

			}

			JFreeChart chart = ChartFactory.createBarChart(tituloGrafico,
					tituloEixoX,

					tituloEixoY, defaultCategoryDataset,
					PlotOrientation.VERTICAL, true, false, false);

			chart.setBorderVisible(true);

			chart.setBorderPaint(Color.black);

			buf = chart.createBufferedImage(400, 250);

		} catch (Exception e) {

			throw new Exception(e);

		}

		return buf;

	}*/

	/**
	 * 
	 * Gera um Grafico de Linhas
	 * 
	 */
/*
	public BufferedImage gerarGraficoLinha(String tituloGrafico,
			String tituloEixoX, String tituloEixoY, ArrayList arrayValores)
			throws Exception {

		BufferedImage buf = null;

		try {

			DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();

			Iterator iterator = arrayValores.iterator();

			while (iterator.hasNext()) {

				VoPropostas modelo = (VoPropostas) iterator.next();

				defaultCategoryDataset.addValue(modelo.getTotal(),

				modelo.getPropostas(), modelo.getPropostas().substring(0, 3)); // verificar
				// o pq
				// do
				// substring

			}

			JFreeChart chart = ChartFactory.createLineChart(tituloGrafico,
					tituloEixoX,

					tituloEixoY, defaultCategoryDataset,
					PlotOrientation.VERTICAL,

					true, false, false);

			chart.setBorderVisible(true);

			chart.setBorderPaint(Color.black);

			buf = chart.createBufferedImage(400, 250);

		} catch (Exception e) {

			throw new Exception(e);

		}

		return buf;

	}*/

	/**
	 * 
	 * Gera um grafico de linhas 3D
	 * 
	 */

/*	public BufferedImage gerarGraficoLinha3D(String tituloGrafico,
			String tituloEixoX, String tituloEixoY, ArrayList arrayValores)
			throws Exception {

		BufferedImage buf = null;

		try {

			DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();

			Iterator iterator = arrayValores.iterator();

			while (iterator.hasNext()) {

				VoPropostas modelo = (VoPropostas) iterator.next();

				defaultCategoryDataset.addValue(modelo.getTotal(), null, modelo
						.getPropostas().substring(0, 2)); // substring(0,
				// 3)verificar o pq
				// do substring

			}

			JFreeChart chart = ChartFactory.createLineChart3D(tituloGrafico,
					tituloEixoX, tituloEixoY, defaultCategoryDataset,
					PlotOrientation.VERTICAL, true, false, false);

			chart.setBorderVisible(true);

			chart.setBorderPaint(Color.black);

			buf = chart.createBufferedImage(400, 250);

		} catch (Exception e) {

			throw new Exception(e);
		}

		return buf;

	}*/

	/**
	 * 
	 * Gera um grafico de pizza 3D
	 * 
	 */
	//Método que gera a Imagem do Relatório
	private BufferedImage pizza3D(ArrayList nome, ArrayList valor,
			String tituloGrafico, float transparencia, String tipo) {
		BufferedImage buf = null;
		DefaultPieDataset data = new DefaultPieDataset();
		DecimalFormat digitos = new DecimalFormat("00.00");
		
		//Faz a formatação de exibição dos parametro do relatorio
		for (int i = 0; i < nome.toArray().length; i++) {

			data.setValue(digitos.format(valor.get(i)) + "% \n"
					+ nome.get(i).toString(), new Double(valor.get(i)
					.toString()));

		}

		//
		JFreeChart chart = ChartFactory.createPieChart3D(tituloGrafico, data,
				true, false, true);

		java.awt.Color cor = new java.awt.Color(255, 255, 255);
		chart.setBackgroundPaint(cor);

		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setLabelLinksVisible(true);

		plot
				.setNoDataMessage("Não existem dados para serem exibidos no gráfico");

		plot.setStartAngle(90);
		plot.setDirection(Rotation.CLOCKWISE);

		plot.setForegroundAlpha(transparencia);
		plot.setInteriorGap(0.10);

		buf = chart.createBufferedImage(600, 400);
		return buf;
	}

	public BufferedImage pizza3DStatic( ArrayList nome, ArrayList valor,
			String tituloGrafico) {
		return pizza3D(nome, valor, tituloGrafico, 1f, "Dynamic");// Static
	}
}
