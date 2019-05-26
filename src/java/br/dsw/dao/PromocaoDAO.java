package br.dsw.dao;

import br.dsw.pojo.Promocao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PromocaoDAO extends GenericDAO<Promocao> {
    @Override
    public Promocao get(long id) {
        EntityManager em = this.getEntityManager();
        Promocao promocao = em.getReference(Promocao.class, id);
        em.close();
        
        return promocao;
    }
     @Override
     public List<Promocao> getAll() {
        EntityManager em = this.getEntityManager();
        List<Promocao> promocoes = em.createNamedQuery("Promocao.findAll", Promocao.class).getResultList();
        for(Promocao promocao:promocoes) {
            promocao.getTeatro();
            promocao.getSiteVendas();
     }
        em.close();
      
        return promocoes;
    }
    
    @Override
    public void save(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(promocao);
        tx.commit();
        em.close();
    }
    
    @Override
    public void update(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(promocao);
        tx.commit();
        em.close();
    }
    
    @Override
    public void delete(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        promocao = em.getReference(Promocao.class, promocao.getId());
        tx.begin();
        em.remove(promocao);
        tx.commit();
        em.close();
    }
}
