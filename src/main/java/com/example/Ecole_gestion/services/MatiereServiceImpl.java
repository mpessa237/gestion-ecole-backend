package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.MatiereReqDTO;
import com.example.Ecole_gestion.dto.MatiereRespDTO;
import com.example.Ecole_gestion.entity.Matiere;
import com.example.Ecole_gestion.exception.RessourceNotFoundException;
import com.example.Ecole_gestion.mapper.MatiereMapper;
import com.example.Ecole_gestion.repository.MatiereRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereServiceImpl implements MatiereService{
    private final MatiereRepo matiereRepo;
    private final MatiereMapper matiereMapper;

    public MatiereServiceImpl(MatiereRepo matiereRepo, MatiereMapper matiereMapper) {
        this.matiereRepo = matiereRepo;
        this.matiereMapper = matiereMapper;
    }

    @Override
    public MatiereRespDTO addMatiere(MatiereReqDTO matiereReqDTO) {
        Matiere matiere = this.matiereMapper.toEntity(matiereReqDTO);
        Matiere addMatiere = matiereRepo.save(matiere);

        return matiereMapper.toDto(addMatiere);
    }

    @Override
    public List<Matiere> getAllMatiere() {
        return this.matiereRepo.findAll();
    }

    @Override
    public MatiereRespDTO getMatiereById(Integer matiereId) {
        Matiere matiere = this.matiereRepo.findById(matiereId)
                .orElseThrow(()-> new RessourceNotFoundException("matiere not found!"));
        return matiereMapper.toDto(matiere);
    }

    @Override
    public MatiereRespDTO getMatiereByNom(String nom) {
        Matiere matiere = this.matiereRepo.findMatiereByNom(nom)
                .orElseThrow(()->new RessourceNotFoundException("matiere not found!!"));
        return matiereMapper.toDto(matiere);
    }

    @Override
    public Matiere updateMatiere(Matiere matiere, Integer matiereId) {
        Optional<Matiere> matiereToUpdate = this.matiereRepo.findById(matiereId);
        if (matiereToUpdate.isEmpty())
            throw new RessourceNotFoundException("matiere not found!!");
        if (matiere.getNom()!=null)
            matiereToUpdate.get().setNom(matiere.getNom());
        if (matiere.getCoefficient()!=null)
            matiereToUpdate.get().setCoefficient(matiere.getCoefficient());

        return this.matiereRepo.saveAndFlush(matiereToUpdate.get());
    }

    @Override
    public void deleteMatiereById(Integer matiereId) {
        this.matiereRepo.delete(this.matiereRepo.findById(matiereId)
                .orElseThrow(()->new RessourceNotFoundException("matiere not found!!")));
    }
}
