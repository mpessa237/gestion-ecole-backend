package com.example.Ecole_gestion.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Date;

@Data
public class EleveReqDTO {
    @NotEmpty(message = "ce champ est obligatoire")
    private String nom;
    private String prenom;
    @NotEmpty(message = "ce champ est obligatoire")
    private String sexe;
    private Date dateNaissance;
    private Integer classeId;

    public Integer getClasseId() {
        return classeId;
    }

    public void setClasseId(Integer classeId) {
        this.classeId = classeId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
