package br.dsw.dao;

import br.dsw.pojo.Usuario;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

public class UsuarioDAO extends GenericDAO<Usuario> {

    @Override
    public Usuario get(long id) {
        EntityManager em = this.getEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();

        return usuario;
    }

    public Usuario get(String email, String senha) throws NoResultException {
        Usuario usuario = new Usuario();
        usuario.setId(-1);
        EntityManager em = this.getEntityManager();
        try {
            usuario = em.createNamedQuery("Usuario.findByEmailAndPassword", Usuario.class).setParameter("email", email).setParameter("senha", senha).getSingleResult();
        } catch (NoResultException e) {
            throw e;
        }
        return usuario;

    }

    @Override
    public void save(Usuario usuario) throws EntityExistsException {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
        em.persist(usuario);
        tx.commit();
        } catch(EntityExistsException e){
           throw e; 
        }
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

    public List<Usuario> getAll() {
        EntityManager em = this.getEntityManager();
        List<Usuario> usuarios = em.createQuery("SELECT * FROM Usuario", Usuario.class).getResultList();
        em.close();

        return usuarios;
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
}
