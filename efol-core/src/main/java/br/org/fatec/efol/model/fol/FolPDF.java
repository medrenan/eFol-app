package br.org.fatec.efol.model.fol;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EFOL_FOL_PDF")
public class FolPDF implements Serializable {

    private Long id;
    private String name;
    private Long size;
    private byte[] data;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "size")
    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Column(name = "data")
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
