package com.example.Ecole_gestion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AbsenceRespDTO {
    private Integer absenceId;
    private Boolean estAbsent;
    private String justification;
    private Date dateAbsence;
    private Integer eleveId;

    public Integer getEleveId() {
        return eleveId;
    }

    public void setEleveId(Integer eleveId) {
        this.eleveId = eleveId;
    }

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
}
