package br.com.gerpro.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
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
import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.dao.impl.ArtefatosDao;
import br.com.gerpro.dao.impl.CronogramaDao;
import br.com.gerpro.dao.impl.EquipeDao;
import br.com.gerpro.dao.impl.ListaFuncaoDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.dao.impl.PropostaItemDao;
import br.com.gerpro.dao.impl.TipoFuncaoDao;
import br.com.gerpro.dao.impl.UsuarioDao;
import br.com.gerpro.mensagens.MessageManagerImpl;
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
import br.com.gerpro.model.Usuario;
import br.com.gerpro.util.ApplicationSecurityManager;

public class ConstruirPropostaBean {
	private UIData objDatatableListaFuncao;// componente da tela - JSP
	private UIData objDatatableCronograma;
	private boolean desabilitar;
	private List<Equipe> listaEquipe;
	private List<ListaFuncao> lstlistaFuncao = new ArrayList<ListaFuncao>();
	private List<ListaFuncao> lstlistaFuncaoDel = new ArrayList<ListaFuncao>();
	private List<Cronograma> lstCronograma = new ArrayList<Cronograma>();
	private List<Artefatos> lstArtefatos = new ArrayList<Artefatos>();
	private List<Usuario> listaUsuarios;
	private ApplicationSecurityManager appSecurityManager = new ApplicationSecurityManager();

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

	private FacadeUsuario usuarioDao = new UsuarioDao();
	private FacadeEquipe daoEquipe = new EquipeDao();
	private FacadeArtefatos daoArtefatos = new ArtefatosDao();
	private FacadeProposta daoProposta = new PropostaDao();
	private FacadePropostaItem daoPropItem = new PropostaItemDao();
	private FacadeTipoFuncao daoTipoFuncao = new TipoFuncaoDao();
	private FacadeListaFuncao daoListaFuncao = new ListaFuncaoDao();
	private FacadeCronograma daoCronograma = new CronogramaDao();

	private void desabilitar() {
		if (proposta.getStatus().getId() == 1) {
			desabilitar = false;
		} else {
			desabilitar = true;
		}

	}

	// ComboBox Tipo de FunÃ§oes
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

