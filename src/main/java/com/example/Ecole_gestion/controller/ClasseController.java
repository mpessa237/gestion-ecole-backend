package com.example.Ecole_gestion.controller;

import com.example.Ecole_gestion.dto.ClasseReqDTO;
import com.example.Ecole_gestion.dto.ClasseRespDTO;
import com.example.Ecole_gestion.entity.Classe;
import com.example.Ecole_gestion.services.ClasseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClasseController {
    private final ClasseService classeService;

    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }
    @PostMapping(path = "classe/add")
    @ResponseBody
    public ResponseEntity<ClasseRespDTO> addClasse(@Valid @RequestBody ClasseReqDTO classeReqDTO){
        ClasseRespDTO addClasse = classeService.addClasse(classeReqDTO);
        return new ResponseEntity<>(addClasse, HttpStatus.CREATED);
    }
    @GetMapping(path = "classe/get-all-classe")
    public ResponseEntity<List<Classe>> getAllClasse(){
        return ResponseEntity
                .ok(this.classeService.getAllClasse());
    }
    @GetMapping(path = "classe/get-classe-by-id/{classeId}")
    public ResponseEntity<ClasseRespDTO> getClasseById(@PathVariable Integer classeId){
        return ResponseEntity
                .ok(this.classeService.getClasseById(classeId));
    }
    @GetMapping(path = "classe/get-classe-by-nom/{nom}")
    public ResponseEntity<Classe> getClasseByNom(@PathVariable String nom){
        return ResponseEntity
                .ok(this.classeService.getClasseByNom(nom));
    }
    @PutMapping(path = "classe/update-classe-by-id/{classeId}")
    public ResponseEntity<Classe> updateClasseById(@Valid @RequestBody Classe classe, @PathVariable Integer classeId){
        return ResponseEntity
                .ok(this.classeService.updateClasseById(classe, classeId));
    }
    @DeleteMapping(path = "classe/delete-classe-by-id/{classeId}")
    public ResponseEntity<String> deleteClasseById(@PathVariable Integer classeId){
        this.classeService.deleteClasseById(classeId);
        return ResponseEntity
                .ok("class deleted successfully!");
    }
}
