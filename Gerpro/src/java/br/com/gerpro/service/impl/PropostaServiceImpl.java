/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerpro.service.impl;

import br.com.gerpro.dao.PropostaDao;
import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Status;
import br.com.gerpro.service.EquipeService;
import br.com.gerpro.service.PropostaService;
import br.com.gerpro.service.UsuarioService;
import java.util.List;

/**
 *
 * @author msouza
 */
public class PropostaServiceImpl implements PropostaService {//extends HibernateDaoSupport

    public void createProposta(final Proposta proposta) {     //, final Equipe equipe, final List alunos) {

        /*if (proposta.getPropostaItems() == null) {
        proposta.setPropostaItems(new HashSet<PropostaItem>());
        }

        try {
        getSession().beginTransaction();

        //getHibernateTemplate().getSessionFactory().getCurrentSession().beginTransaction();


        Equipe equipe = proposta.getEquipe();
        if (equipe != null) {
        proposta.setEquipe(equipe);
        }
        Status status = proposta.getStatus();
        if (status != null) {
        status = (Status) getSession().get(status.getClass(), status.getId());
        proposta.setStatus(status);
        }
        Periodo periodo = proposta.getPeriodo();
        if (periodo != null) {
        periodo = (Periodo) getSession().get(periodo.getClass(), periodo.getId());//em.getReference(periodo.getClass(), periodo.getId());
        proposta.setPeriodo(periodo);
        }
        Set<PropostaItem> attachedPropostaItems = new HashSet<PropostaItem>();
        for (PropostaItem propostaItemsPropostaItemToAttach : proposta.getPropostaItems()) {
        propostaItemsPropostaItemToAttach = (PropostaItem) getSession().get(propostaItemsPropostaItemToAttach.getClass(), propostaItemsPropostaItemToAttach.getId());//em.getReference(propostaItemsPropostaItemToAttach.getClass(), propostaItemsPropostaItemToAttach.getId());
        attachedPropostaItems.add(propostaItemsPropostaItemToAttach);
        }
        proposta.setPropostaItems(attachedPropostaItems);
        getHibernateTemplate().persist(proposta);//em.persist(proposta);
        if (equipe != null) {
        equipe.getPropostas().add(proposta);
        equipe = (Equipe) getHibernateTemplate().merge(equipe);//em.merge(equipe);
        }
        if (status != null) {
        status.getPropostas().add(proposta);
        status = (Status) getHibernateTemplate().merge(status);//em.merge(status);
        }
        if (periodo != null) {
        periodo.getPropostas().add(proposta);
        periodo = (Periodo)getHibernateTemplate().merge(periodo);
        }
        for (PropostaItem propostaItemsPropostaItem : proposta.getPropostaItems()) {
        Proposta oldPropostaOfPropostaItemsPropostaItem = propostaItemsPropostaItem.getProposta();
        propostaItemsPropostaItem.setProposta(proposta);
        propostaItemsPropostaItem =
        (PropostaItem) getHibernateTemplate().merge(propostaItemsPropostaItem);
        if (oldPropostaOfPropostaItemsPropostaItem != null) {
        oldPropostaOfPropostaItemsPropostaItem.getPropostaItems().remove(propostaItemsPropostaItem);
        oldPropostaOfPropostaItemsPropostaItem =
        (Proposta) getHibernateTemplate().merge(oldPropostaOfPropostaItemsPropostaItem);
        }
        }
        getSession().getTransaction().commit();

        //getHibernateTemplate().getSessionFactory().
        //      getCurrentSession().getTransaction().commit();
        }finally{
        //if(getHibernateTemplate().getSessionFactory().getCurrentSession().isOpen() )
        //     getHibernateTemplate().getSessionFactory().getCurrentSession().close();
        //if(getSession().isOpen())
        //getSession().close();

    }
    */

        /*hibernateTemplate.execute(new HibernateCallback() {

        public Object doInHibernate(Session session)
        throws HibernateException, SQLException {

        try {
        Proposta propostaBD = propostaDao.read(propostaView.getId());
        if (!(propostaBD.getNome().equals(propostaView.getNome()))) {
        if(propostaDao.findByName(propostaView.getNome()) == null){
        propostaDao.save(propostaView);
        }

        } else {
        return "Nome de proposta já cadastrado";
        }

        equipeService.createEquipe(equipe);

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
        });*/
        }


    public void saveProposta(final Proposta proposta) {
        System.out.println("Proposta: " + proposta.getNome());
        System.out.println("Equipe: " + proposta.getEquipe().getNome());
        propostaDao.create(proposta);


    /*hibernateTemplate.execute(new HibernateCallback() {

    public Object doInHibernate(Session session)
    throws HibernateException, SQLException {

    try {
    List consultaProposta = propostaDao.findByName(proposta.getNome());
    if (consultaProposta == null) {
    propostaDao.save(proposta);
    } else {
    return "Nome de proposta já cadastrado";
    }

    Iterator iterator = proposta.getEquipe().getAlunos().iterator();


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
    });*/
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

    public void setEquipeService(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    public void setPropostaDao(PropostaDao propostaDao) {
        this.propostaDao = propostaDao;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
