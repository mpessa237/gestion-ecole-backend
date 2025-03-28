package com.example.Ecole_gestion.mapper;

import com.example.Ecole_gestion.dto.PaiementReqDTO;
import com.example.Ecole_gestion.dto.PaiementRespDTO;
import com.example.Ecole_gestion.entity.Eleve;
import com.example.Ecole_gestion.entity.Paiement;
import com.example.Ecole_gestion.entity.Parent;
import org.springframework.stereotype.Component;

@Component
public class PaiementMapper {

    public Paiement toEntity(PaiementReqDTO paiementReqDTO){
        Paiement paiement = new Paiement();
        paiement.setMontant(paiementReqDTO.getMontant());
        paiement.setDatePaiement(paiementReqDTO.getDatePaiement());
        paiement.setTypePaiement(paiementReqDTO.getTypePaiement());

        if (paiementReqDTO.getEleveId()!=null){
            Eleve eleve = new Eleve();
            eleve.setEleveId(paiementReqDTO.getEleveId());
            paiement.setEleve(eleve);
        }
        return paiement;
    }

    public PaiementRespDTO toDto(Paiement paiement){
        PaiementRespDTO paiementRespDTO = new PaiementRespDTO();
        paiementRespDTO.setPaiementId(paiement.getPaiementId());
        paiementRespDTO.setDatePaiement(paiement.getDatePaiement());
        paiementRespDTO.setTypePaiement(paiement.getTypePaiement());
        paiementRespDTO.setMontant(paiement.getMontant());

        if (paiement.getEleve()!=null){
            paiementRespDTO.setEleveId(paiement.getEleve().getEleveId());
        }
        return paiementRespDTO;
    }
}
