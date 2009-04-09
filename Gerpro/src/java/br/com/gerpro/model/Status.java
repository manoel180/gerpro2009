package br.com.gerpro.model;
// Generated 09/04/2009 07:15:49 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Status generated by hbm2java
 */
public class Status  implements java.io.Serializable {


     private Integer id;
     private String nome;
     private Set propostas = new HashSet(0);
     private Set propostaItems = new HashSet(0);

    public Status() {
    }

	
    public Status(String nome) {
        this.nome = nome;
    }
    public Status(String nome, Set propostas, Set propostaItems) {
       this.nome = nome;
       this.propostas = propostas;
       this.propostaItems = propostaItems;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Set getPropostas() {
        return this.propostas;
    }
    
    public void setPropostas(Set propostas) {
        this.propostas = propostas;
    }
    public Set getPropostaItems() {
        return this.propostaItems;
    }
    
    public void setPropostaItems(Set propostaItems) {
        this.propostaItems = propostaItems;
    }




}