	// Adiciona uma função na tabela de lista de funÃ§Ãµes
	public void addfuncao() {
		try {
			if (lstlistaFuncao.indexOf(listaFuncao) == -1) {
				if (tipofuncao.getId() == 1) {
					tipofuncao.setNome("Manter");
				}
				if (tipofuncao.getId() == 2) {
					tipofuncao.setNome("Processamento");
				}
				if (tipofuncao.getId() == 3) {
					tipofuncao.setNome("RelatÃ³rio");
				}
				listafuncaoid.setIdItem(2);
				listafuncaoid.setIdProposta(proposta.getId());

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
					tipofuncao.setNome("RelatÃ³rio");
				}
				listafuncaoid.setIdItem(2);
				listafuncaoid.setIdProposta(proposta.getId());

				listaFuncao.setId(listafuncaoid);
				listaFuncao.setTipoFuncao(tipofuncao);

				lstlistaFuncao.set(lstlistaFuncao.indexOf(listaFuncao),
						listaFuncao);
				listafuncaoid = new ListaFuncaoId();
				listaFuncao = new ListaFuncao();
				tipofuncao = new TipoFuncao();
			}

		} catch (Exception e) {
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
					"erro.insercao", null);
		}
	}

	// Remover uma função da tabela de lista de funÃ§Ãµes
	public void delfuncao() {
		try {
			int id = objDatatableListaFuncao.getRowIndex();
			listaFuncao = (ListaFuncao) objDatatableListaFuncao.getRowData();
			lstlistaFuncaoDel.add(listaFuncao);
			lstlistaFuncao.remove(id);
			listaFuncao = new ListaFuncao();

		} catch (Exception e) {
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
					"erro.exclusao", null);
		}

	}

	// Seleciona uma função da tabela de lista de funÃ§Ãµes para a alteracao
	public void editfuncao() {
		try {
			listaFuncao = (ListaFuncao) objDatatableListaFuncao.getRowData();
			listafuncaoid = listaFuncao.getId();
			tipofuncao = listaFuncao.getTipoFuncao();

		} catch (Exception e) {
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
					"erro.inclusao", null);
		}
	}

	/**
	 * Adiciona uma função na tabela de lista de Cronograma
	 */
	@SuppressWarnings("deprecation")
	public void addCronograma() {
		try {
			lstArtefatos = getDaoArtefatos().listar();
			// Verifica se ja existe o item na lista
			if (lstCronograma.indexOf(cronograma) == -1) {

				// Adiciona um novo item na lsita de cronogramas
				for (Artefatos artefato : lstArtefatos) {
					if (artefatos.getId().equals(artefato.getId())) {
						artefatos.setNome(artefato.getNome());
					}
				}

				java.util.Calendar endDate = GregorianCalendar.getInstance();
				endDate.setTime((Date) cronograma.getDataInicial());
				java.util.Calendar startDate = GregorianCalendar.getInstance();
				startDate.add(java.util.Calendar.DATE, -1);

				// Verifica se a data de inicio Ã© maior que data final
				if ((cronograma.getDataInicial().compareTo(
						cronograma.getDataFinal()) == 1)
						|| (startDate.after(endDate)))

				{
					MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
							"data.inicial.maior", null);
				} else {
					// Adiciona um cronograma a lista
					cronogramaId.setIdItem(5);
					cronogramaId.setIdProposta(proposta.getId());

					cronograma.setId(cronogramaId);

					cronograma.setArtefatos(artefatos);
					lstCronograma.add(cronograma);
					cronogramaId = new CronogramaId();
					cronograma = new Cronograma();
					artefatos = new Artefatos();
				}

			}
			// Altera o cronograma da lista
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

				// Verifica se a data de inicio é maior que data final
				if ((cronograma.getDataInicial().compareTo(
						cronograma.getDataFinal()) == 1)
						|| (startDate.after(endDate)))

				{
					MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
							"data.inicial.maior", null);
				} else {
					cronogramaId.setIdItem(5);
					cronogramaId.setIdProposta(proposta.getId());

					cronograma.setId(cronogramaId);

					cronograma.setArtefatos(artefatos);
					lstCronograma.set(lstCronograma.indexOf(cronograma),
							cronograma);
					cronogramaId = new CronogramaId();
					cronograma = new Cronograma();
					artefatos = new Artefatos();
				}
			}

		} catch (Exception e) {
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
					"erro.inclusao", null);
		}
	}

	// Remover uma funÃ§Ã£o da tabela de lista de funÃ§Ãµes
	public void delCronograma() {
		try {
			int id = objDatatableCronograma.getRowIndex();
			lstCronograma.remove(id);
		} catch (Exception e) {
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
					"erro.exclusao", null);
		}
	}

	// Seleciona uma funÃ§Ã£o da tabela de lista de funÃ§Ãµes para a alteracao
	public void editCronograma() {
		try {
			cronograma = (Cronograma) objDatatableCronograma.getRowData();
			cronogramaId = cronograma.getId();
			artefatos = cronograma.getArtefatos();			
		} catch (Exception e) {
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
					"erro.insercao", null);			
		}		
	}

	public String prepararBean() {

		proposta = getDaoProposta().procurarPorId(
				appSecurityManager.getProposta().getId());
		equipe = proposta.getEquipe();
		desabilitar();
		return "go_ConstruirProposta";
	}

	/*
	 * Metodos para MissÃ£o proposta
	 */
	public String prepararMissao() {
		prepararContrucaoItemSimples(1);
		
//		proposta = getDaoProposta().procurarPorId(
//				appSecurityManager.getProposta().getId());
//		equipe = proposta.getEquipe();
//		listaUsuarios = usuarioDao.listarPorEquipe(equipe.getId());
//		PropItemId.setIdItem(1);
//		PropItemId.setIdProposta(proposta.getId());
//		propostaItem = (PropostaItem) getDaoPropItem().procurarPorProposta(
//				PropItemId);
//		desabilitar();
		return "construirMissao";
	}

	// Salvar a missao da proposta
	public void salvarMissao() {
		salvarConstrucaoItemSimples(1);

//		equipe = proposta.getEquipe();
//
//		try {
//			// Setando o Id composto do Proposta Item
//			PropItemId.setIdItem(1);
//			PropItemId.setIdProposta(proposta.getId());
//			status.setId(6);
//			propostaItem.setStatus(status);
//			propostaItem.setId(PropItemId);
//			getDaoPropItem().salvar(propostaItem);
//		} catch (Exception e) {
//			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
//					"erro.insercao", null);			
//			
//		}
//		MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_INFO,
//				"sucesso.insercao", null);
	}

	public String prepararListaFuncao() {
		proposta = getDaoProposta().procurarPorId(
				appSecurityManager.getProposta().getId());
		equipe = proposta.getEquipe();
		listaUsuarios = usuarioDao.listarPorEquipe(equipe.getId());
		PropItemId.setIdItem(2);
		PropItemId.setIdProposta(proposta.getId());
		propostaItem = (PropostaItem) getDaoPropItem().procurarPorProposta(
				PropItemId);
		listafuncaoid.setIdItem(2);
		listafuncaoid.setIdProposta(proposta.getId());
		lstlistaFuncao = getDaoListaFuncao().procurarPorId(
				listafuncaoid.getIdProposta(), listafuncaoid.getIdItem());
		desabilitar();
		return "construirListaFuncoes";
	}

	// Percorrre a lstlistafuncao pra salvar a as listas de funcoes da proposta
	public void salvarListaFuncao() {

		equipe = proposta.getEquipe();

		try {
			// Setando o Id composto do Proposta Item
			PropItemId.setIdItem(2);
			PropItemId.setIdProposta(proposta.getId());
			status.setId(6);
			propostaItem.setStatus(status);
			getDaoPropItem().salvar(propostaItem);
			for (ListaFuncao lf : lstlistaFuncao) {
				getDaoListaFuncao().salvar(lf);
			}
			if (lstlistaFuncaoDel != null) {
				for (ListaFuncao lf : lstlistaFuncaoDel) {
					getDaoListaFuncao().remover(lf);
				}

			}
			getDaoPropItem().salvar(propostaItem);

		} catch (Exception e) {
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
					"erro.insercao", null);			
			
		}
		MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_INFO,
				"sucesso.insercao", null);
	}

	/*
	 * Metodos para Justificativa da proposta
	 */
	public String prepararJustificativa() {
		prepararContrucaoItemSimples(3);
		
//		proposta = getDaoProposta().procurarPorId(
//				appSecurityManager.getProposta().getId());
//		equipe = proposta.getEquipe();
//		listaUsuarios = usuarioDao.listarPorEquipe(equipe.getId());
//		PropItemId.setIdItem(3);
//		PropItemId.setIdProposta(proposta.getId());
//		propostaItem = (PropostaItem) getDaoPropItem().procurarPorProposta(
//				PropItemId);
//		desabilitar();
		
		return "construirJustificativa";
	}

	// OK
	public void salvarJustificativa() {
		salvarConstrucaoItemSimples(3);
		

//		equipe = proposta.getEquipe();
//
//		try {
//
//			// Setando o Id composto do Proposta Item
//			PropItemId.setIdItem(3);
//			PropItemId.setIdProposta(proposta.getId());
//			status.setId(6);
//			propostaItem.setStatus(status);
//			propostaItem.setId(PropItemId);
//			getDaoPropItem().salvar(propostaItem);
//
//		} catch (Exception e) {
//			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
//					"erro.insercao", null);			
//			
//		}
//		MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_INFO,
//				"sucesso.insercao", null);
	}

	// OK
	public String prepararMetodologia() {
		prepararContrucaoItemSimples(4);
		
//		proposta = getDaoProposta().procurarPorId(
//				appSecurityManager.getProposta().getId());
//		equipe = proposta.getEquipe();
//		listaUsuarios = usuarioDao.listarPorEquipe(equipe.getId());
//		PropItemId.setIdItem(4);
//		PropItemId.setIdProposta(proposta.getId());
//		propostaItem = (PropostaItem) getDaoPropItem().procurarPorProposta(
//				PropItemId);
//		desabilitar();
		return "construirMetodologia";
	}

	// OK
	public void salvarMetodologia() {
		salvarConstrucaoItemSimples(4);

//		equipe = proposta.getEquipe();
//
//		try {
//			// Setando o Id composto do Proposta Item
//			PropItemId.setIdItem(4);
//			PropItemId.setIdProposta(proposta.getId());
//			status.setId(6);
//			propostaItem.setStatus(status);
//			propostaItem.setId(PropItemId);
//			getDaoPropItem().salvar(propostaItem);
//
//		}catch (Exception e) {
//			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
//					"erro.insercao", null);			
//			
//		}
//		MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_INFO,
//				"sucesso.insercao", null);
	}

	// OK
	public String prepararCronograma() {
		proposta = getDaoProposta().procurarPorId(
				appSecurityManager.getProposta().getId());
		equipe = proposta.getEquipe();
		listaUsuarios = usuarioDao.listarPorEquipe(equipe.getId());
		PropItemId.setIdItem(5);
		PropItemId.setIdProposta(proposta.getId());
		propostaItem = (PropostaItem) getDaoPropItem().procurarPorProposta(
				PropItemId);
		cronogramaId.setIdItem(5);
		cronogramaId.setIdProposta(proposta.getId());
		lstCronograma = getDaoCronograma().procurarPorId(
				cronogramaId.getIdProposta(), cronogramaId.getIdItem());
		desabilitar();
		return "construirCronograma";
	}

	// Pendente
	public void salvarCronograma() {

		equipe = proposta.getEquipe();

		try {
			// Setando o Id composto do Proposta Item
			PropItemId.setIdItem(5);
			PropItemId.setIdProposta(proposta.getId());
			status.setId(6); // Defini o status como concluido
			propostaItem.setStatus(status);
			getDaoPropItem().salvar(propostaItem);
			for (Cronograma lc : lstCronograma) {
				getDaoCronograma().salvar(lc);
			}

		} catch (Exception e) {
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
					"erro.insercao", null);			
			
		}
		MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_INFO,
				"sucesso.insercao", null);
	}
	
	private void prepararContrucaoItemSimples(int idItem){
		proposta = getDaoProposta().procurarPorId(
				appSecurityManager.getProposta().getId());
		equipe = proposta.getEquipe();
		listaUsuarios = usuarioDao.listarPorEquipe(equipe.getId());
		PropItemId.setIdItem(idItem);
		PropItemId.setIdProposta(proposta.getId());
		propostaItem = (PropostaItem) getDaoPropItem().procurarPorProposta(
				PropItemId);
		desabilitar();
	}
	
	private void salvarConstrucaoItemSimples(int idItem){
		equipe = proposta.getEquipe();

		try {
			// Setando o Id composto do Proposta Item
			PropItemId.setIdItem(idItem);
			PropItemId.setIdProposta(proposta.getId());
			status.setId(6);
			propostaItem.setStatus(status);
			propostaItem.setId(PropItemId);
			getDaoPropItem().salvar(propostaItem);

		}catch (Exception e) {
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
					"erro.insercao", null);			
			
		}
		MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_INFO,
				"sucesso.insercao", null);
		
	}

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
	 * @param daoCronograma
	 *            the daoCronograma to set
	 */
	public void setDaoCronograma(FacadeCronograma daoCronograma) {
		this.daoCronograma = daoCronograma;
	}

	/**
	 * @return the desabilitar
	 */
	public boolean isDesabilitar() {
		return desabilitar;
	}

	/**
	 * @param desabilitar
	 *            the desabilitar to set
	 */
	public void setDesabilitar(boolean desabilitar) {
		this.desabilitar = desabilitar;
	}

	/**
	 * @return the listaUsuarios
	 */
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	/**
	 * @param listaUsuarios
	 *            the listaUsuarios to set
	 */
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
