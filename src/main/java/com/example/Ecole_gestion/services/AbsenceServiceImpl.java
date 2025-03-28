package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.AbsenceReqDTO;
import com.example.Ecole_gestion.dto.AbsenceRespDTO;
import com.example.Ecole_gestion.entity.Absence;
import com.example.Ecole_gestion.exception.RessourceNotFoundException;
import com.example.Ecole_gestion.mapper.AbsenceMapper;
import com.example.Ecole_gestion.repository.AbsenceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbsenceServiceImpl implements AbsenceService{
    private final AbsenceRepo absenceRepo;
    private final AbsenceMapper absenceMapper;

    public AbsenceServiceImpl(AbsenceRepo absenceRepo, AbsenceMapper absenceMapper) {
        this.absenceRepo = absenceRepo;
        this.absenceMapper = absenceMapper;
    }

    @Override
    public AbsenceRespDTO addAbsence(AbsenceReqDTO absenceReqDTO) {
        Absence absence = this.absenceMapper.toEntity(absenceReqDTO);

        Absence addAbsence = this.absenceRepo.save(absence);

        return this.absenceMapper.toDto(addAbsence);
    }

    @Override
    public List<Absence> getAllAbsence() {
        return this.absenceRepo.findAll();
    }

    @Override
    public AbsenceRespDTO getAbsenceById(Integer absenceId) {
        Absence absence = this.absenceRepo.findById(absenceId)
                .orElseThrow(()-> new RessourceNotFoundException("absent not found!!"));

        return this.absenceMapper.toDto(absence);

    }

    @Override
    public Absence updateAbsenceById(Absence absence, Integer absenceId) {
        Optional<Absence> absenceOptional = this.absenceRepo.findById(absenceId);
        if (absenceOptional.isEmpty())
            throw new RessourceNotFoundException("absent not found!!");
        if (absence.getJustification()!=null)
            absenceOptional.get().setJustification(absence.getJustification());
        if (absence.getDateAbsence()!=null)
            absenceOptional.get().setDateAbsence(absence.getDateAbsence());
        if (absence.getEstAbsent()!=null)
            absenceOptional.get().setEstAbsent(absence.getEstAbsent());

        return this.absenceRepo.saveAndFlush(absenceOptional.get());
    }

    @Override
    public void deleteAbsence(Integer absenceId) {
        this.absenceRepo.delete(this.absenceRepo.findById(absenceId)
                .orElseThrow(()-> new RessourceNotFoundException("absent not found!!")));
    }
}
