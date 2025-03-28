package com.example.Ecole_gestion.entity;

import com.example.Ecole_gestion.dto.EnseignantReqDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "enseignant")
public class Enseignant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enseignantId;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    @OneToMany
    private List<Enseignant> enseignants = new ArrayList<>();
    @OneToMany
    private List<Classe> classes = new ArrayList<>();

    public Integer getEnseignantId() {
        return enseignantId;
    }

    public void setEnseignantId(Integer enseignantId) {
        this.enseignantId = enseignantId;
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

    public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(List<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses() {
        this.classes = classes;
    }


}
