package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.EnseignantReqDTO;
import com.example.Ecole_gestion.dto.EnseignantRespDTO;
import com.example.Ecole_gestion.entity.Enseignant;
import com.example.Ecole_gestion.exception.RessourceNotFoundException;
import com.example.Ecole_gestion.mapper.EnseignantMapper;
import com.example.Ecole_gestion.repository.EnseignantRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnseignantServiceImpl implements EnseignantService{
    private final EnseignantRepo enseignantRepo;
    private final EnseignantMapper enseignantMapper;

    public EnseignantServiceImpl(EnseignantRepo enseignantRepo, EnseignantMapper enseignantMapper) {
        this.enseignantRepo = enseignantRepo;
        this.enseignantMapper = enseignantMapper;
    }

    @Override
    public EnseignantRespDTO addEnseignant(EnseignantReqDTO enseignantReqDTO) {
        if (!EmailValidation.isValidEmail(enseignantReqDTO.getEmail())) {
            throw new IllegalArgumentException("L'email est invalide. L'email doit contenir un '@' et se terminer par '.com'.");
        }
        Enseignant enseignant = enseignantMapper.toEntity(enseignantReqDTO);
        Enseignant addEnseignant = enseignantRepo.save(enseignant);
        return enseignantMapper.toDto(addEnseignant);
    }
    @Override
    public List<Enseignant> getAllEnseignant() {
        return this.enseignantRepo.findAll();
    }

    @Override
    public EnseignantRespDTO getEnseignantById(Integer enseignantId) {
        Enseignant enseignant = enseignantRepo.findById(enseignantId)
                .orElseThrow(()-> new RessourceNotFoundException("teacher not found!"));
        return this.enseignantMapper.toDto(enseignant);
    }

    @Override
    public Enseignant updateEnseignant(Enseignant enseignant, Integer enseignantId) {
        Optional<Enseignant> enseignantOptional = this.enseignantRepo.findById(enseignantId);
        if (enseignantOptional.isEmpty())
            throw new RessourceNotFoundException("teacher not found!");

        if (enseignant.getNom()!=null)
            enseignantOptional.get().setNom(enseignant.getNom());
        if (enseignant.getPrenom()!=null)
            enseignantOptional.get().setPrenom(enseignant.getPrenom());
        if (enseignant.getTelephone()!=null)
            enseignantOptional.get().setTelephone(enseignant.getTelephone());
        if (enseignant.getEmail()!=null)
            enseignantOptional.get().setEmail(enseignant.getEmail());

        return this.enseignantRepo.saveAndFlush(enseignantOptional.get());
    }

    @Override
    public void deleteEnseignantById(Integer enseignantId) {
        this.enseignantRepo.delete(this.enseignantRepo.findById(enseignantId)
                .orElseThrow(()-> new RessourceNotFoundException("teacher not found!!")));

    }
}
