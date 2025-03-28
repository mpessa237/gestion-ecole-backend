package com.example.Ecole_gestion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "matiere")
public class Matiere {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
