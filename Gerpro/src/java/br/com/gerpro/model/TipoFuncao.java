package br.com.gerpro.model;
// Generated 09/04/2009 07:15:49 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * TipoFuncao generated by hbm2java
 */
public class TipoFuncao  implements java.io.Serializable {


     private byte id;
     private String nome;
     private char abreviatura;
     private Set listaFuncaos = new HashSet(0);

    public TipoFuncao() {
    }

	
    public TipoFuncao(byte id, String nome, char abreviatura) {
        this.id = id;
        this.nome = nome;
        this.abreviatura = abreviatura;
    }
    public TipoFuncao(byte id, String nome, char abreviatura, Set listaFuncaos) {
       this.id = id;
       this.nome = nome;
       this.abreviatura = abreviatura;
       this.listaFuncaos = listaFuncaos;
    }
   
    public byte getId() {
        return this.id;
    }
    
    public void setId(byte id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public char getAbreviatura() {
        return this.abreviatura;
    }
    
    public void setAbreviatura(char abreviatura) {
        this.abreviatura = abreviatura;
    }
    public Set getListaFuncaos() {
        return this.listaFuncaos;
    }
    
    public void setListaFuncaos(Set listaFuncaos) {
        this.listaFuncaos = listaFuncaos;
    }




}


