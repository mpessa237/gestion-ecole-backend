package com.example.Ecole_gestion.dto;

import lombok.Data;

@Data
public class ClasseRespDTO {
    private Integer classeId;
    private String nom;
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
}
