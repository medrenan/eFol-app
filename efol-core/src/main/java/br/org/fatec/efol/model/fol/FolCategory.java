package br.org.fatec.efol.model.fol;

import javax.persistence.*;

@Entity
@Table(name = "EFOL_FOL_CATEGORY")
public class FolCategory {

    private Long id;
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
