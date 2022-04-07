package br.org.fatec.efol.impl.repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

public abstract class AbstractRepository<ENTITY> {

    protected Class<ENTITY> entityClass;

    @PersistenceContext
    private EntityManager em;

    protected AbstractRepository(Class<ENTITY> entityClass) {
        this.entityClass = entityClass;
    }

    public void persist(ENTITY entity){
        this.em.persist(entity);
    }

    public ENTITY findById(Long id){
        return this.em.find(this.entityClass, id);
    }

    public List<ENTITY> findAll() {
        Query query = em.createQuery("SELECT e FROM " + this.entityClass.getSimpleName() + " e");
        return query.getResultList();
    }

    public ENTITY getReference(Long id){
        try {
            Query query = this.em.createQuery("SELECT id FROM " + this.entityClass.getSimpleName() + " e WHERE e.id = :id");
            query.setParameter("id", id);
            query.getSingleResult();
        } catch (NoResultException e) {
            String entityName = entityClass.getSimpleName();
            throw new EntityNotFoundException("Cannot find " + entityName + " with id " + id);
        }
        ENTITY reference = this.em.getReference(this.entityClass, id);
        return reference;
    }

    @Transactional
    public void remove(Long id){
        ENTITY reference = this.getReference(id);
        this.em.remove(reference);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
