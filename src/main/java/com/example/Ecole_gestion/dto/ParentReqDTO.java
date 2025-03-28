package com.example.Ecole_gestion.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ParentReqDTO {
    @NotEmpty(message = "ce champ est obligatoire")
    private String nom;
    @NotEmpty(message = "ce champ est obligatoire")
    private String sexe;
    private String prenom;
    private String email;
    @NotEmpty(message = "ce champ est obligatoire")
    private String telephone;
    @NotEmpty(message = "ce champ est obligatoire")
    private String adresse;
    private Integer eleveId;

    public Integer getEleveId() {
        return eleveId;
    }

    public void setEleveId(Integer eleveId) {
        this.eleveId = eleveId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
