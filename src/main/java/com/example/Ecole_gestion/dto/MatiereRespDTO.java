package com.example.Ecole_gestion.dto;

import lombok.Data;

@Data
public class MatiereRespDTO {
    private Integer matiereId;
    private String nom;
    private Integer coefficient;

    public Integer getMatiereId() {
        return matiereId;
    }

    public void setMatiereId(Integer matiereId) {
        this.matiereId = matiereId;
    }

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
