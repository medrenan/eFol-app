package br.org.fatec.efol.impl.service;

import br.org.fatec.efol.impl.repository.FolCategoryRepository;
import br.org.fatec.efol.model.fol.FolCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FolCategoryService {

    @Autowired
    FolCategoryRepository repository;

    public Long create(FolCategory folCategory){
        if(folCategory == null) {
            return null;
        }

        this.repository.persist(folCategory);

        return folCategory.getId();
    }

    public Long remove(Long id){
        if(id == null){
            return null;
        }

        this.repository.remove(id);
        return id;
    }

    public FolCategory find(Long id){
        if (id == null){
            return null;
        }

        return this.repository.findById(id);
    }

    public List<FolCategory> findAll(){
        return this.repository.findAll();
    }
}
