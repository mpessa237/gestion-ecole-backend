package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.EleveReqDTO;
import com.example.Ecole_gestion.dto.EleveRespDTO;
import com.example.Ecole_gestion.entity.Eleve;
import com.example.Ecole_gestion.exception.RessourceNotFoundException;
import com.example.Ecole_gestion.mapper.EleveMapper;
import com.example.Ecole_gestion.repository.EleveRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EleveServiceImpl implements EleveService{
    private final EleveMapper eleveMapper;
    private final EleveRepo eleveRepo;

    public EleveServiceImpl(EleveMapper eleveMapper, EleveRepo eleveRepo) {
        this.eleveMapper = eleveMapper;
        this.eleveRepo = eleveRepo;
    }

    @Override
    public EleveRespDTO addEleve(EleveReqDTO eleveReqDTO) {

        Eleve eleve = eleveMapper.toEntity(eleveReqDTO);
        Eleve addEleve = eleveRepo.save(eleve);

        return eleveMapper.toDto(addEleve);

    }

    @Override
    public Page<EleveRespDTO> pagination(int offset, int pageSize) {
        return this.eleveRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC,"dateNaissance")))
                .map(eleve -> this.eleveMapper.toDto(eleve));
    }

    @Override
    public List<Eleve> getAllEleve() {
        return this.eleveRepo.findAll();
    }

    @Override
    public Eleve getEleveByNom(String nom) {
        Optional<Eleve> eleve = this.eleveRepo.findEleveByNom(nom);
        if (eleve.isEmpty())
            throw new RessourceNotFoundException("student not found!!");
        return eleve.get();
    }

    @Override
    public EleveRespDTO getEleveById(Integer eleveId) {

        Eleve eleve = eleveRepo.findById(eleveId)
                .orElseThrow(()-> new RessourceNotFoundException("student not found!"));
        return eleveMapper.toDto(eleve);
    }

    @Override
    public Eleve updateEleveById(Eleve eleve, Integer eleveId) {

        Optional<Eleve> eleveOptional = this.eleveRepo.findById(eleveId);
        if (eleveOptional.isEmpty())
            throw new RessourceNotFoundException("student not found!");

        if (eleve.getNom()!=null)
            eleveOptional.get().setNom(eleve.getNom());
        if (eleve.getPrenom()!=null)
            eleveOptional.get().setPrenom(eleve.getPrenom());
        if (eleve.getSexe()!=null)
            eleveOptional.get().setSexe(eleve.getSexe());

        return this.eleveRepo.saveAndFlush(eleveOptional.get());

    }

    @Override
    public void deleteEleveById(Integer eleveId) {
        this.eleveRepo.delete(this.eleveRepo.findById(eleveId)
                .orElseThrow(()-> new RessourceNotFoundException("student not found!")));
    }
}
