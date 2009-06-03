package br.com.gerpro.processing;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public interface IResultadoProposta {
	
    public BufferedImage gerarGraficoBarraVertical3D(String tituloGrafico, String tituloEixoX, String tituloEixoY, ArrayList arrayValores) throws Exception;
    
    public BufferedImage gerarGraficoBarraVertical(String tituloGrafico, String tituloEixoX, String tituloEixoY, ArrayList arrayValores)throws Exception;
    
    public BufferedImage gerarGraficoLinha(String tituloGrafico, String tituloEixoX,
            String tituloEixoY, ArrayList arrayValores) throws Exception;
    
    public BufferedImage gerarGraficoLinha3D(String tituloGrafico, String

            tituloEixoX, String tituloEixoY, ArrayList arrayValores)throws Exception ;
    
}