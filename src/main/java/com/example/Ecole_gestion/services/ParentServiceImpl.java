package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.ParentReqDTO;
import com.example.Ecole_gestion.dto.ParentRespDTO;
import com.example.Ecole_gestion.entity.Parent;
import com.example.Ecole_gestion.exception.RessourceExistException;
import com.example.Ecole_gestion.exception.RessourceNotFoundException;
import com.example.Ecole_gestion.mapper.ParentMapper;
import com.example.Ecole_gestion.repository.ParentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService{
    private final ParentRepo parentRepo;
    private final ParentMapper parentMapper;

    public ParentServiceImpl(ParentRepo parentRepo, ParentMapper parentMapper) {
        this.parentRepo = parentRepo;
        this.parentMapper = parentMapper;
    }

    @Override
    public ParentRespDTO addParent(ParentReqDTO parentReqDTO) {
        // Validation de l'email
        if (!EmailValidation.isValidEmail(parentReqDTO.getEmail())) {
            throw new IllegalArgumentException("L'email est invalide. L'email doit contenir un '@' et se terminer par '.com'.");
        }


        Parent parent = parentMapper.toEntity(parentReqDTO);

        Parent addParent = parentRepo.save(parent);
        return parentMapper.toDto(parent);

    }

    @Override
    public List<Parent> getAllParent() {

        return this.parentRepo.findAll();
    }

    @Override
    public ParentRespDTO getParentById(Integer parentId) {

        Parent parent = parentRepo.findById(parentId)
                .orElseThrow(()-> new RessourceNotFoundException("parent not found!"));
        return parentMapper.toDto(parent);
    }

    @Override
    public Parent updateParent(Parent parent, Integer parentId)
    {
        //recherche du parent a modifier
        Optional<Parent> parentToUpdate = this.parentRepo.findById(parentId);
        if (parentToUpdate.isEmpty())
            throw new RessourceNotFoundException("parent not found");
        //infos a modifier
        if (parent.getNom()!=null)
            parentToUpdate.get().setNom(parent.getNom());
        if (parent.getPrenom()!=null)
            parentToUpdate.get().setPrenom(parent.getPrenom());
        if (parent.getSexe()!=null)
            parentToUpdate.get().setSexe(parent.getSexe());
        if (parent.getTelephone()!=null)
            parentToUpdate.get().setTelephone(parent.getTelephone());
        if (parent.getEmail()!=null)
            parentToUpdate.get().setEmail(parent.getEmail());
        //mise a jour des nouvelles infos
        return this.parentRepo.saveAndFlush(parentToUpdate.get());

    }

    @Override
    public void deleteParentById(Integer parentId) {
        this.parentRepo.delete(this.parentRepo.findById(parentId)
                .orElseThrow(()-> new RessourceNotFoundException("parent not found")));
    }
}
