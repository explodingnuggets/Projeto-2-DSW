package br.dsw.dao;

import br.dsw.pojo.Promocao;
import br.dsw.pojo.SiteVendas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class SiteVendasDAO extends GenericDAO<SiteVendas> {
    @Override
    public SiteVendas get(long id) {
        EntityManager em = this.getEntityManager();
        SiteVendas site = em.find(SiteVendas.class, id);
        em.close();
        
        return site;
    }
    
    @Override
    public void save(SiteVendas site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(site);
        tx.commit();
        em.close();
    }
    
    @Override
    public void update(SiteVendas site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(site);
        tx.commit();
        em.close();
    }
         @Override
     public List<SiteVendas> getAll() {
        EntityManager em = this.getEntityManager();
        List<SiteVendas> siteVendas = em.createNamedQuery("SiteVendas.findAll", SiteVendas.class).getResultList();
        
        em.close();
      
        return siteVendas;
    }
    
    @Override
    public void delete(SiteVendas site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        site = em.getReference(SiteVendas.class, site.getId());
        tx.begin();
        em.remove(site);
        tx.commit();
        em.close();
    }
}
