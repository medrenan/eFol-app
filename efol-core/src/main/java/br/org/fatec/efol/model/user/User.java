package br.org.fatec.efol.model.user;

import br.org.fatec.efol.model.equipment.Equipment;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EFOL_USER")
public class User {

    private Long id;
    private String username;
    private String login;
    private String password;
    private List<Equipment> equipment;

    @Column(name = "USERNAME", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "LOGIN", nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "PASSWORD", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany
    @JoinTable(name = "EFOL_USER_EQUIPMENT", joinColumns = {
            @JoinColumn(name = "USER_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "EQUIPMENT_ID")})
    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
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
