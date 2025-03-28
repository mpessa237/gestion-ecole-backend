package com.example.Ecole_gestion.mapper;

import com.example.Ecole_gestion.dto.ClasseReqDTO;
import com.example.Ecole_gestion.dto.ClasseRespDTO;
import com.example.Ecole_gestion.entity.Classe;
import com.example.Ecole_gestion.entity.Enseignant;
import org.springframework.stereotype.Component;

@Component
public class ClasseMapper {

    public Classe toEntity(ClasseReqDTO classeReqDTO){

        Classe classe = new Classe();
        classe.setNom(classeReqDTO.getNom());

        return classe;
    }

    public ClasseRespDTO toDto(Classe classe){
        ClasseRespDTO classeRespDTO = new ClasseRespDTO();

        classeRespDTO.setClasseId(classe.getClasseId());
        classeRespDTO.setNom(classe.getNom());

        return classeRespDTO;
    }
}
