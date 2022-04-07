package br.org.fatec.efol.controller;

import br.org.fatec.efol.impl.service.FolService;
import br.org.fatec.efol.model.fol.Fol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/fol", produces = "application/json;charest=UTF-8")
public class FolController {

    @Autowired
    FolService service;

    @PostMapping(value = "/create")
    public Long create(@RequestBody Fol fol){
        return this.service.create(fol);
    }

    @GetMapping(value = "/find/{id}")
    public Fol find(@PathVariable("id") Long id) {
        return this.service.find(id);
    }

    @GetMapping(value = "/findAll")
    public List<Fol> findAll(){
        return this.service.findAll();
    }

    @PostMapping(value = "remove/{id}")
    public Long remove(@PathVariable("id") Long id){
        return this.service.remove(id);
    }
}
