package br.com.gerpro.model;
// Generated 20/02/2009 08:31:23 by Hibernate Tools 3.2.1.GA



/**
 * CronogramaId generated by hbm2java
 */
public class CronogramaId  implements java.io.Serializable {


     private int idProposta;
     private int idItem;
     private int numeroSequencia;

    public CronogramaId() {
    }

    public CronogramaId(int idProposta, int idItem, int numeroSequencia) {
       this.idProposta = idProposta;
       this.idItem = idItem;
       this.numeroSequencia = numeroSequencia;
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
    public int getNumeroSequencia() {
        return this.numeroSequencia;
    }
    
    public void setNumeroSequencia(int numeroSequencia) {
        this.numeroSequencia = numeroSequencia;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CronogramaId) ) return false;
		 CronogramaId castOther = ( CronogramaId ) other; 
         
		 return (this.getIdProposta()==castOther.getIdProposta())
 && (this.getIdItem()==castOther.getIdItem())
 && (this.getNumeroSequencia()==castOther.getNumeroSequencia());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdProposta();
         result = 37 * result + this.getIdItem();
         result = 37 * result + this.getNumeroSequencia();
         return result;
   }   


}


