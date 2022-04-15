package br.org.fatec.efol.impl.service;

import br.org.fatec.efol.impl.repository.EquipmentRepository;
import br.org.fatec.efol.model.equipment.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EquipmentService {

    @Autowired
    EquipmentRepository repository;

    public Long create(Equipment equipment){
        if(equipment == null){
            return null;
        }

        this.repository.persist(equipment);

        return equipment.getId();
    }

    public Long remove(Long id){
        if(id == null){
            return null;
        }

        this.repository.remove(id);
        return id;
    }

    public Equipment find(Long id){
        if (id == null){
            return null;
        }

        return this.repository.findById(id);
    }

    public List<Equipment> findAll(){
        return this.repository.findAll();
    }
}
