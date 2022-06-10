package br.org.fatec.efol.impl.service;

import br.org.fatec.efol.impl.repository.FolRepository;
import br.org.fatec.efol.model.fol.Fol;
import br.org.fatec.efol.model.fol.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FolSearchService {

    @Autowired
    FolRepository repository;

    public Fol find(Long id){
        if (id == null){
            return null;
        }

        return this.repository.findById(id);
    }

    public List<Fol> findByKeyword(List<Keyword> keywords){
        if(keywords == null){
            return null;
        }

        return this.repository.findByKeyword(keywords);
    }

    public List<Fol> findAll(){
        return this.repository.findAll();
    }
}
