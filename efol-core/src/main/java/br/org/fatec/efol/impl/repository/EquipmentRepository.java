package br.org.fatec.efol.impl.repository;

import br.org.fatec.efol.model.equipment.Equipment;
import org.springframework.stereotype.Repository;

@Repository
public class EquipmentRepository extends AbstractRepository<Equipment> {

    protected EquipmentRepository() {
        super(Equipment.class);
    }
}
