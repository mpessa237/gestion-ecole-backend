package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.MatiereReqDTO;
import com.example.Ecole_gestion.dto.MatiereRespDTO;
import com.example.Ecole_gestion.entity.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatiereService {
    MatiereRespDTO addMatiere(MatiereReqDTO matiereReqDTO);
    List<Matiere> getAllMatiere();
    MatiereRespDTO getMatiereById(Integer matiereId);
    MatiereRespDTO getMatiereByNom(String nom);
    Matiere updateMatiere(Matiere matiere,Integer matiereId);
    void deleteMatiereById(Integer matiereId);

}
