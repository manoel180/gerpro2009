package br.com.gerpro.action;

import javax.faces.component.UIOutput;


public class ErroBean {	
	
	private String tituloMensagemErro;
	private String mensagemErro;
	
	
	public String prepararBean(String mensagemErro2) {		
		this.mensagemErro = "ERROOOOOOOOOOOOOOOOOOOOOOOOOOOOO";//mensagemErro2;	
		this.tituloMensagemErro = "Teste de Erro";
		
		System.out.println(mensagemErro + " ***** " + tituloMensagemErro);
		
		
		return "erro";
	}
	
	/*
	 * Getters and Setters
	 */
	
	/**
	 * @return the mensagemErro
	 */
	public String getMensagemErro() {
		return mensagemErro;
	}

	/**
	 * @param mensagemErro the mensagemErro to set
	 */
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	/**
	 * @return the tituloMensagemErro
	 */
	public String getTituloMensagemErro() {
		return tituloMensagemErro;
	}

	/**
	 * @param tituloMensagemErro the tituloMensagemErro to set
	 */
	public void setTituloMensagemErro(String tituloMensagemErro) {
		this.tituloMensagemErro = tituloMensagemErro;
	}
	
	
	
	
	


}
