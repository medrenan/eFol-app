package br.org.fatec.efol.controller;

import br.org.fatec.efol.impl.service.EquipmentService;
import br.org.fatec.efol.model.equipment.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/equipment", produces = "application/json;charest=UTF-8")
public class EquipmentController {

    @Autowired
    EquipmentService service;

    @PostMapping(value = "/create")
    public Long create(@RequestBody Equipment equipment){
        return this.service.create(equipment);
    }

    @GetMapping(value = "/find/{id}")
    public Equipment find(@PathVariable("id") Long id) {
        return this.service.find(id);
    }

    @GetMapping(value = "/findAll")
    public List<Equipment> findAll(){
        return this.service.findAll();
    }

    @PostMapping(value = "remove/{id}")
    public Long remove(@PathVariable("id") Long id){
        return this.service.remove(id);
    }
}
