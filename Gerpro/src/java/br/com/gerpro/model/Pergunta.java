package br.com.gerpro.model;
// Generated 14/04/2009 09:24:04 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Pergunta generated by hbm2java
 */
public class Pergunta  implements java.io.Serializable {


     private Integer id;
     private Item item;
     private String descricao;
     private Set correcaos = new HashSet(0);

    public Pergunta() {
    }

    public Pergunta(Item item, String descricao, Set correcaos) {
       this.item = item;
       this.descricao = descricao;
       this.correcaos = correcaos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Item getItem() {
        return this.item;
    }
    
    public void setItem(Item item) {
        this.item = item;
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


