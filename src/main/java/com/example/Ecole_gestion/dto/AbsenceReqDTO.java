package com.example.Ecole_gestion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AbsenceReqDTO {
    private Boolean estAbsent;
    private String justification;
    private Integer heuresAbsences;
    private Date dateAbsence;
    private Integer eleveId;

    public Integer getHeuresAbsences() {
        return heuresAbsences;
    }

    public void setHeuresAbsences(Integer heuresAbsences) {
        this.heuresAbsences = heuresAbsences;
    }

    public Integer getEleveId() {
        return eleveId;
    }

    public void setEleveId(Integer eleveId) {
        this.eleveId = eleveId;
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
