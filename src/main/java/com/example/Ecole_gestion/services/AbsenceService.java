package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.AbsenceReqDTO;
import com.example.Ecole_gestion.dto.AbsenceRespDTO;
import com.example.Ecole_gestion.entity.Absence;

import java.util.List;

public interface AbsenceService {
    AbsenceRespDTO addAbsence(AbsenceReqDTO absenceReqDTO);
    List<Absence> getAllAbsence();
    AbsenceRespDTO getAbsenceById(Integer absenceId);
    Absence updateAbsenceById(Absence absence,Integer absenceId);
    void deleteAbsence(Integer absenceId);
}
