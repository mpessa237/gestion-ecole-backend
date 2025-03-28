package com.example.Ecole_gestion.dto;

import lombok.Data;

@Data
public class MatiereReqDTO {
    private String nom;
    private Integer coefficient;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }
}
