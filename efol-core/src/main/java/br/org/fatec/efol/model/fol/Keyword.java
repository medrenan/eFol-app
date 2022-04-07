package br.org.fatec.efol.model.fol;

import javax.persistence.*;

@Entity
@Table(name = "EFOL_KEYWORD")
public class Keyword {

    private Long id;
    private String name;

    @Column(name = "NAME", nullable = false)
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
