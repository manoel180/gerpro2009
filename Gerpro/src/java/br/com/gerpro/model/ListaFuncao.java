package br.com.gerpro.model;
// Generated 09/04/2009 07:15:49 by Hibernate Tools 3.2.1.GA



/**
 * ListaFuncao generated by hbm2java
 */
public class ListaFuncao  implements java.io.Serializable {


     private ListaFuncaoId id;
     private PropostaItem propostaItem;
     private TipoFuncao tipoFuncao;
     private String uc;
     private String descricao;

    public ListaFuncao() {
    }

	
    public ListaFuncao(ListaFuncaoId id, PropostaItem propostaItem, TipoFuncao tipoFuncao) {
        this.id = id;
        this.propostaItem = propostaItem;
        this.tipoFuncao = tipoFuncao;
    }
    public ListaFuncao(ListaFuncaoId id, PropostaItem propostaItem, TipoFuncao tipoFuncao, String uc, String descricao) {
       this.id = id;
       this.propostaItem = propostaItem;
       this.tipoFuncao = tipoFuncao;
       this.uc = uc;
       this.descricao = descricao;
    }
   
    public ListaFuncaoId getId() {
        return this.id;
    }
    
    public void setId(ListaFuncaoId id) {
        this.id = id;
    }
    public PropostaItem getPropostaItem() {
        return this.propostaItem;
    }
    
    public void setPropostaItem(PropostaItem propostaItem) {
        this.propostaItem = propostaItem;
    }
    public TipoFuncao getTipoFuncao() {
        return this.tipoFuncao;
    }
    
    public void setTipoFuncao(TipoFuncao tipoFuncao) {
        this.tipoFuncao = tipoFuncao;
    }
    public String getUc() {
        return this.uc;
    }
    
    public void setUc(String uc) {
        this.uc = uc;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }




}


