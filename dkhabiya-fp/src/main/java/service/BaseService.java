/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Abstract BaseService class
 * @author D
 * @param <T>
 */
public abstract class BaseService<T> {
    
    private final Class<T> entityClass;
    
    @PersistenceContext(unitName = "dkhabiyaPU")
    private EntityManager em;
    
    /**
     * Getting an entity manager instance
     * @return
     */
    public EntityManager getEntityManager() {
        return em;
    }
    
    /**
     * BaseService default constructor
     * @param entityClass
     */
    protected BaseService(Class entityClass) {
        this.entityClass = entityClass;
    }
    
    /**
     * Create operation
     * @param entity
     */
    public void create(T entity){
        em.persist(entity);
    }

    /**
     * Read operation
     * @param id
     * @return
     */
    public T find(Object id){
        return em.find(entityClass, id);
    }
    
    /**
     *
     * @param <T>
     * @param entityClass
     * @param id
     * @return
     */
    public <T> T read(Class<T> entityClass, Object id){
        return em.find(entityClass, id);
    }
    
    /**
     * Abstract method findAll to execute named queries
     * @return
     */
    public abstract List<T> findAll();
    
    /**
     * Update operation
     * @param entity
     */
    public void update(T entity){
        em.merge(entity);
    }
    
    /**
     * Delete operation
     * @param entity
     */
    public void delete(T entity){
        em.remove(em.merge(entity));
    }
}
