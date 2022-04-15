package br.org.fatec.efol.impl.repository;

import br.org.fatec.efol.model.fol.Keyword;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

@Repository
public class KeywordRepository extends AbstractRepository<Keyword> {

    protected KeywordRepository() {
        super(Keyword.class);
    }

    @PersistenceContext
    EntityManager em;

    public Keyword findByKeywordName(String keywordName) {
        Query query = this.em.createQuery("select k from Keyword k where k.name = :keywordName");
        query.setParameter("keywordName", keywordName);

        return QueryTyper.getPossibleSingleResult(query);
    }

    public List<Long> findIdsByKeywordsNames(Set<String> keywordsNames) {
        Query query = this.em.createQuery("select k from EFOL_KEYWORD k where k.name in :keywordsNames");
        query.setParameter("keywordsNames", keywordsNames);

        return QueryTyper.getResultList(query);
    }
}
