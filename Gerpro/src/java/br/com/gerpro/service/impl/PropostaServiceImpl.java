/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.service.impl;

import br.com.gerpro.dao.PropostaDao;
import br.com.gerpro.dao.PropostaItemDao;
import br.com.gerpro.dao.StatusDao;
import br.com.gerpro.model.Equipe;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.PropostaItem;
import br.com.gerpro.model.Status;
import br.com.gerpro.service.EquipeService;
import br.com.gerpro.service.PropostaService;
import br.com.gerpro.service.UsuarioService;
import br.com.gerpro.exceptions.PropostaSemEquipeException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class PropostaServiceImpl implements PropostaService {
    

    public String createProposta(final Proposta proposta) {


        transactionTemplate.execute(new TransactionCallback() {


            public Object doInTransaction(TransactionStatus ts) {

                if (verificaNomeProposta(proposta.getNome())) {
                    
                    System.out.println("Nome de Proposta já cadastrado");
                    return null;
                }

                try {

                    Equipe equipe = proposta.getEquipe();
                    if (equipe == null) {
                        System.out.println("Proposta sem equipe relacionada");
                        return null;
                        
                    }

                    Status status = proposta.getStatus();
                    if (status == null) {
                        status = statusDao.read(1);
                        proposta.setStatus(status);
                    }


                    Set<PropostaItem> itensDaProposta = new HashSet<PropostaItem>();
                    proposta.setPropostaItems(itensDaProposta);
                    proposta.setDataCriacao(new Date());

                    propostaDao.create(proposta);

                    if (status != null) {
                        status.getPropostas().add(proposta);
                        statusDao.update(status);
                    }

                /*for (PropostaItem propostaItems : proposta.getPropostaItems()) {
                Proposta oldPropostaOfPropostaItemsPropostaItem = propostaItems.getProposta();
                propostaItemsPropostaItem.setProposta(proposta);
                propostaItemsPropostaItem =
                (PropostaItem) getHibernateTemplate().merge(propostaItemsPropostaItem);
                if (oldPropostaOfPropostaItemsPropostaItem != null) {
                oldPropostaOfPropostaItemsPropostaItem.getPropostaItems().remove(propostaItemsPropostaItem);
                oldPropostaOfPropostaItemsPropostaItem =
                (Proposta) getHibernateTemplate().merge(oldPropostaOfPropostaItemsPropostaItem);
                }
                }*/
                } catch (Exception e) {
                    ts.setRollbackOnly();
                }
                return null;

            }
        });
        return null;
    }

    public void updateProposta(final Proposta proposta) {
        transactionTemplate.execute(new TransactionCallback() {

            public Object doInTransaction(TransactionStatus ts) {


                try {
                    if (verificaNomeProposta(proposta.getNome())) {
                        return "Nome de Proposta já cadastrado";
                    }
                    propostaDao.update(proposta);

                } catch (Exception e) {
                    ts.isRollbackOnly();
                }

                return null;
            }
        });
    }

    
    public void changeStatusProposta(Proposta proposta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param proposta
     */
    public boolean verificaNomeProposta(String nome) {
        List<Proposta> propostasCadastradas = propostaDao.findAll();

        for (Proposta propostaDeVarredura : propostasCadastradas) {
            if (nome.toUpperCase().equals(propostaDeVarredura.getNome().toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public Proposta findById(int id) {
        return propostaDao.read(id);
    }

    public List listAll() {
        return propostaDao.findAll();
    }

    public List listPropostaByStatus(Status status) {
        return propostaDao.findByStatus(status);
    }

    //Componentes
    private PropostaDao propostaDao;
    private EquipeService equipeService;
    private UsuarioService usuarioService;
    private TransactionTemplate transactionTemplate;
    private StatusDao statusDao;
    private PropostaItemDao propostaItemDao;

    public void setEquipeService(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    public void setPropostaDao(PropostaDao propostaDao) {
        this.propostaDao = propostaDao;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;   }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setStatusDao(StatusDao statusDao) {
        this.statusDao = statusDao;
    }

    public void setPropostaItemDao(PropostaItemDao propostaItemDao) {
        this.propostaItemDao = propostaItemDao;
    }
}