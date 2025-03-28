package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.ClasseReqDTO;
import com.example.Ecole_gestion.dto.ClasseRespDTO;
import com.example.Ecole_gestion.entity.Classe;
import com.example.Ecole_gestion.exception.RessourceNotFoundException;
import com.example.Ecole_gestion.mapper.ClasseMapper;
import com.example.Ecole_gestion.repository.ClasseRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasseServiceImpl implements ClasseService{
    private final ClasseRepo classeRepo;
    private final ClasseMapper classeMapper;

    public ClasseServiceImpl(ClasseRepo classeRepo, ClasseMapper classeMapper) {
        this.classeRepo = classeRepo;
        this.classeMapper = classeMapper;
    }

    @Override
    public ClasseRespDTO addClasse(ClasseReqDTO classeReqDTO) {

        Classe classe = classeMapper.toEntity(classeReqDTO);
        Classe addClasse = classeRepo.save(classe);

        return classeMapper.toDto(addClasse);
    }

    @Override
    public List<Classe> getAllClasse() {

        return this.classeRepo.findAll();
    }

    @Override
    public ClasseRespDTO getClasseById(Integer classeId) {
        Classe classe = this.classeRepo.findById(classeId)
                .orElseThrow(()->new RessourceNotFoundException("class not found!!"));
        return classeMapper.toDto(classe);
    }

    @Override
    public Classe getClasseByNom(String nom) {
        Optional<Classe> classe = this.classeRepo.findClasseByNom(nom);
        if (classe.isEmpty())
            throw new RessourceNotFoundException("class not found!!");
        return classe.get();
    }

    @Override
    public Classe updateClasseById(Classe classe, Integer classeId) {
        Optional<Classe> classeOptional = this.classeRepo.findById(classeId);

        if (classeOptional.isEmpty())
            throw new RessourceNotFoundException("class not found!!");
        if (classe.getNom()!=null)
            classeOptional.get().setNom(classe.getNom());

        return this.classeRepo.saveAndFlush(classeOptional.get());
    }
    @Override
    public void deleteClasseById(Integer classeId) {
        this.classeRepo.delete(this.classeRepo.findById(classeId)
                .orElseThrow(()->new RessourceNotFoundException("class not found!!")));
    }
}
