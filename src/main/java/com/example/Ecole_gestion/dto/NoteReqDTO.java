package com.example.Ecole_gestion.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class NoteReqDTO {
    @NotEmpty(message = "ce champ est obligatoire")
    private Float valeur;
    private String appreciation;

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
}
