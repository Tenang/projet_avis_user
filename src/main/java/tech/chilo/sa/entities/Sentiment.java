package tech.chilo.sa.entities;

import jakarta.persistence.*;
import tech.chilo.sa.enums.TypeSentiment;

@Entity
@Table(name = "SENTIMENT")
public class Sentiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String texte ;

    private TypeSentiment type;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="CLIENT_ID")
    private Client client;

    public Sentiment() {
    }

    public Sentiment(int id, String texte, TypeSentiment type, Client client) {
        this.id = id;
        this.texte = texte;
        type = type;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public TypeSentiment getType() {
        return type;
    }

    public void setType(TypeSentiment type) {
        type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
