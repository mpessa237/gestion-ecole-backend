package com.example.Ecole_gestion.controller;

import com.example.Ecole_gestion.dto.AbsenceReqDTO;
import com.example.Ecole_gestion.dto.AbsenceRespDTO;
import com.example.Ecole_gestion.entity.Absence;
import com.example.Ecole_gestion.services.AbsenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AbsenceController {
    private final AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }
    @PostMapping(path = "absence/add")
    @ResponseBody
    public ResponseEntity<AbsenceRespDTO> addAbsence(@RequestBody AbsenceReqDTO absenceReqDTO){
        AbsenceRespDTO addAbsence = this.absenceService.addAbsence(absenceReqDTO);
        return new ResponseEntity<>(addAbsence, HttpStatus.CREATED);
    }
    @GetMapping(path = "absence/get-all-absence")
    public ResponseEntity<List<Absence>> getAllAbsence(){
        return ResponseEntity
                .ok(this.absenceService.getAllAbsence());
    }
    @GetMapping(path = "absence/get-absence-by-id/{absenceId}")
    public ResponseEntity<AbsenceRespDTO> getAbsenceById(@PathVariable Integer absenceId){
        return ResponseEntity
                .ok(this.absenceService.getAbsenceById(absenceId));
    }
    @PutMapping(path = "absence/update-absence-by-id/{absenceId}")
    public ResponseEntity<Absence> updateAbsence(@RequestBody Absence absence,@PathVariable Integer absenceId){
        return ResponseEntity
                .ok(this.absenceService.updateAbsenceById(absence, absenceId));
    }
    @DeleteMapping(path = "absence/delete-absence-by-id/{absenceId}")
    public ResponseEntity<String> deleteAbsence(@PathVariable Integer absenceId){
        this.absenceService.deleteAbsence(absenceId);
        return ResponseEntity
                .ok("absent deleted successfully!");
    }
}
