package br.org.fatec.efol.controller;

import br.org.fatec.efol.impl.service.FolService;
import br.org.fatec.efol.model.fol.Fol;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins= "*")
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

    @PostMapping(value = "/remove/{id}")
    public Long remove(@PathVariable("id") Long id){
        return this.service.remove(id);
    }

    @GetMapping(value = "/importExcel")
    public Boolean importExcel() throws IOException, InvalidFormatException {
        return this.service.importFols();
    }
}
