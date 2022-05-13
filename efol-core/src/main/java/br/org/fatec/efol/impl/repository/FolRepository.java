package br.org.fatec.efol.impl.repository;

import br.org.fatec.efol.model.fol.Fol;
import br.org.fatec.efol.model.fol.Keyword;
import br.org.fatec.efol.model.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class FolRepository extends AbstractRepository<Fol> {

    protected FolRepository() {
        super(Fol.class);
    }

    public List<Fol> findByKeyword(Keyword keyword){
        Query query = this.getEm().createQuery("SELECT f FROM Fol f JOIN f.keywords k WHERE k.id = :keywordId");
        query.setParameter("keywordId", keyword.getId());

        return QueryTyper.getResultList(query);
    }
}
