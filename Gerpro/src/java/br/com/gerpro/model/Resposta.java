package br.com.gerpro.model;
// Generated 20/02/2009 08:31:23 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Resposta generated by hbm2java
 */
public class Resposta  implements java.io.Serializable {


     private Integer id;
     private String descricao;
     private Set correcaos = new HashSet(0);

    public Resposta() {
    }

    public Resposta(String descricao, Set correcaos) {
       this.descricao = descricao;
       this.correcaos = correcaos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Set getCorrecaos() {
        return this.correcaos;
    }
    
    public void setCorrecaos(Set correcaos) {
        this.correcaos = correcaos;
    }




}


