package com.example.Ecole_gestion.dto;

import com.example.Ecole_gestion.entity.TypePaiement;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaiementRespDTO {
    private Integer paiementId;
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

    public Integer getPaiementId() {
        return paiementId;
    }

    public void setPaiementId(Integer paiementId) {
        this.paiementId = paiementId;
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
