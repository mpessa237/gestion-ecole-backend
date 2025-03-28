package com.example.Ecole_gestion.controller;

import com.example.Ecole_gestion.dto.MatiereReqDTO;
import com.example.Ecole_gestion.dto.MatiereRespDTO;
import com.example.Ecole_gestion.entity.Matiere;
import com.example.Ecole_gestion.services.MatiereService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatiereController {
    private final MatiereService matiereService;

    public MatiereController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }
    @PostMapping(path = "matiere/add")
    @ResponseBody
    public ResponseEntity<MatiereRespDTO> addMatiere(@RequestBody MatiereReqDTO matiereReqDTO){
        MatiereRespDTO addMatiere = matiereService.addMatiere(matiereReqDTO);
        return new ResponseEntity<>(addMatiere, HttpStatus.CREATED);
    }
    @GetMapping(path ="matiere/get-all-matiere")
    public ResponseEntity<List<Matiere>> getAllMatiere(){
        return ResponseEntity
                .ok(this.matiereService.getAllMatiere());
    }
    @GetMapping(path = "matiere/get-matiere-by-id/{matiereId}")
    public ResponseEntity<MatiereRespDTO> getMatiereById(@PathVariable Integer matiereId){
        return ResponseEntity
                .ok(this.matiereService.getMatiereById(matiereId));
    }
    @GetMapping(path = "matiere/get-matiere-by-nom/{nom}")
    public ResponseEntity<MatiereRespDTO> getMatiereByNom(@PathVariable String nom){
        return ResponseEntity .ok(this.matiereService.getMatiereByNom(nom));
    }
    @PutMapping(path = "matiere/update-matiere-by-id/{matiereId}")
    public ResponseEntity<Matiere> updateMatiere(@RequestBody Matiere matiere,@PathVariable Integer matiereId){
        return ResponseEntity
                .ok(this.matiereService.updateMatiere(matiere, matiereId));
    }
    @DeleteMapping(path = "matiere/delete-matiere-by-id/{matiereId}")
    public ResponseEntity<String> deleteMatiereById(@PathVariable Integer matiereId){
        this.matiereService.deleteMatiereById(matiereId);
        return ResponseEntity.ok("matiere deleted successfully!!");
    }
}
