package br.dsw.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO<T> {
    private final EntityManagerFactory emf;
    
    public GenericDAO() {
        emf = Persistence.createEntityManagerFactory("DSWPU");
    }
    
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    abstract T get(long id);
    abstract void save(T t);
    abstract void update(T t);
    abstract void delete(T t);
}
