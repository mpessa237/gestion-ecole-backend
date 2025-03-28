package com.example.Ecole_gestion.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EnseignantReqDTO {
    @NotEmpty(message = "ce champ est obligatoire")
    private String nom;
    private String prenom;
    private String email;
    @NotEmpty(message = "ce champ est obligatoire")
    private String telephone;

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
}
