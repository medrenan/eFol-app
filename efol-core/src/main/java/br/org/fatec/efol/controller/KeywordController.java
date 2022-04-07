package br.org.fatec.efol.controller;

import br.org.fatec.efol.impl.service.KeywordService;
import br.org.fatec.efol.model.fol.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/keyword", produces = "application/json;charest=UTF-8")
public class KeywordController {

    @Autowired
    KeywordService service;

    @PostMapping(value = "/create")
    public Long create(@RequestBody Keyword keyword){
        return this.service.create(keyword);
    }

    @GetMapping(value = "/find/{id}")
    public Keyword find(@PathVariable("id") Long id) {
        return this.service.find(id);
    }

    @GetMapping(value = "/findAll")
    public List<Keyword> findAll(){
        return this.service.findAll();
    }

    @PostMapping(value = "remove/{id}")
    public Long remove(@PathVariable("id") Long id){
        return this.service.remove(id);
    }
}
