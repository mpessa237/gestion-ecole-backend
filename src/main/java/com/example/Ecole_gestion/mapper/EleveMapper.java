package com.example.Ecole_gestion.mapper;

import com.example.Ecole_gestion.dto.EleveReqDTO;
import com.example.Ecole_gestion.dto.EleveRespDTO;
import com.example.Ecole_gestion.entity.Bulletin;
import com.example.Ecole_gestion.entity.Classe;
import com.example.Ecole_gestion.entity.Eleve;
import com.example.Ecole_gestion.entity.Parent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EleveMapper {

    public Eleve toEntity(EleveReqDTO eleveReqDTO){
        Eleve eleve = new Eleve();
        eleve.setNom(eleveReqDTO.getNom());
        eleve.setPrenom(eleveReqDTO.getPrenom());
        eleve.setSexe(eleveReqDTO.getSexe());
        eleve.setDateNaissance(eleveReqDTO.getDateNaissance());

        if (eleveReqDTO.getClasseId()!=null){
            Classe classe = new Classe();
            classe.setClasseId(eleveReqDTO.getClasseId());
            eleve.setClasse(classe);
        }
        return eleve;
    }

    public EleveRespDTO toDto(Eleve eleve){
        EleveRespDTO eleveRespDTO = new EleveRespDTO();
        eleveRespDTO.setEleveId(eleve.getEleveId());
        eleveRespDTO.setNom(eleve.getNom());
        eleveRespDTO.setPrenom(eleve.getPrenom());
        eleveRespDTO.setSexe(eleve.getSexe());
        eleveRespDTO.setDateNaissance(eleve.getDateNaissance());

        if (eleve.getClasse()!=null){
            eleveRespDTO.setClasseId(eleve.getClasse().getClasseId());
        }
        return eleveRespDTO;
    }
}
