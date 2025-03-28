package com.example.Ecole_gestion.controller;

import com.example.Ecole_gestion.dto.ParentReqDTO;
import com.example.Ecole_gestion.dto.ParentRespDTO;
import com.example.Ecole_gestion.entity.Parent;
import com.example.Ecole_gestion.services.ParentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParentController {
    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }
    @PostMapping(path = "parent/add")
    @ResponseBody
    public ResponseEntity<ParentRespDTO> addParent(@Valid @RequestBody ParentReqDTO parentReqDTO){

        ParentRespDTO addParent = parentService.addParent(parentReqDTO);
        return new ResponseEntity<>(addParent, HttpStatus.CREATED);
    }
    @GetMapping(path = "parent/get-all-parent")
    public ResponseEntity<List<Parent>> getAllParent(){
        return ResponseEntity
                .ok(this.parentService.getAllParent());
    }
    @GetMapping(path = "parent/get-parent-by-id/{parentId}")
    public ResponseEntity<ParentRespDTO> getParentById(@PathVariable Integer parentId){
        return ResponseEntity.ok(this.parentService.getParentById(parentId));
    }
    @PutMapping(path = "parent/update-parent-by-id/{parentId}")
    public ResponseEntity<Parent> updateParentById(@Valid @RequestBody Parent parent,@PathVariable Integer parentId){
        return ResponseEntity
                .ok(this.parentService.updateParent(parent, parentId));
    }
    @DeleteMapping(path = "parent/delete-parent-by-id/{parentId}")
    public ResponseEntity<String> deleteParentById(@PathVariable Integer parentId){
        this.parentService.deleteParentById(parentId);
        return ResponseEntity.ok("parent deleted successfully!!");
    }
}
