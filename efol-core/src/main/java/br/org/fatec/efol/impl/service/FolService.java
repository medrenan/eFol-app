package br.org.fatec.efol.impl.service;

import br.org.fatec.efol.impl.repository.FolRepository;
import br.org.fatec.efol.model.fol.Fol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FolService {

    @Autowired
    FolRepository repository;

    public Long create(Fol fol){
        if(fol == null) {
            return null;
        }

        // Validate necessary parameters
        this.validateInsertionParameters(fol);

        repository.persist(fol);

        return fol.getId();
    }

    public Long remove(Long id){
        if(id == null){
            return null;
        }

        this.repository.remove(id);
        return id;
    }

    public Fol find(Long id){
        if (id == null){
            return null;
        }

        return this.repository.findById(id);
    }

    public List<Fol> findAll(){
        return this.repository.findAll();
    }

    private void validateInsertionParameters(Fol fol) {
        if (fol.getEquipment() == null || fol.getCategory() == null || fol.getKeywordList() == null) {
            throw new RuntimeException("It's necessary to inform a valid Equipment, Category and Keywords");
        }
    }
}
