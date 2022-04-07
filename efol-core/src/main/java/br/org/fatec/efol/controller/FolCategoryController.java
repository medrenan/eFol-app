package br.org.fatec.efol.controller;

import br.org.fatec.efol.impl.service.FolCategoryService;
import br.org.fatec.efol.model.fol.FolCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "folCategory", produces = "application/json;charest=UTF-8")
public class FolCategoryController {

    @Autowired
    FolCategoryService service;

    @PostMapping(value = "/create")
    public Long create(@RequestBody FolCategory folCategory){
        return this.service.create(folCategory);
    }

    @GetMapping(value = "/find/{id}")
    public FolCategory find(@PathVariable("id") Long id) {
        return this.service.find(id);
    }

    @GetMapping(value = "/findAll")
    public List<FolCategory> findAll(){
        return this.service.findAll();
    }

    @PostMapping(value = "remove/{id}")
    public Long remove(@PathVariable("id") Long id){
        return this.service.remove(id);
    }
}
