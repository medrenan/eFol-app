package br.org.fatec.efol.impl.repository;

import br.org.fatec.efol.model.equipment.Equipment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class EquipmentRepository extends AbstractRepository<Equipment> {

    protected EquipmentRepository() {
        super(Equipment.class);
    }
    
    @PersistenceContext
    EntityManager em;
    
    public Equipment findByEquipmentName(String equipName) {
        Query query = this.em.createQuery("select e from Equipment e where e.name = :equipName");
        query.setParameter("equipName", equipName);

       return QueryTyper.getPossibleSingleResult(query);
    }
}
