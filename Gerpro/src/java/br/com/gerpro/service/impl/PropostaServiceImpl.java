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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 *
 * @author msouza
 */
public class PropostaServiceImpl implements PropostaService {

    public void createProposta(final Proposta proposta) {

        transactionTemplate.execute(new TransactionCallback() {

            public Object doInTransaction(TransactionStatus ts) {

                if (proposta.getPropostaItems() == null) {
                    proposta.setPropostaItems(new HashSet<PropostaItem>());
                }

                try {

                    Equipe equipe = proposta.getEquipe();
                    if (equipe != null) {
                        try {
                            throw new PropostaSemEquipeException("Erro");
                        } catch (PropostaSemEquipeException ex) {
                            Logger.getLogger(PropostaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    Status status = proposta.getStatus();
                    if (status != null) {
                        status = statusDao.read(1);
                        proposta.setStatus(status);
                    }


                    /*Set<PropostaItem> attachedPropostaItems = new HashSet<PropostaItem>();
                    for (PropostaItem propostaItemsPropostaItemToAttach : proposta.getPropostaItems()) {
                    propostaItemsPropostaItemToAttach =
                    (PropostaItem) getSession().get(propostaItemsPropostaItemToAttach.getClass(), propostaItemsPropostaItemToAttach.getId());//em.getReference(propostaItemsPropostaItemToAttach.getClass(), propostaItemsPropostaItemToAttach.getId());
                    attachedPropostaItems.add(propostaItemsPropostaItemToAttach);
                    }                    proposta.setPropostaItems(attachedPropostaItems);*/

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
    }

    public void saveProposta(final Proposta proposta) {
        transactionTemplate.execute(new TransactionCallback() {

            public Object doInTransaction(TransactionStatus ts) {
                propostaDao.create(proposta);



                try {
                    /*List consultaProposta = propostaDao.findByName(proposta.getNome());
                    if (consultaProposta == null) {
                    propostaDao.save(proposta);
                    } else {
                    return "Nome de proposta já cadastrado";
                    }*/








                } catch (Exception e) {
                    ts.isRollbackOnly();
                }

            return null;


            }
        });
    }

    /*public void saveProposta(final Proposta proposta){//, final Equipe equipe, final List alunos) {
    hibernateTemplate.execute(new HibernateCallback() {

    public Object doInHibernate(Session session)
    throws HibernateException, SQLException {

    try {
    //List consultaProposta =
    if(!(propostaDao.list().contains(proposta))){
    //if (consultaProposta == null) {
    propostaDao.create(proposta);
    } else {
    return "Nome de proposta já cadastrado";
    }

    Iterator iterator = alunos.iterator();
    while (iterator.hasNext()) {
    Aluno aluno = (Aluno) iterator.next();
    alunoService.updateAluno(aluno);
    }

    session.getTransaction().commit();

    } catch (Exception e) {
    session.getTransaction().rollback();
    }
    return null;
    }
    });
    }*/
    public void deleteProposta(Proposta proposta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void updateProposta(Proposta proposta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void changeStatusProposta(Proposta proposta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Proposta findById(int id) {//Proposta proposta){
        return propostaDao.read(id);//proposta.getId());
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
        this.usuarioService = usuarioService;
    }

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
