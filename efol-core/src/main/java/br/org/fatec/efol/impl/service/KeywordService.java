package br.org.fatec.efol.impl.service;

import br.org.fatec.efol.impl.repository.KeywordRepository;
import br.org.fatec.efol.model.fol.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KeywordService {

    @Autowired
    KeywordRepository repository;

    public Long create(Keyword keyword){
        if(keyword == null){
            return null;
        }

        this.repository.persist(keyword);

        return keyword.getId();
    }

    public Long remove(Long id){
        if(id == null){
            return null;
        }

        this.repository.remove(id);
        return id;
    }

    public Keyword find(Long id){
        if (id == null){
            return null;
        }

        return this.repository.findById(id);
    }

    public List<Keyword> findAll(){
        return this.repository.findAll();
    }
}
