package com.fedi.equipe.equipe.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Ligue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLigue;

    private String nomLigue;
    private String pays;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "ligue")
    private List<Equipe> equipes;

    public Ligue() {
        super();
    }
    

    public Ligue(String nomLigue, String pays, String description, List<Equipe> equipes) {
        super();
        this.nomLigue = nomLigue;
        this.pays = pays;
        this.description = description;
        this.equipes = equipes;
    }

    public Long getIdLigue() {
        return idLigue;
    }

    public void setIdLigue(Long idLigue) {
        this.idLigue = idLigue;
    }

    public String getNomLigue() {
        return nomLigue;
    }

    public void setNomLigue(String nomLigue) {
        this.nomLigue = nomLigue;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }
}