package br.com.gerpro.processing;

public class VoPropostas {
	
	private int total;
	private String propostas;
	
	/**
	 * @param total
	 * @param propostas
	 */
	public VoPropostas(String propostas, int total) {
		this.total = total;
		this.propostas = propostas;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the propostas
	 */
	public String getPropostas() {
		return propostas;
	}
	/**
	 * @param propostas the propostas to set
	 */
	public void setPropostas(String propostas) {
		this.propostas = propostas;
	}
	
		
}
