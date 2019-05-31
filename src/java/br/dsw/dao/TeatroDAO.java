package br.dsw.dao;

import br.dsw.pojo.Teatro;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TeatroDAO extends GenericDAO<Teatro,String> {
    @Override
    public Teatro get(String id) {
        EntityManager em = this.getEntityManager();
        Teatro teatro = em.find(Teatro.class, id);
        em.close();
        
        return teatro;
    }
    
    @Override
    public void save(Teatro teatro) throws EntityExistsException{
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(teatro);
        tx.commit();
        em.close();
    }
             @Override
     public List<Teatro> getAll() {
        EntityManager em = this.getEntityManager();
        List<Teatro> teatros = em.createNamedQuery("Teatro.findAll", Teatro.class).getResultList();
        em.close();
      
        return teatros;
    }
    
    @Override
    public void update(Teatro teatro) throws EntityExistsException{
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(teatro);
        tx.commit();
        em.close();
    }
    
    @Override
    public void delete(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        teatro = em.getReference(Teatro.class, teatro.getNome());
        tx.begin();
        em.remove(teatro);
        tx.commit();
        em.close();
    }
}
