/**
 * 
 */
package br.com.gerpro.processing;

import java.util.ArrayList;
import java.util.List;

import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.model.Proposta;

/**
 * @author manoel.neto
 *
 */
public class ListaResultados {
	
	private float count = 0;
	private float total = 0;
	
	//  conteudo do relatorio
	 private List listapropostas = new ArrayList();
	 private List listavalores = new ArrayList();
	 private VoPropostas voProposta;
	 
	 
	 private FacadeProposta propostaDao = new PropostaDao();

	 /* 
	  * Adicionar os valores das consultas realizadas
	  */
	 
	 public List preecherNomes(){
		 listapropostas.add("Aprovados");//,preecherListaAprovados()));
		 listapropostas.add("Aprovados com ressalva");//,preecherListaAprovadosRessalva()));
		 listapropostas.add("Reprovados");//,preecherListaReprovados()));
		 
		 return listapropostas;
	 }
	 public List preecherValores(){
		 listapropostas.add(preecherListaAprovados());
		 listapropostas.add(preecherListaAprovadosRessalva());
		 listapropostas.add(preecherListaReprovados());
		 
		 return listapropostas;
	 }
	 
	private float preecherListaAprovados(){
		 count = 0;
		 List<Proposta> lp = getPropostaDao().listar();
		 int tmp = lp.size();
		total =0;
			for( Proposta p : lp ){
				if(p.getStatus().getId() ==3){
					count++;
				}
			}
			total = (count/tmp)*100;
			return total;
	 }
	 
	 private float preecherListaReprovados(){
		 count = 0;
		 total = 0;
		 List<Proposta> lp = getPropostaDao().listar();
		 int tmp = lp.size();
			for( Proposta p : lp ){
				if(p.getStatus().getId()==5){
					count++;
				}
			}
			total = (count/tmp)*100;
			return total;
	 }
	 
	private float preecherListaAprovadosRessalva(){
		 count = 0;
		 total = 0;
		 List<Proposta> lp = getPropostaDao().listar();
		 int tmp = lp.size();
			for( Proposta p : lp ){
				if(p.getStatus().getId()==4){
					count++;
				}
			}
			total = (count/tmp)*100;
			return total;
	 }
	
	/**
	 * @return the propostaDao
	 */
	public FacadeProposta getPropostaDao() {
		return propostaDao;
	}


	/**
	 * @param propostaDao the propostaDao to set
	 */
	public void setPropostaDao(FacadeProposta propostaDao) {
		this.propostaDao = propostaDao;
	}


	/**
	 * @return the listapropostas
	 */
	public List getListapropostas() {
		return listapropostas;
	}


	/**
	 * @param listapropostas the listapropostas to set
	 */
	public void setListapropostas(List listapropostas) {
		this.listapropostas = listapropostas;
	}


	/**
	 * @return the voProposta
	 */
	public VoPropostas getVoProposta() {
		return voProposta;
	}


	/**
	 * @param voProposta the voProposta to set
	 */
	public void setVoProposta(VoPropostas voProposta) {
		this.voProposta = voProposta;
	}


}
