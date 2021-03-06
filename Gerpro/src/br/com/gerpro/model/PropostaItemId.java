package br.com.gerpro.model;

// Generated 31/05/2009 15:44:42 by Hibernate Tools 3.2.2.GA

/**
 * PropostaItemId generated by hbm2java
 */
public class PropostaItemId implements java.io.Serializable {

	private int idProposta;
	private int idItem;

	public PropostaItemId() {
	}

	public PropostaItemId(int idProposta, int idItem) {
		this.idProposta = idProposta;
		this.idItem = idItem;
	}

	public int getIdProposta() {
		return this.idProposta;
	}

	public void setIdProposta(int idProposta) {
		this.idProposta = idProposta;
	}

	public int getIdItem() {
		return this.idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PropostaItemId))
			return false;
		PropostaItemId castOther = (PropostaItemId) other;

		return (this.getIdProposta() == castOther.getIdProposta())
				&& (this.getIdItem() == castOther.getIdItem());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdProposta();
		result = 37 * result + this.getIdItem();
		return result;
	}

}
