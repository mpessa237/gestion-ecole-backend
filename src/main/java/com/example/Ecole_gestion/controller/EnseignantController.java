package com.example.Ecole_gestion.controller;

import com.example.Ecole_gestion.dto.EnseignantReqDTO;
import com.example.Ecole_gestion.dto.EnseignantRespDTO;
import com.example.Ecole_gestion.entity.Enseignant;
import com.example.Ecole_gestion.services.EnseignantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnseignantController {
    private final EnseignantService enseignantService;

    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @PostMapping(path = "enseignant/add")
    @ResponseBody
    public ResponseEntity<EnseignantRespDTO> addEnseignant(@Valid @RequestBody EnseignantReqDTO enseignantReqDTO){

        EnseignantRespDTO addEnseignant = enseignantService.addEnseignant(enseignantReqDTO);
        return new ResponseEntity<>(addEnseignant, HttpStatus.CREATED);
    }
    @GetMapping(path = "enseignant/get-all-enseignant")
    public ResponseEntity<List<Enseignant>> getAllEnseignant(){
        return ResponseEntity
                .ok(this.enseignantService.getAllEnseignant());
    }
    @GetMapping(path = "enseignant/get-enseignant-by-id/{enseignantId}")
    public ResponseEntity<EnseignantRespDTO> getEnseignantById(@PathVariable Integer enseignantId){
        return ResponseEntity
                .ok(this.enseignantService.getEnseignantById(enseignantId));
    }
    @PutMapping(path = "enseignant/update-enseignant-by-id/{enseignantId}")
    public ResponseEntity<Enseignant> updateEnseignantById(@Valid @RequestBody Enseignant enseignant,@PathVariable Integer enseignantId){
        return ResponseEntity
                .ok(this.enseignantService.updateEnseignant(enseignant, enseignantId));
    }
    @DeleteMapping(path = "enseignant/delete-enseignant-by-id/{enseignantId}")
    public ResponseEntity<String> deleteEnseignantById(@PathVariable Integer enseignantId){
        this.enseignantService.deleteEnseignantById(enseignantId);
        return ResponseEntity
                .ok("teacher deleted successfully!");
    }
}
