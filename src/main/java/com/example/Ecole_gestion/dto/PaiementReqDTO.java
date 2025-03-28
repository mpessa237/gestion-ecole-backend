package com.example.Ecole_gestion.dto;

import com.example.Ecole_gestion.entity.TypePaiement;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class PaiementReqDTO {
    @NotEmpty(message = "ce champ est obligatoire")
    private Float montant;
    private LocalDateTime datePaiement;
    private TypePaiement typePaiement;
    private Integer eleveId;

    public Integer getEleveId() {
        return eleveId;
    }

    public void setEleveId(Integer eleveId) {
        this.eleveId = eleveId;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDateTime datePaiement) {
        this.datePaiement = datePaiement;
    }

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }
}
