package com.example.Ecole_gestion.dto;

import lombok.Data;

@Data
public class NoteRespDTO {
    private Integer noteId;
    private Float valeur;
    private String appreciation;

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
}
