package br.org.fatec.efol.impl.repository;

import br.org.fatec.efol.model.fol.FolCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class FolCategoryRepository extends AbstractRepository<FolCategory> {

    protected FolCategoryRepository() {
        super(FolCategory.class);
    }

    @PersistenceContext
    EntityManager em;

    public FolCategory findByFolCategoryName(String categoryName){
        Query query = this.em.createQuery("select c from FolCategory c where c.name = :categoryName");
        query.setParameter("categoryName", categoryName);

        return QueryTyper.getPossibleSingleResult(query);
    }
}
