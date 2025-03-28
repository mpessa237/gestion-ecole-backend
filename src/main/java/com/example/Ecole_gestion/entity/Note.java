package com.example.Ecole_gestion.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "note")
public class Note {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noteId;
    private Float valeur;
    private String appreciation;
    @ManyToOne
    private Eleve eleve;

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Float getValeur() {
        return valeur;
    }

    public void setValeur(Float valeur) {
        this.valeur = valeur;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }
}
