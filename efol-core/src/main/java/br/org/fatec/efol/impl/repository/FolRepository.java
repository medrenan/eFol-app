package br.org.fatec.efol.impl.repository;

import br.org.fatec.efol.model.fol.Fol;
import org.springframework.stereotype.Repository;

@Repository
public class FolRepository extends AbstractRepository<Fol> {

    protected FolRepository() {
        super(Fol.class);
    }
}
