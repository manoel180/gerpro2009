/**
 * 
 */
package br.com.gerpro.action;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;

import br.com.gerpro.dao.FacadeCorrecao;
import br.com.gerpro.dao.FacadeCronograma;
import br.com.gerpro.dao.FacadeListaFuncao;
import br.com.gerpro.dao.FacadePergunta;
import br.com.gerpro.dao.FacadeProposta;
import br.com.gerpro.dao.FacadePropostaItem;
import br.com.gerpro.dao.FacadeUsuario;
import br.com.gerpro.dao.impl.CorrecaoDao;
import br.com.gerpro.dao.impl.CronogramaDao;
import br.com.gerpro.dao.impl.ListaFuncaoDao;
import br.com.gerpro.dao.impl.PerguntaDao;
import br.com.gerpro.dao.impl.PropostaDao;
import br.com.gerpro.dao.impl.PropostaItemDao;
import br.com.gerpro.dao.impl.UsuarioDao;
import br.com.gerpro.mensagens.MessageManagerImpl;
import br.com.gerpro.model.Correcao;
import br.com.gerpro.model.CorrecaoId;
import br.com.gerpro.model.Cronograma;
import br.com.gerpro.model.Equipe;
import br.com.gerpro.model.ListaFuncao;
import br.com.gerpro.model.Pergunta;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.PropostaItem;
import br.com.gerpro.model.PropostaItemId;
import br.com.gerpro.model.Resposta;
import br.com.gerpro.model.Status;
import br.com.gerpro.model.Usuario;
import br.com.gerpro.processing.ProcessoCorrecao;
import br.com.gerpro.util.ApplicationSecurityManager;

/**
 * @author M3R
 * 
 */
public class CorrecaoBean {

	private UIData objDatatableCorrecao;// componente da tela - JSP
	private List<Correcao> listaCorrecao;
	private List<Pergunta> listaPergunta;
	private List<ListaFuncao> lstListaFuncao;
	private List<Cronograma> lstCronograma;
	private List<PropostaItem> listaPropostaItem;
	private Correcao correcao = new Correcao();
	private FacadeCorrecao correcaoDao = new CorrecaoDao();
	private FacadePergunta perguntaDao = new PerguntaDao();
	private FacadeProposta propostaDao = new PropostaDao();
	private FacadePropostaItem propostaItemDao = new PropostaItemDao();
	private ProcessoCorrecao processoCorrecao = new ProcessoCorrecao();
	private boolean desabilitar;

	private FacadeCronograma daoCronograma = new CronogramaDao();
	private FacadeListaFuncao daoListaFuncao = new ListaFuncaoDao();
	private PropostaItem propostaitem = new PropostaItem();
	private PropostaItemId propostaitemId = new PropostaItemId();
	private ApplicationSecurityManager applicationSecurityManager = new ApplicationSecurityManager();
	private CorrecaoId correcaoid = new CorrecaoId();
	private Usuario usuario = new Usuario();
	private Resposta resposta = new Resposta();
	private Equipe equipe = new Equipe();
	private Status status = new Status();
	private Proposta proposta = new Proposta();
	private Pergunta pergunta = new Pergunta();


