package com.example.Ecole_gestion.mapper;

import com.example.Ecole_gestion.dto.AbsenceReqDTO;
import com.example.Ecole_gestion.dto.AbsenceRespDTO;
import com.example.Ecole_gestion.entity.Absence;
import com.example.Ecole_gestion.entity.Eleve;
import com.example.Ecole_gestion.entity.Parent;
import org.springframework.stereotype.Component;

@Component
public class AbsenceMapper {

    public Absence toEntity(AbsenceReqDTO absenceReqDTO){
        Absence absence = new Absence();

        absence.setDateAbsence(absenceReqDTO.getDateAbsence());
        absence.setJustification(absenceReqDTO.getJustification());
        absence.setHeuresAbsences(absenceReqDTO.getHeuresAbsences());
        absence.setEstAbsent(absenceReqDTO.getEstAbsent());

        if (absenceReqDTO.getEleveId()!=null){
            Eleve eleve = new Eleve();
            eleve.setEleveId(absenceReqDTO.getEleveId());
            absence.setEleve(eleve);
        }
        return absence;
    }

    public AbsenceRespDTO toDto(Absence absence){
        AbsenceRespDTO absenceRespDTO = new AbsenceRespDTO();
        absenceRespDTO.setAbsenceId(absence.getAbsenceId());
        absenceRespDTO.setDateAbsence(absence.getDateAbsence());
        absenceRespDTO.setHeuresAbsences(absence.getHeuresAbsences());
        absenceRespDTO.setJustification(absence.getJustification());
        absenceRespDTO.setEstAbsent(absence.getEstAbsent());

        if (absence.getEleve()!=null){
            absenceRespDTO.setEleveId(absence.getEleve().getEleveId());
        }
        return absenceRespDTO;
    }
}
