package com.example.Ecole_gestion.mapper;

import com.example.Ecole_gestion.dto.ParentReqDTO;
import com.example.Ecole_gestion.dto.ParentRespDTO;
import com.example.Ecole_gestion.entity.Eleve;
import com.example.Ecole_gestion.entity.Parent;
import org.springframework.stereotype.Component;

@Component
public class ParentMapper {

    public Parent toEntity(ParentReqDTO parentReqDTO){
        Parent parent = new Parent();
        parent.setNom(parentReqDTO.getNom());
        parent.setPrenom(parentReqDTO.getPrenom());
        parent.setSexe(parentReqDTO.getSexe());
        parent.setEmail(parentReqDTO.getEmail());
        parent.setTelephone(parentReqDTO.getTelephone());
        parent.setAdresse(parentReqDTO.getAdresse());

         if (parentReqDTO.getEleveId()!=null){
            Eleve eleve = new Eleve();
            eleve.setEleveId(parentReqDTO.getEleveId());
            parent.setEleve(eleve);
        }

        return parent;
    }

    public ParentRespDTO toDto(Parent parent){
        ParentRespDTO parentRespDTO = new ParentRespDTO();
        parentRespDTO.setParentId(parent.getParentId());
        parentRespDTO.setNom(parent.getNom());
        parentRespDTO.setPrenom(parent.getPrenom());
        parentRespDTO.setTelephone(parent.getTelephone());
        parentRespDTO.setSexe(parent.getSexe());
        parentRespDTO.setEmail(parent.getEmail());
        parentRespDTO.setAdresse(parent.getAdresse());

        if (parent.getEleve()!=null){
            parentRespDTO.setEleveId(parent.getEleve().getEleveId());
        }

        return parentRespDTO;
    }
}
