package com.example.Ecole_gestion.mapper;

import com.example.Ecole_gestion.dto.MatiereReqDTO;
import com.example.Ecole_gestion.dto.MatiereRespDTO;
import com.example.Ecole_gestion.entity.Matiere;
import org.springframework.stereotype.Component;

@Component
public class MatiereMapper {

    public Matiere toEntity(MatiereReqDTO matiereReqDTO){
        Matiere matiere = new Matiere();
        matiere.setNom(matiereReqDTO.getNom());
        matiere.setCoefficient(matiereReqDTO.getCoefficient());
        return matiere;
    }

    public MatiereRespDTO toDto(Matiere matiere){
        MatiereRespDTO matiereRespDTO = new MatiereRespDTO();
        matiereRespDTO.setMatiereId(matiere.getMatiereId());
        matiereRespDTO.setNom(matiere.getNom());
        matiereRespDTO.setCoefficient(matiere.getCoefficient());
        return matiereRespDTO;
    }
}
