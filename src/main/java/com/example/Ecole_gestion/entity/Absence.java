package com.example.Ecole_gestion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "absence")
public class Absence {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer absenceId;
    private Boolean estAbsent;
    private String justification;
    private Date dateAbsence;
    @ManyToOne
    @JoinColumn(name = "eleve_id")
    private Eleve eleve;

    public Integer getAbsenceId() {
        return absenceId;
    }

    public void setAbsenceId(Integer absenceId) {
        this.absenceId = absenceId;
    }

    public Boolean getEstAbsent() {
        return estAbsent;
    }

    public void setEstAbsent(Boolean estAbsent) {
        this.estAbsent = estAbsent;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public Date getDateAbsence() {
        return dateAbsence;
    }

    public void setDateAbsence(Date dateAbsence) {
        this.dateAbsence = dateAbsence;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }
}
