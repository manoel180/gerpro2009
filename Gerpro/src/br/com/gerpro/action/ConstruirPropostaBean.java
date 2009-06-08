package br.com.gerpro.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.model.SelectItem;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import br.com.gerpro.dao.FacadeArtefatos;
import br.com.gerpro.dao.FacadeCronograma;
import br.com.gerpro.dao.FacadeEquipe;
import br.com.gerpro.dao.FacadeListaFuncao;
import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.FacadePropostaItem;
import br.com.gerpro.dao.FacadeTipoFuncao;
import br.com.gerpro.dao.impl.ArtefatosDao;
import br.com.gerpro.dao.impl.CronogramaDao;
import br.com.gerpro.dao.impl.EquipeDao;
import br.com.gerpro.dao.impl.ListaFuncaoDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.dao.impl.PropostaItemDao;
import br.com.gerpro.dao.impl.TipoFuncaoDao;
import br.com.gerpro.model.Artefatos;
import br.com.gerpro.model.Cronograma;
import br.com.gerpro.model.CronogramaId;
import br.com.gerpro.model.Equipe;
import br.com.gerpro.model.ListaFuncao;
import br.com.gerpro.model.ListaFuncaoId;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.PropostaItem;
import br.com.gerpro.model.PropostaItemId;
import br.com.gerpro.model.Status;
import br.com.gerpro.model.TipoFuncao;
import br.com.gerpro.util.ApplicationSecurityManager;

public class ConstruirPropostaBean {
	private UIData objDatatableListaFuncao;// componente da tela - JSP
	private UIData objDatatableCronograma;
	private List<Equipe> listaEquipe;
	private List<ListaFuncao> lstlistaFuncao = new ArrayList<ListaFuncao>();
	private List<ListaFuncao> lstlistaFuncaoDel = new ArrayList<ListaFuncao>();
	private List<Cronograma> lstCronograma = new ArrayList<Cronograma>();
	private List<Artefatos> lstArtefatos = new ArrayList<Artefatos>();

	private ListaFuncao listaFuncao = new ListaFuncao();
	private Artefatos artefatos = new Artefatos();
	private Equipe equipe = new Equipe();
	private Cronograma cronograma = new Cronograma();
	private CronogramaId cronogramaId = new CronogramaId();
	private Proposta proposta = new Proposta();
	private PropostaItemId PropItemId = new PropostaItemId();
	private PropostaItem propostaItem = new PropostaItem();
	private Status status = new Status();
	private TipoFuncao tipofuncao = new TipoFuncao();
	private ListaFuncaoId listafuncaoid = new ListaFuncaoId();

	private FacadeEquipe daoEquipe = new EquipeDao();
	private FacadeArtefatos daoArtefatos = new ArtefatosDao();
	private FacadeProposta daoProposta = new PropostaDao();
	private FacadePropostaItem daoPropItem = new PropostaItemDao();
	private FacadeTipoFuncao daoTipoFuncao = new TipoFuncaoDao();
	private FacadeListaFuncao daoListaFuncao = new ListaFuncaoDao();
	private FacadeCronograma daoCronograma = new CronogramaDao();

	// ComboBox Tipo de Funçoes
	public SelectItem[] getTipoFuncaoCombo() {
		List<TipoFuncao> ltf = getDaoTipoFuncao().listar();
		List<SelectItem> itens = new ArrayList<SelectItem>(ltf.size());

		for (TipoFuncao tf : ltf) {
			itens.add(new SelectItem(tf.getId(), tf.getNome()));
		}// for end
		return itens.toArray(new SelectItem[itens.size()]);
	}

	// ComboBox Artefatos
	public SelectItem[] getArtefatosCombo() {
		List<Artefatos> lart = getDaoArtefatos().listar();
		List<SelectItem> itens = new ArrayList<SelectItem>(lart.size());

		for (Artefatos art : lart) {
			itens.add(new SelectItem(art.getId(), art.getNome()));
		}// for end
		return itens.toArray(new SelectItem[itens.size()]);
	}

