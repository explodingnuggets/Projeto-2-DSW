package br.dsw.dao;

import br.dsw.pojo.SiteVendas;
import br.dsw.pojo.Teatro;
import br.dsw.pojo.Usuario;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

public class UsuarioDAO extends GenericDAO<Usuario, Long> {

    @Override
    public Usuario get(Long id) {
        EntityManager em = this.getEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();

        return usuario;
    }

    public Usuario get(String email, String senha) throws NoResultException {
        Usuario usuario = null;
        EntityManager em = this.getEntityManager();
        try {
            usuario = em.createNamedQuery("Usuario.findByEmailAndPassword", Usuario.class).setParameter("email", email).setParameter("senha", senha).getSingleResult();
        } catch (NoResultException e) {
            throw e;
        }
        return usuario;

    }

    public Usuario getByEmail(String email) throws NoResultException {
        Usuario usuario = new Usuario();
        usuario.setId(-1);
        EntityManager em = this.getEntityManager();
        try {
            usuario = em.createNamedQuery("Usuario.findByEmail", Usuario.class).setParameter("email", email).getSingleResult();
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
        try {
            em.persist(usuario);
            tx.commit();
        } catch (EntityExistsException e) {
            throw e;
        }
        em.close();
    }

    public void refresh(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        usuario = em.find(Usuario.class, usuario.getId());
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

    public Teatro getTeatro(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        Teatro teatro = null;
        try {
            teatro = em.createNamedQuery("Usuario.getTeatro", Teatro.class).setParameter("usuario", usuario).getSingleResult();
        } catch (NoResultException e) {

        }
        em.close();

        return teatro;
    }

    public SiteVendas getSiteVendas(Usuario usuario) {
        EntityManager em = this.getEntityManager();
        SiteVendas sv = null;
        try {
            sv = em.createNamedQuery("Usuario.getSiteVendas", SiteVendas.class).setParameter("usuario", usuario).getSingleResult();
        } catch (NoResultException e) {

        }
        em.close();

        return sv;
    }

    public List<Usuario> getAll() {
        EntityManager em = this.getEntityManager();
        List<Usuario> usuarios = em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
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
