package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.EnseignantReqDTO;
import com.example.Ecole_gestion.dto.EnseignantRespDTO;
import com.example.Ecole_gestion.entity.Enseignant;

import java.util.List;

public interface EnseignantService {
    EnseignantRespDTO addEnseignant(EnseignantReqDTO enseignantReqDTO);
    List<Enseignant> getAllEnseignant();
    EnseignantRespDTO getEnseignantById(Integer enseignantId);
    Enseignant updateEnseignant(Enseignant enseignant,Integer enseignantId);
    void deleteEnseignantById(Integer enseignantId);
}
