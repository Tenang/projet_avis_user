package tech.chilo.sa.entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String email;

    private String telephone;
    @Column(name = "creation")
    private Date creation;
    @Column(name = "mis_a_jour")
    private Date misAjour;



    public Client() {
    }

    public Client(int id, String email, String telephone, Date creation, Date misAjour) {
        this.id = id;
        this.email = email;
        this.telephone = telephone;
        this.creation = creation;
        this.misAjour = misAjour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getMisAjour() {
        return misAjour;
    }

    public void setMisAjour(Date misAjour) {
        this.misAjour = misAjour;
    }
}
