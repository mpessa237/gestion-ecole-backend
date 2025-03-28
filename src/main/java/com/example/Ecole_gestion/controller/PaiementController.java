package com.example.Ecole_gestion.controller;

import com.example.Ecole_gestion.dto.PaiementReqDTO;
import com.example.Ecole_gestion.dto.PaiementRespDTO;
import com.example.Ecole_gestion.entity.Paiement;
import com.example.Ecole_gestion.services.PaiementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaiementController {
    private final PaiementService paiementService;

    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }
    @PostMapping(path = "paiement/add")
    @ResponseBody
    public ResponseEntity<PaiementRespDTO> addPaiement(@RequestBody PaiementReqDTO paiementReqDTO){
        PaiementRespDTO addPaiement = this.paiementService.addPaiement(paiementReqDTO);
        return new ResponseEntity<>(addPaiement, HttpStatus.CREATED);

    }
    @GetMapping(path = "paiement/get-all-paiement")
    public ResponseEntity<List<Paiement>> getAllPaiement(){
        return ResponseEntity
                .ok(this.paiementService.getAllPaiement());
    }
    @GetMapping(path = "paiement/get-paiement-by-id/{paiementId}")
    public ResponseEntity<PaiementRespDTO> getPaiementById(@PathVariable Integer paiementId){
        return ResponseEntity
                .ok(this.paiementService.getPaiementById(paiementId));
    }
    @PutMapping(path = "paiement/update-paiement-by-id/{paiementId}")
    public ResponseEntity<Paiement> updatePaiement(@RequestBody Paiement paiement,@PathVariable Integer paiementId){
        return ResponseEntity
                .ok(this.paiementService.updatePaiement(paiement, paiementId));
    }
    @DeleteMapping(path = "paiement/delete-paiement-by-id/{paiementId}")
    public ResponseEntity<String> deletePaiement(@PathVariable Integer paiementId){
        this.paiementService.deletePaiement(paiementId);
        return ResponseEntity.ok("payment deleted successfully!!");
    }
}
