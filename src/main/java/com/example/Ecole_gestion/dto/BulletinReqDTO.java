package com.example.Ecole_gestion.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Date;

@Data
public class BulletinReqDTO {
    private Date dateRemise;
    @NotEmpty(message = "ce champ est obligatoire")
    private Float moyenne;
    @NotEmpty(message = "ce champ est obligatoire")

    private String appreciaton;

    public Date getDateRemise() {
        return dateRemise;
    }

    public void setDateRemise(Date dateRemise) {
        this.dateRemise = dateRemise;
    }

    public Float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(Float moyenne) {
        this.moyenne = moyenne;
    }

    public String getAppreciaton() {
        return appreciaton;
    }

    public void setAppreciaton(String appreciaton) {
        this.appreciaton = appreciaton;
    }
}