	/***************************************************************************
	 * Método para desabilitar a opção de correcao dos itens da proposta
	 * caso ela já tenha sido corrigida *
	 */
	private void desabilitar() {
		if (propostaEmCorrecao()) {
			desabilitar = false;
		} else {
			desabilitar = true;
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_INFO,
					"aviso",
					"proposta.corrigida");
		}
	}

	private void carregarCorrecao(String professor, int item, int pergunta) {
		// Carrega a Correcao
		correcaoid.setIdItem(item);
		correcaoid.setIdPergunta(pergunta);
		correcaoid.setIdProposta(applicationSecurityManager.getProposta()
				.getId());

		correcaoid.setMatriculaProfessor(professor);
		correcao = getCorrecaoDao().procurarPorIdCorrecao(correcaoid);

	}

	private void carregarItem(int item) {
		// Carrega o item
		propostaitemId.setIdItem(item);
		propostaitemId.setIdProposta(applicationSecurityManager.getProposta()
				.getId());

		propostaitem = (PropostaItem) propostaItemDao
				.procurarPorProposta(propostaitemId);
		if (item == 2) {
			lstListaFuncao = getDaoListaFuncao().procurarPorId(
					applicationSecurityManager.getProposta().getId(),
					propostaitem.getId().getIdItem());
		}
		if (item == 5) {
			lstCronograma = daoCronograma.procurarPorId(
					applicationSecurityManager.getProposta().getId(),
					propostaitem.getId().getIdItem());
		}
	}

	private void carregarEquipe() {
		proposta = propostaDao.procurarPorId(applicationSecurityManager
				.getProposta().getId());
		equipe = proposta.getEquipe();
	}

	public String prepararBean() {

		correcao = new Correcao();

		return prepararCorrigirMissao();
	}

	public String prepararCorrecao() {
		
		proposta = applicationSecurityManager.getProposta();
		
		SubmeterPropostaBean submeterPropostaBean = new SubmeterPropostaBean();
		submeterPropostaBean.setProposta(proposta);
		return "corrigirProposta";
	}

	public String prepararCorrigirMissao() {
		prepararItem(applicationSecurityManager.getUsuario().getMatricula(),
				1, 4);		
		return "corrigirMissao";
	}

	public String prepararCorrigirMetodologia() {
		prepararItem(applicationSecurityManager.getUsuario().getMatricula(), 4,
				6);
		return "corrigirMetodologia";
	}

	public String prepararCorrigirJustificativa() {
		prepararItem(applicationSecurityManager.getUsuario().getMatricula(), 3,
				3);
		return "corrigirJustificativa";
	}

	public String prepararCorrigirListaFuncao() {
		prepararItem(applicationSecurityManager.getUsuario().getMatricula(), 2,
				5);
		return "corrigirListaFuncoes";
	}

	public String prepararCorrigirCronograma() {
		prepararItem(applicationSecurityManager.getUsuario().getMatricula(), 5,
				8);
		return "corrigirCronograma";
	}

	public String prepararAvaliacaoGeral1() {
		prepararItem(applicationSecurityManager.getUsuario().getMatricula(), 6,
				1);
		return "corrigirAvaliacaoGeral1";
	}

	public String prepararAvaliacaoGeral2() {
		prepararItem(applicationSecurityManager.getUsuario().getMatricula(), 6,
				2);
		return "corrigirAvaliacaoGeral2";
	}

	public String prepararAvaliacaoGeral7() {
		prepararItem(applicationSecurityManager.getUsuario().getMatricula(), 6,
				7);
		return "corrigirAvaliacaoGeral7";
	}

	public void prepararItem(String matricula, int idItem, int idPergunta) {
		try {
			carregarCorrecao(matricula, idItem, idPergunta);
			carregarItem(idItem);
			carregarEquipe();

			status = proposta.getStatus();
			resposta = correcao.getResposta();
			if (resposta == null) {
				resposta = new Resposta();
				resposta.setId(1);
			}
			pergunta = getPerguntaDao().procurarPorId(idPergunta);

			desabilitar();

		} catch (Exception e) {
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
							"erro",
							"proposta.naoselecionada_detail");
		}

	}

	public String prepararSubmeterCorrecao() {
		try {
			Proposta proposta = applicationSecurityManager.getProposta();
			Usuario professor = applicationSecurityManager.getUsuario();
			listaPropostaItem = propostaItemDao.listarPoridProposta(proposta.getId());

			setListaCorrecao(correcaoDao.procurarPorCorrecao(professor, proposta));

			status = proposta.getStatus();
			equipe = proposta.getEquipe();
			desabilitar();
			
		} catch (Exception e) {
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
					"erro",
					"proposta.naoselecionada_detail");
		}
		
		return "submeterCorrecao";
		
	}

	public void salvarCorrigir() {		
			salvarCorrecaoItem();

	}

	public void salvarAvaliacaoGeral1() {

		salvarCorrecaoItem();


	}

	public void salvarAvaliacaoGeral2() {

		salvarCorrecaoItem();


	}

	public void salvarAvaliacaoGeral3() {
		salvarCorrecaoItem();

	}

	public void salvarCorrecaoItem() {
		try {
			usuario.setMatricula(applicationSecurityManager.getUsuario()
					.getMatricula());

			status.setId(7);
			correcao.setId(correcaoid);
			correcao.setUsuario(usuario);
			correcao.setPergunta(pergunta);			
			correcao.setResposta(resposta);
			correcao.setStatus(status);
			getCorrecaoDao().salvar(correcao);
			
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_INFO,
					"sucesso", "sucesso.corrigir.item_detail");

		} catch (Exception e) {
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
					"erro", "erro.insercao");
		}
	}

	public boolean propostaEmCorrecao() {

		Usuario professor = applicationSecurityManager.getUsuario();
		Proposta proposta = applicationSecurityManager.getProposta();

		listaCorrecao = getCorrecaoDao().procurarPorCorrecao(professor,
				proposta);

		int contadorItensCorridos = 0;

		for (Correcao correcao : listaCorrecao) {
			if (correcao.getDataCorrecao() != null) {
				contadorItensCorridos++;
			}			
		}

		if (contadorItensCorridos == 8) {
			
			return false;
		}
		
		return true;
	}

	/***************************************************************************
	 * Processo para submeter uma proposta
	 */
	public void submeterCorrecao() {
		try {
			Proposta proposta = applicationSecurityManager.getProposta();
			Usuario professor = applicationSecurityManager.getUsuario();
			processoCorrecao.calcularStatusPropostaAtual(professor, proposta);
			
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_INFO,
					"sucesso", "sucesso.submeter.correcao_detail");
			
		} catch (Exception e) {
			MessageManagerImpl.setMensagem(FacesMessage.SEVERITY_ERROR,
					"erro", "erro.submeter.correcao_detail");
		}		
	}	
	

	public String sairAplicacao() {
		return new UsuarioBean().sairAplicacao();
	}

	/**
	 * @return the objDatatableCorrecao
	 */
	public UIData getObjDatatableCorrecao() {
		return objDatatableCorrecao;
	}

	/**
	 * @param objDatatableCorrecao
	 *            the objDatatableCorrecao to set
	 */
	public void setObjDatatableCorrecao(UIData objDatatableCorrecao) {
		this.objDatatableCorrecao = objDatatableCorrecao;
	}

	/**
	 * @return the listaCorrecao
	 */
	public List<Correcao> getListaCorrecao() {
		return listaCorrecao;
	}

	/**
	 * @param listaCorrecao
	 *            the listaCorrecao to set
	 */
	public void setListaCorrecao(List<Correcao> listaCorrecao) {
		this.listaCorrecao = listaCorrecao;
	}

	/**
	 * @return the listaPergunta
	 */
	public List<Pergunta> getListaPergunta() {
		return listaPergunta;
	}

	/**
	 * @param listaPergunta
	 *            the listaPergunta to set
	 */
	public void setListaPergunta(List<Pergunta> listaPergunta) {
		this.listaPergunta = listaPergunta;
	}

	/**
	 * @return the correcao
	 */
	public Correcao getCorrecao() {
		return correcao;
	}

	/**
	 * @param correcao
	 *            the correcao to set
	 */
	public void setCorrecao(Correcao correcao) {
		this.correcao = correcao;
	}

	/**
	 * @return the applicationSecurityManager
	 */
	public ApplicationSecurityManager getApplicationSecurityManager() {
		return applicationSecurityManager;
	}

	/**
	 * @param applicationSecurityManager
	 *            the applicationSecurityManager to set
	 */
	public void setApplicationSecurityManager(
			ApplicationSecurityManager applicationSecurityManager) {
		this.applicationSecurityManager = applicationSecurityManager;
	}

	/**
	 * @return the resposta
	 */
	public Resposta getResposta() {
		return resposta;
	}

	/**
	 * @param resposta
	 *            the resposta to set
	 */
	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
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
	 * @return the pergunta
	 */
	public Pergunta getPergunta() {
		return pergunta;
	}

	/**
	 * @param pergunta
	 *            the pergunta to set
	 */
	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	/**
	 * @return the correcaoDao
	 */
	public FacadeCorrecao getCorrecaoDao() {
		return correcaoDao;
	}

	/**
	 * @param correcaoDao
	 *            the correcaoDao to set
	 */
	public void setCorrecaoDao(FacadeCorrecao correcaoDao) {
		this.correcaoDao = correcaoDao;
	}

	/**
	 * @return the perguntaDao
	 */
	public FacadePergunta getPerguntaDao() {
		return perguntaDao;
	}

	/**
	 * @param perguntaDao
	 *            the perguntaDao to set
	 */
	public void setPerguntaDao(FacadePergunta perguntaDao) {
		this.perguntaDao = perguntaDao;
	}

	/**
	 * @return the propostaitem
	 */
	public PropostaItem getPropostaitem() {
		return propostaitem;
	}

	/**
	 * @param propostaitem
	 *            the propostaitem to set
	 */
	public void setPropostaitem(PropostaItem propostaitem) {
		this.propostaitem = propostaitem;
	}

	/**
	 * @return the propostaitemId
	 */
	public PropostaItemId getPropostaitemId() {
		return propostaitemId;
	}

	/**
	 * @param propostaitemId
	 *            the propostaitemId to set
	 */
	public void setPropostaitemId(PropostaItemId propostaitemId) {
		this.propostaitemId = propostaitemId;
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
	 * @return the lstListaFuncao
	 */
	public List<ListaFuncao> getLstListaFuncao() {
		return lstListaFuncao;
	}

	/**
	 * @param lstListaFuncao
	 *            the lstListaFuncao to set
	 */
	public void setLstListaFuncao(List<ListaFuncao> lstListaFuncao) {
		this.lstListaFuncao = lstListaFuncao;
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

	

}
