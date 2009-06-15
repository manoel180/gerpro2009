package br.com.gerpro.action;

import javax.faces.component.UIOutput;


public class ErroBean {
	//private UIData objDatatableErro;// componente da tela - JSP
	private UIOutput objOutputErro;// componente da tela - JSP
	
	private String mensagemErro;
	
	public String prepararBean(String mensagemErro2) {		
		mensagemErro=mensagemErro2;	
		return "erro";
	}
	

	/**
	 * @return the objOutputErro
	 */
	public UIOutput getObjOutputErro() {
		return objOutputErro;
	}

	/**
	 * @param objOutputErro the objOutputErro to set
	 */
	public void setObjOutputErro(UIOutput objOutputErro) {
		this.objOutputErro = objOutputErro;
	}
	
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
	
	/*
	 * Getters and Setters
	 */
	


}
