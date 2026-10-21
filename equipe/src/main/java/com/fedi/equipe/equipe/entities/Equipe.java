package com.fedi.equipe.equipe.entities;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;

    private String nomEquipe;
    private Double pointsEquipe;
    private String ville;
    private Integer nombreJoueurs;
    private Double budget;
    private Boolean active;

 
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date dateCreation;

    @ManyToOne
    private Ligue ligue;

    public Equipe() {
        super();
    }

    public Equipe(String nomEquipe, Double pointsEquipe, Date dateCreation) {
        super();
        this.nomEquipe = nomEquipe;
        this.pointsEquipe = pointsEquipe;
        this.dateCreation = dateCreation;
    }

    public Equipe(String nomEquipe, String ville, Integer nombreJoueurs,
                  Double budget, Boolean active, Date dateCreation) {
        super();
        this.nomEquipe = nomEquipe;
        this.ville = ville;
        this.nombreJoueurs = nombreJoueurs;
        this.budget = budget;
        this.active = active;
        this.dateCreation = dateCreation;
    }

    public Long getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public Double getPointsEquipe() {
        return pointsEquipe;
    }

    public void setPointsEquipe(Double pointsEquipe) {
        this.pointsEquipe = pointsEquipe;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getNombreJoueurs() {
        return nombreJoueurs;
    }

    public void setNombreJoueurs(Integer nombreJoueurs) {
        this.nombreJoueurs = nombreJoueurs;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Ligue getLigue() {
        return ligue;
    }

    public void setLigue(Ligue ligue) {
        this.ligue = ligue;
    }

   
    @Override
    public String toString() {
        return "Equipe [idEquipe=" + idEquipe
                + ", nomEquipe=" + nomEquipe
                + ", ville=" + ville
                + ", nombreJoueurs=" + nombreJoueurs
                + ", budget=" + budget
                + ", active=" + active
                + ", dateCreation=" + dateCreation
                + ", ligue=" + (ligue != null ? ligue.getNomLigue() : "aucune")
                + "]";
    }
}