package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.EleveReqDTO;
import com.example.Ecole_gestion.dto.EleveRespDTO;
import com.example.Ecole_gestion.entity.Eleve;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EleveService {
    EleveRespDTO addEleve(EleveReqDTO eleveReqDTO);
    Page<EleveRespDTO> pagination(int offset, int pageSize);
    List<Eleve> getAllEleve();
    Eleve getEleveByNom(String nom);
    EleveRespDTO getEleveById(Integer eleveId);
    Eleve updateEleveById(Eleve eleve,Integer eleveId);
    void deleteEleveById(Integer eleveId);
}
