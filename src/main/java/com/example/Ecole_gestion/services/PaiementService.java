package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.PaiementReqDTO;
import com.example.Ecole_gestion.dto.PaiementRespDTO;
import com.example.Ecole_gestion.entity.Paiement;

import java.util.List;

public interface PaiementService {
    PaiementRespDTO addPaiement(PaiementReqDTO paiementReqDTO);
    List<Paiement> getAllPaiement();
    PaiementRespDTO getPaiementById(Integer paiementId);
    Paiement updatePaiement(Paiement paiement,Integer paiementId);
    void deletePaiement(Integer paiementId);
}
