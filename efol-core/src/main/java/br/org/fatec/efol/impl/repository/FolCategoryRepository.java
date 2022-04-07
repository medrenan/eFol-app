package br.org.fatec.efol.impl.repository;

import br.org.fatec.efol.model.fol.FolCategory;
import org.springframework.stereotype.Repository;

@Repository
public class FolCategoryRepository extends AbstractRepository<FolCategory> {

    protected FolCategoryRepository() {
        super(FolCategory.class);
    }
}
