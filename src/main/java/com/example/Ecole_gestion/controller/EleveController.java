package com.example.Ecole_gestion.controller;

import com.example.Ecole_gestion.dto.EleveReqDTO;
import com.example.Ecole_gestion.dto.EleveRespDTO;
import com.example.Ecole_gestion.entity.Eleve;
import com.example.Ecole_gestion.services.EleveService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EleveController {
    private final EleveService eleveService;

    public EleveController(EleveService eleveService) {
        this.eleveService = eleveService;
    }
    @PostMapping(path = "eleve/add")
    @ResponseBody
    public ResponseEntity<EleveRespDTO> addEleve(@Valid @RequestBody EleveReqDTO eleveReqDTO){

        EleveRespDTO addEleve = eleveService.addEleve(eleveReqDTO);
        return new ResponseEntity<>(addEleve, HttpStatus.CREATED);
    }
    @GetMapping(path = "eleve/pagination/{offset}/{pageSize}")
    public ResponseEntity<Page<EleveRespDTO>> pagination (@PathVariable int offset, @PathVariable int pageSize){
        return ResponseEntity
                .ok(this.eleveService.pagination(offset, pageSize));
    }
    @GetMapping(path = "eleve/get-all-eleve")
    public ResponseEntity<List<Eleve>> getAllEleve(){
        return ResponseEntity
                .ok(this.eleveService.getAllEleve());
    }
    @GetMapping(path = "eleve/get-eleve-by-nom/{nom}")
    public ResponseEntity<Eleve> getEleveByNom(@PathVariable String nom){
        return ResponseEntity
                .ok(this.eleveService.getEleveByNom(nom));
    }
    @GetMapping(path = "eleve/get-eleve-by-id/{eleveId}")
    public ResponseEntity<EleveRespDTO> getEleveById(@PathVariable Integer eleveId){
        return ResponseEntity
                .ok(this.eleveService.getEleveById(eleveId));
    }
    @PutMapping(path = "eleve/update-eleve-by-id/{eleveId}")
    public ResponseEntity<Eleve> updateEleveById(@Valid @RequestBody Eleve eleve,@PathVariable Integer eleveId){
        return ResponseEntity.ok(this.eleveService.updateEleveById(eleve, eleveId));
    }
    @DeleteMapping(path = "eleve/delete-by-id/{eleveId}")
    public ResponseEntity<String> deleteEleveById(@PathVariable Integer eleveId){
        this.eleveService.deleteEleveById(eleveId);
        return ResponseEntity.ok("student deleted successfully!!");
    }
}
