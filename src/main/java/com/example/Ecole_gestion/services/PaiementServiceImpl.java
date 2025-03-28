package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.PaiementReqDTO;
import com.example.Ecole_gestion.dto.PaiementRespDTO;
import com.example.Ecole_gestion.entity.Paiement;
import com.example.Ecole_gestion.exception.RessourceNotFoundException;
import com.example.Ecole_gestion.mapper.PaiementMapper;
import com.example.Ecole_gestion.repository.PaiementRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaiementServiceImpl implements PaiementService{
    private final PaiementRepo paiementRepo;
    private final PaiementMapper paiementMapper;

    public PaiementServiceImpl(PaiementRepo paiementRepo, PaiementMapper paiementMapper) {
        this.paiementRepo = paiementRepo;
        this.paiementMapper = paiementMapper;
    }

    @Override
    public PaiementRespDTO addPaiement(PaiementReqDTO paiementReqDTO) {

        Paiement paiement = paiementMapper.toEntity(paiementReqDTO);

        Paiement addPaiement = this.paiementRepo.save(paiement);

        return paiementMapper.toDto(paiement);
    }

    @Override
    public List<Paiement> getAllPaiement() {
        return this.paiementRepo.findAll();
    }

    @Override
    public PaiementRespDTO getPaiementById(Integer paiementId) {
        Paiement paiement = this.paiementRepo.findById(paiementId)
                .orElseThrow(()-> new RessourceNotFoundException("payment not found!!"));
        return paiementMapper.toDto(paiement);
    }

    @Override
    public Paiement updatePaiement(Paiement paiement, Integer paiementId) {

        Optional<Paiement> paiementOptional = this.paiementRepo.findById(paiementId);
        if (paiementOptional.isEmpty())
            throw new RessourceNotFoundException("payment not found!!");
        if (paiement.getMontant()!=null)
            paiementOptional.get().setMontant(paiement.getMontant());
        if (paiement.getTypePaiement()!=null)
            paiementOptional.get().setTypePaiement(paiement.getTypePaiement());
        if (paiement.getDatePaiement()!=null)
            paiementOptional.get().setDatePaiement(paiement.getDatePaiement());

        return this.paiementRepo.saveAndFlush(paiementOptional.get());
    }

    @Override
    public void deletePaiement(Integer paiementId) {

        this.paiementRepo.delete(this.paiementRepo.findById(paiementId)
                .orElseThrow(()-> new RessourceNotFoundException("payment not found!!")));
    }
}