	// Adiciona uma função na tabela de lista de funções
	public void addfuncao() {

		if (lstlistaFuncao.indexOf(listaFuncao) == -1) {
			if (tipofuncao.getId() == 1) {
				tipofuncao.setNome("Manter");
			}
			if (tipofuncao.getId() == 2) {
				tipofuncao.setNome("Processamento");
			}
			if (tipofuncao.getId() == 3) {
				tipofuncao.setNome("Relatório");
			}
			listafuncaoid.setIdItem(2);
			listafuncaoid.setIdProposta(1);

			listaFuncao.setId(listafuncaoid);
			listaFuncao.setTipoFuncao(tipofuncao);

			lstlistaFuncao.add(listaFuncao);
			listafuncaoid = new ListaFuncaoId();
			listaFuncao = new ListaFuncao();
			tipofuncao = new TipoFuncao();
		} else {
			if (tipofuncao.getId() == 1) {
				tipofuncao.setNome("Manter");
			}
			if (tipofuncao.getId() == 2) {
				tipofuncao.setNome("Processamento");
			}
			if (tipofuncao.getId() == 3) {
				tipofuncao.setNome("Relatório");
			}
			listafuncaoid.setIdItem(2);
			listafuncaoid.setIdProposta(1);

			listaFuncao.setId(listafuncaoid);
			listaFuncao.setTipoFuncao(tipofuncao);

			lstlistaFuncao
					.set(lstlistaFuncao.indexOf(listaFuncao), listaFuncao);
			listafuncaoid = new ListaFuncaoId();
			listaFuncao = new ListaFuncao();
			tipofuncao = new TipoFuncao();
		}
	}

	// Remover uma função da tabela de lista de funções
	public void delfuncao() {
		int id = objDatatableListaFuncao.getRowIndex();
		listaFuncao = (ListaFuncao) objDatatableListaFuncao.getRowData();
		lstlistaFuncaoDel.add(listaFuncao);
		lstlistaFuncao.remove(id);
		listaFuncao = new ListaFuncao();
	}

	// Seleciona uma função da tabela de lista de funções para a alteracao
	public void editfuncao() {

		listaFuncao = (ListaFuncao) objDatatableListaFuncao.getRowData();
		listafuncaoid = listaFuncao.getId();
		tipofuncao = listaFuncao.getTipoFuncao();
	}

	/**
	 * Adiciona uma função na tabela de lista de Cronograma
	 */

	@SuppressWarnings("deprecation")
	public void addCronograma() {
		lstArtefatos = getDaoArtefatos().listar();
		//Verifica se ja existe o item na lista
		if (lstCronograma.indexOf(cronograma) == -1) {
			
			//Adiciona um novo item na lsita de cronogramas
			for (Artefatos artefato : lstArtefatos) {
				if (artefatos.getId().equals(artefato.getId())) {
					artefatos.setNome(artefato.getNome());
				}
			}

			java.util.Calendar endDate = GregorianCalendar.getInstance();
			endDate.setTime((Date) cronograma.getDataInicial());
			java.util.Calendar startDate = GregorianCalendar.getInstance();
			startDate.add(java.util.Calendar.DATE, -1);

			//Verifica se a data de inicio é maior que data final
			if ((cronograma.getDataInicial().compareTo(
					cronograma.getDataFinal()) == 1)
					|| (startDate.after(endDate)))

			{
				JOptionPane.showMessageDialog(null,
						"Data Inicial maior que a data final");
			} else {
				//Adiciona um cronograma a lista
				cronogramaId.setIdItem(5);
				cronogramaId.setIdProposta(1);

				cronograma.setId(cronogramaId);

				cronograma.setArtefatos(artefatos);
				lstCronograma.add(cronograma);
				cronogramaId = new CronogramaId();
				cronograma = new Cronograma();
				artefatos = new Artefatos();
			}

		} 
		//Altera o cronograma da lista
		else {
			
			for (Artefatos artefato : lstArtefatos) {
				if (artefatos.getId().equals(artefato.getId())) {
					artefatos.setNome(artefato.getNome());
				}
			}

			java.util.Calendar endDate = GregorianCalendar.getInstance();
			endDate.setTime((Date) cronograma.getDataInicial());
			java.util.Calendar startDate = GregorianCalendar.getInstance();
			startDate.add(java.util.Calendar.DATE, -1);

			//Verifica se a data de inicio é maior que data final
			if ((cronograma.getDataInicial().compareTo(
					cronograma.getDataFinal()) == 1)
					|| (startDate.after(endDate)))

			{
				JOptionPane.showMessageDialog(null,
						"Data Inicial maior que a data final");
			} else {
				cronogramaId.setIdItem(5);
				cronogramaId.setIdProposta(1);

				cronograma.setId(cronogramaId);

				cronograma.setArtefatos(artefatos);
				lstCronograma.set(lstCronograma.indexOf(cronograma),cronograma);
				cronogramaId = new CronogramaId();
				cronograma = new Cronograma();
				artefatos = new Artefatos();

			}
		}
	}

