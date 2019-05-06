package br.dsw.dao;

import br.dsw.pojo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class UsuarioDAO extends GenericDAO<Usuario> {
    @Override
    public Usuario get(long id) {
        EntityManager em = this.getEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        
        return usuario;
    }
    
    @Override
    public void save(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(usuario);
        tx.commit();
        em.close();
    }
    
    @Override
    public void update(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(usuario);
        tx.commit();
        em.close();
    }
    
    @Override
    public void delete(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        usuario = em.getReference(Usuario.class, usuario.getId());
        tx.begin();
        em.remove(usuario);
        tx.commit();
        em.close();
    }
    
    @Override
    public List<Usuario> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Usuario.findAll");
        List<Usuario> lista = q.getResultList();
        em.close();
        
        return lista;
    }
}
