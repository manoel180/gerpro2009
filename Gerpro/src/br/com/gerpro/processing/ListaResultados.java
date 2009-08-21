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
public class ListaResultados implements IListaResultados {
	
	private float count = 0;
	private float total = 0;
	
	//  conteudo do relatorio
	 private List listapropostas = new ArrayList();
	 private List listavalores = new ArrayList();
	 // private VoPropostas voProposta;
	 
	 private FacadeProposta propostaDao = new PropostaDao();

	 /* 
	  * Adicionar os valores das consultas realizadas
	  */
	 
	 /* (non-Javadoc)
	 * @see br.com.gerpro.processing.IListaResultados#preecherNomes()
	 */
	public List preecherNomes(){
		 listapropostas=new ArrayList();
		 listapropostas.add("Aprovados");//,preecherListaAprovados()));
		 listapropostas.add("Aprovados com ressalva");//,preecherListaAprovadosRessalva()));
		 listapropostas.add("Reprovados");//,preecherListaReprovados()));
		 
		 return listapropostas;
	 }
	 /* (non-Javadoc)
	 * @see br.com.gerpro.processing.IListaResultados#preecherValores()
	 */
	public List preecherValores(String periodo){
		 listavalores=new ArrayList();
		 listavalores.add(preecherListaAprovados(periodo));
		 listavalores.add(preecherListaAprovadosRessalva(periodo));
		 listavalores.add(preecherListaReprovados(periodo));
		 
		 return listavalores;
	 }
	 
	 //Verificar a lista de aprovados
	private float preecherListaAprovados(String periodo){
		propostaDao = new PropostaDao();
		 count = 0;
		 List<Proposta> lp = propostaDao.listarPorPeriodo(periodo);
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
	 
	//Verificar as propostas reprovadas no periodo
	 private float preecherListaReprovados(String periodo){
		 propostaDao = new PropostaDao();
		 count = 0;
		 total = 0 ;
		 List<Proposta> lp = propostaDao.listarPorPeriodo(periodo);
		 int tmp = lp.size();
			for( Proposta p : lp ){
				if(p.getStatus().getId()==5){
					count++;
				}
			}
			
			total = (count/tmp)*100;			
			return total;
	 }
	
	//Verificar as propostas reprovadas com ressalva no periodo
	private float preecherListaAprovadosRessalva(String periodo){
		propostaDao = new PropostaDao(); 
		count = 0;
		 total = 0;
		 List<Proposta> lp = propostaDao.listarPorPeriodo(periodo);
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
//	public VoPropostas getVoProposta() {
//		return voProposta;
//	}
//
//
//	/**
//	 * @param voProposta the voProposta to set
//	 */
//	public void setVoProposta(VoPropostas voProposta) {
//		this.voProposta = voProposta;
//	}


}
