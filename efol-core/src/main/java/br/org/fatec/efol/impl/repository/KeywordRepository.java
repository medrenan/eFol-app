package br.org.fatec.efol.impl.repository;

import br.org.fatec.efol.model.fol.Keyword;
import org.springframework.stereotype.Repository;

@Repository
public class KeywordRepository extends AbstractRepository<Keyword> {

    protected KeywordRepository() {
        super(Keyword.class);
    }
}
