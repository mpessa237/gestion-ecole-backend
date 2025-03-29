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

        List<Eleve> eleves = this.eleveRepo.findAll();
        //afficher le nombre d'absence de chaque eleve
        for (Eleve eleve: eleves){
            System.out.println("Eleve:"+ eleve.getNom()+",Nombres d'absence:"+eleve.getNombreAbsences());
        }
        return eleves;
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
        // Récupérer l'élève par son ID
        Eleve eleve = eleveRepo.findById(eleveId)
                .orElseThrow(() -> new RessourceNotFoundException("Student not found!"));

        // Calculer le total des heures d'absences
        int totalHeuresAbsences = eleve.getTotalHeuresAbsences();

        // Mapper l'élève en DTO (si tu utilises un mapper)
        EleveRespDTO eleveRespDTO = eleveMapper.toDto(eleve);

        // Ajouter le nombre total d'heures d'absences dans le DTO
        eleveRespDTO.setTotalHeuresAbsences(totalHeuresAbsences);

        return eleveRespDTO;
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
