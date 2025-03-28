package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.ClasseReqDTO;
import com.example.Ecole_gestion.dto.ClasseRespDTO;
import com.example.Ecole_gestion.entity.Classe;

import java.util.List;

public interface ClasseService {
    ClasseRespDTO addClasse(ClasseReqDTO classeReqDTO);
    List<Classe> getAllClasse();
    ClasseRespDTO getClasseById(Integer classeId);
    Classe getClasseByNom(String nom);
    Classe updateClasseById(Classe classe,Integer classeId);
    void deleteClasseById(Integer classeId);
}