	// Remover uma função da tabela de lista de funções
	public void delCronograma() {
		int id = objDatatableCronograma.getRowIndex();
		lstCronograma.remove(id);
	}

	// Seleciona uma função da tabela de lista de funções para a alteracao
	public void editCronograma() {

		cronograma = (Cronograma) objDatatableCronograma.getRowData();
		cronogramaId = cronograma.getId();
		artefatos = cronograma.getArtefatos();
	}

	public String prepararBean() {

		proposta = getDaoProposta().procurarPorId(
				Integer.parseInt(ApplicationSecurityManager.PROPOSTA));
		equipe = proposta.getEquipe();

		return "go_ConstruirProposta";
	}

	/*
	 * Metodos para Missão proposta
	 */
	public String prepararMissao() {

		proposta = getDaoProposta().procurarPorId(
				Integer.parseInt(ApplicationSecurityManager.PROPOSTA));
		equipe = proposta.getEquipe();
		PropItemId.setIdItem(1);
		PropItemId.setIdProposta(proposta.getId());
		propostaItem = (PropostaItem) getDaoPropItem().procurarPorProposta(
				PropItemId);

		return "construirMissao";
	}

	// Salvar a missao da proposta
	public String SalvarMissao() {

		equipe = proposta.getEquipe();

		try {
			// Setando o Id composto do Proposta Item
			PropItemId.setIdItem(1);
			PropItemId.setIdProposta(proposta.getId());
			status.setId(1);
			propostaItem.setStatus(status);
			propostaItem.setId(PropItemId);
			getDaoPropItem().salvar(propostaItem);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prepararBean();
	}

	// falta verificar
	public String AlterarMissao() {

		equipe = proposta.getEquipe();

		try {
			// Setando o Id composto do Proposta Item
			PropItemId.setIdItem(1);
			status.setId(2);
			PropItemId.setIdProposta(1);
			propostaItem.setId(PropItemId);
			propostaItem.setStatus(status);
			getDaoPropItem().salvar(propostaItem);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prepararBean();
	}

	public String prepararListaFuncao() {
		proposta = getDaoProposta().procurarPorId(
				Integer.parseInt(ApplicationSecurityManager.PROPOSTA));
		equipe = proposta.getEquipe();
		PropItemId.setIdItem(2);
		PropItemId.setIdProposta(proposta.getId());
		propostaItem = (PropostaItem) getDaoPropItem().procurarPorProposta(
				PropItemId);
		listafuncaoid.setIdItem(2);
		listafuncaoid.setIdProposta(proposta.getId());
		lstlistaFuncao = getDaoListaFuncao().procurarPorId(listafuncaoid.getIdProposta(),listafuncaoid.getIdItem());
		return "construirListaFuncoes";
	}

	// Percorrre a lstlistafuncao pra salvar a as listas de funcoes da proposta
	public String SalvarListaFuncao() {

		equipe = proposta.getEquipe();

		try {
			// Setando o Id composto do Proposta Item
			PropItemId.setIdItem(2);
			PropItemId.setIdProposta(proposta.getId());
			status.setId(1);

			for (ListaFuncao lf : lstlistaFuncao) {
				getDaoListaFuncao().salvar(lf);
			}
			if(lstlistaFuncaoDel!=null){
				for (ListaFuncao lf : lstlistaFuncaoDel) {
					getDaoListaFuncao().remover(lf);
				}
					
			}


		} catch (PersistenceException e) {

			e.printStackTrace();
		}
		return prepararBean();
	}

	/*
	 * Metodos para Justificativa da proposta
	 */
	public String prepararJustificativa() {
		proposta = getDaoProposta().procurarPorId(
				Integer.parseInt(ApplicationSecurityManager.PROPOSTA));
		equipe = proposta.getEquipe();
		PropItemId.setIdItem(3);
		PropItemId.setIdProposta(proposta.getId());
		propostaItem = (PropostaItem) getDaoPropItem().procurarPorProposta(
				PropItemId);
		return "construirJustificativa";
	}

	// OK
	public String SalvarJustificativa() {

		equipe = proposta.getEquipe();

		try {

			// Setando o Id composto do Proposta Item
			PropItemId.setIdItem(3);
			PropItemId.setIdProposta(proposta.getId());
			status.setId(1);
			propostaItem.setStatus(status);
			propostaItem.setId(PropItemId);
			getDaoPropItem().salvar(propostaItem);

		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prepararBean();
	}

	//OK
	public String prepararMetodologia() {
		proposta = getDaoProposta().procurarPorId(
				Integer.parseInt(ApplicationSecurityManager.PROPOSTA));
		equipe = proposta.getEquipe();
		PropItemId.setIdItem(4);
		PropItemId.setIdProposta(proposta.getId());
		propostaItem = (PropostaItem) getDaoPropItem().procurarPorProposta(
				PropItemId);

		return "construirMetodologia";
	}

	//OK
	public String SalvarMetodologia() {

		equipe = proposta.getEquipe();

		try {
			// Setando o Id composto do Proposta Item
			PropItemId.setIdItem(4);
			PropItemId.setIdProposta(proposta.getId());
			status.setId(1);
			propostaItem.setStatus(status);
			propostaItem.setId(PropItemId);
			getDaoPropItem().salvar(propostaItem);

		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prepararBean();
	}

	//OK
	public String prepararCronograma() {
		proposta = getDaoProposta().procurarPorId(
				Integer.parseInt(ApplicationSecurityManager.PROPOSTA));
		equipe = proposta.getEquipe();
		PropItemId.setIdItem(5);
		PropItemId.setIdProposta(proposta.getId());
		propostaItem = (PropostaItem) getDaoPropItem().procurarPorProposta(
				PropItemId);
		cronogramaId.setIdItem(5);
		cronogramaId.setIdProposta(proposta.getId());
		lstCronograma = getDaoCronograma().procurarPorId(cronogramaId.getIdProposta(),cronogramaId.getIdItem());
		
		return "construirCronograma";
	}

	// Pendente
	public String SalvarCronograma() {

		equipe = proposta.getEquipe();

		try {
			// Setando o Id composto do Proposta Item
			PropItemId.setIdItem(5);
			PropItemId.setIdProposta(proposta.getId());
			status.setId(1);

			for (Cronograma lc : lstCronograma) {
				getDaoCronograma().salvar(lc);
			}
			/*if(lstlistaFuncaoDel!=null){
				for (ListaFuncao lf : lstlistaFuncaoDel) {
					getDaoListaFuncao().remover(lf);
				}
			*/		
			//}
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prepararBean();
	}

	/*
	 * public String preperarEdicao() { equipe = (Equipe)
	 * objDatatableEquipe.getRowData(); return "alterar"; }
	 * 
	 * public void pesquisar() { listaEquipe =
	 * getDaoEquipe().listarPorNome(equipe.getNome()); }
	 * 
	 * public String salvar() { try { getDaoEquipe().inserir(equipe); } catch
	 * (Exception e) { e.printStackTrace(); } return prepararBean(); }
	 * 
	 * public String alterar() { try { getDaoEquipe().alterar(equipe); } catch
	 * (Exception e) { e.printStackTrace(); } return "visualizar"; }
	 * 
	 * 
	 * public String excluir() { equipe = (Equipe)
	 * objDatatableEquipe.getRowData(); getDaoEquipe().remover(equipe); return
	 * prepararBean(); }
	 */
	/*
	 * Getters and Setters
	 */

	public void setListaEquipe(List<Equipe> listaEquipe) {
		this.listaEquipe = listaEquipe;
	}

	public List<Equipe> getListaEquipe() {
		return listaEquipe;
	}

	public FacadeEquipe getDaoEquipe() {
		return daoEquipe;
	}

	public void setDaoEquipe(FacadeEquipe daoEquipe) {
		this.daoEquipe = daoEquipe;
	}

	/**
	 * @return the propostaItem
	 */
	public PropostaItem getPropostaItem() {
		return propostaItem;
	}

	/**
	 * @param propostaItem
	 *            the propostaItem to set
	 */
	public void setPropostaItem(PropostaItem propostaItem) {
		this.propostaItem = propostaItem;
	}

	/**
	 * @return the proposta
	 */
	public Proposta getProposta() {
		return proposta;
	}

	/**
	 * @param proposta
	 *            the proposta to set
	 */
	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	/**
	 * @return the propItemId
	 */
	public PropostaItemId getPropItemId() {
		return PropItemId;
	}

	/**
	 * @param propItemId
	 *            the propItemId to set
	 */
	public void setPropItemId(PropostaItemId propItemId) {
		PropItemId = propItemId;
	}

	/**
	 * @return the equipe
	 */
	public Equipe getEquipe() {
		return equipe;
	}

	/**
	 * @param equipe
	 *            the equipe to set
	 */
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	/**
	 * @return the daoProposta
	 */
	public FacadeProposta getDaoProposta() {
		return daoProposta;
	}

	/**
	 * @param daoProposta
	 *            the daoProposta to set
	 */
	public void setDaoProposta(FacadeProposta daoProposta) {
		this.daoProposta = daoProposta;
	}

	/**
	 * @return the daoPropItem
	 */
	public FacadePropostaItem getDaoPropItem() {
		return daoPropItem;
	}

	/**
	 * @param daoPropItem
	 *            the daoPropItem to set
	 */
	public void setDaoPropItem(FacadePropostaItem daoPropItem) {
		this.daoPropItem = daoPropItem;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the daoTipoFuncao
	 */
	public FacadeTipoFuncao getDaoTipoFuncao() {
		return daoTipoFuncao;
	}

	/**
	 * @param daoTipoFuncao
	 *            the daoTipoFuncao to set
	 */
	public void setDaoTipoFuncao(FacadeTipoFuncao daoTipoFuncao) {
		this.daoTipoFuncao = daoTipoFuncao;
	}

	/**
	 * @return the tipofuncao
	 */
	public TipoFuncao getTipofuncao() {
		return tipofuncao;
	}

	/**
	 * @param tipofuncao
	 *            the tipofuncao to set
	 */
	public void setTipofuncao(TipoFuncao tipofuncao) {
		this.tipofuncao = tipofuncao;
	}

	/**
	 * @return the listaFuncao
	 */
	public ListaFuncao getListaFuncao() {
		return listaFuncao;
	}

	/**
	 * @param listaFuncao
	 *            the listaFuncao to set
	 */
	public void setListaFuncao(ListaFuncao listaFuncao) {
		this.listaFuncao = listaFuncao;
	}

	/**
	 * @return the objDatatableListaFuncao
	 */
	public UIData getObjDatatableListaFuncao() {
		return objDatatableListaFuncao;
	}

	/**
	 * @param objDatatableListaFuncao
	 *            the objDatatableListaFuncao to set
	 */
	public void setObjDatatableListaFuncao(UIData objDatatableListaFuncao) {
		this.objDatatableListaFuncao = objDatatableListaFuncao;
	}

	/**
	 * @return the lstlistaFuncao
	 */
	public List<ListaFuncao> getLstlistaFuncao() {
		return lstlistaFuncao;
	}

	/**
	 * @param lstlistaFuncao
	 *            the lstlistaFuncao to set
	 */
	public void setLstlistaFuncao(List<ListaFuncao> lstlistaFuncao) {
		this.lstlistaFuncao = lstlistaFuncao;
	}

	/**
	 * @return the daoListaFuncao
	 */
	public FacadeListaFuncao getDaoListaFuncao() {
		return daoListaFuncao;
	}

	/**
	 * @param daoListaFuncao
	 *            the daoListaFuncao to set
	 */
	public void setDaoListaFuncao(FacadeListaFuncao daoListaFuncao) {
		this.daoListaFuncao = daoListaFuncao;
	}

	/**
	 * @return the listafuncaoid
	 */
	public ListaFuncaoId getListafuncaoid() {
		return listafuncaoid;
	}

	/**
	 * @param listafuncaoid
	 *            the listafuncaoid to set
	 */
	public void setListafuncaoid(ListaFuncaoId listafuncaoid) {
		this.listafuncaoid = listafuncaoid;
	}

	/**
	 * @return the artefatos
	 */
	public Artefatos getArtefatos() {
		return artefatos;
	}

	/**
	 * @param artefatos
	 *            the artefatos to set
	 */
	public void setArtefatos(Artefatos artefatos) {
		this.artefatos = artefatos;
	}

	/**
	 * @return the daoArtefatos
	 */
	public FacadeArtefatos getDaoArtefatos() {
		return daoArtefatos;
	}

	/**
	 * @param daoArtefatos
	 *            the daoArtefatos to set
	 */
	public void setDaoArtefatos(FacadeArtefatos daoArtefatos) {
		this.daoArtefatos = daoArtefatos;
	}

	/**
	 * @return the lstArtefatos
	 */
	public List<Artefatos> getLstArtefatos() {
		return lstArtefatos;
	}

	/**
	 * @param lstArtefatos
	 *            the lstArtefatos to set
	 */
	public void setLstArtefatos(List<Artefatos> lstArtefatos) {
		this.lstArtefatos = lstArtefatos;
	}

	/**
	 * @return the lstCronograma
	 */
	public List<Cronograma> getLstCronograma() {
		return lstCronograma;
	}

	/**
	 * @param lstCronograma
	 *            the lstCronograma to set
	 */
	public void setLstCronograma(List<Cronograma> lstCronograma) {
		this.lstCronograma = lstCronograma;
	}

	/**
	 * @return the cronograma
	 */
	public Cronograma getCronograma() {
		return cronograma;
	}

	/**
	 * @param cronograma
	 *            the cronograma to set
	 */
	public void setCronograma(Cronograma cronograma) {
		this.cronograma = cronograma;
	}

	/**
	 * @return the cronogramaId
	 */
	public CronogramaId getCronogramaId() {
		return cronogramaId;
	}

	/**
	 * @param cronogramaId
	 *            the cronogramaId to set
	 */
	public void setCronogramaId(CronogramaId cronogramaId) {
		this.cronogramaId = cronogramaId;
	}

	/**
	 * @return the objDatatableCronograma
	 */
	public UIData getObjDatatableCronograma() {
		return objDatatableCronograma;
	}

	/**
	 * @param objDatatableCronograma
	 *            the objDatatableCronograma to set
	 */
	public void setObjDatatableCronograma(UIData objDatatableCronograma) {
		this.objDatatableCronograma = objDatatableCronograma;
	}

	/**
	 * @return the lstlistaFuncaoDel
	 */
	public List<ListaFuncao> getLstlistaFuncaoDel() {
		return lstlistaFuncaoDel;
	}

	/**
	 * @param lstlistaFuncaoDel
	 *            the lstlistaFuncaoDel to set
	 */
	public void setLstlistaFuncaoDel(List<ListaFuncao> lstlistaFuncaoDel) {
		this.lstlistaFuncaoDel = lstlistaFuncaoDel;
	}

	/**
	 * @return the daoCronograma
	 */
	public FacadeCronograma getDaoCronograma() {
		return daoCronograma;
	}

	/**
	 * @param daoCronograma the daoCronograma to set
	 */
	public void setDaoCronograma(FacadeCronograma daoCronograma) {
		this.daoCronograma = daoCronograma;
	}

}
