package com.example.Ecole_gestion.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "eleve")
public class Eleve {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eleveId;
    private String nom;
    private String prenom;
    private String sexe;
    private Date dateNaissance;
    @ManyToOne
    private Parent parent;
    @OneToMany
    private List<Paiement> paiements = new ArrayList<>();
    @OneToMany(mappedBy = "eleve",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Bulletin> bulletins = new ArrayList<>();
    @OneToMany
    private List<Absence> absences = new ArrayList<>();
    @OneToMany
    private List<Note> notes = new ArrayList<>();
    @ManyToOne
    private Classe classe;
    //methode pour definir le nombre d'absence
    public int getNombreAbsences(){
        if (absences==null){
            return 0;
        }
        return (int) absences.stream().filter(absence -> absence.getEstAbsent()!=null && absence.getEstAbsent()).count();
    }

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

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }

    public List<Bulletin> getBulletins() {
        return bulletins;
    }

    public void setBulletins(List<Bulletin> bulletins) {
        this.bulletins = bulletins;
    }

    public List<Absence> getPresences() {
        return absences;
    }

    public void setPresences(List<Absence> presences) {
        this.absences = presences;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }


}
