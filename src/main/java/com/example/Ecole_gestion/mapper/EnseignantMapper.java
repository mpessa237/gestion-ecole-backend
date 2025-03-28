package com.example.Ecole_gestion.mapper;

import com.example.Ecole_gestion.dto.EnseignantReqDTO;
import com.example.Ecole_gestion.dto.EnseignantRespDTO;
import com.example.Ecole_gestion.entity.Classe;
import com.example.Ecole_gestion.entity.Enseignant;
import org.springframework.stereotype.Component;

@Component
public class EnseignantMapper {

    public Enseignant toEntity(EnseignantReqDTO enseignantReqDTO) {
        Enseignant enseignant = new Enseignant();
        enseignant.setNom(enseignantReqDTO.getNom());
        enseignant.setPrenom(enseignantReqDTO.getPrenom());
        enseignant.setEmail(enseignantReqDTO.getEmail());
        enseignant.setTelephone(enseignantReqDTO.getTelephone());


        return enseignant;
    }

    public EnseignantRespDTO toDto(Enseignant enseignant) {
        EnseignantRespDTO enseignantRespDTO = new EnseignantRespDTO();
        enseignantRespDTO.setEnseignantId(enseignant.getEnseignantId());
        enseignantRespDTO.setNom(enseignant.getNom());
        enseignantRespDTO.setPrenom(enseignant.getPrenom());
        enseignantRespDTO.setEmail(enseignant.getEmail());
        enseignantRespDTO.setTelephone(enseignant.getTelephone());

        return enseignantRespDTO;
    }
}