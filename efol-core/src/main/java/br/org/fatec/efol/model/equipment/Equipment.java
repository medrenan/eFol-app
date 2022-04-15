package br.org.fatec.efol.model.equipment;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EFOL_EQUIPMENT")
public class Equipment implements Serializable {

    private Long id;
    private String name;

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
}
