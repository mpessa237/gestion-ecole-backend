package com.example.Ecole_gestion.controller;

import com.example.Ecole_gestion.dto.BulletinReqDTO;
import com.example.Ecole_gestion.dto.BulletinRespDTO;
import com.example.Ecole_gestion.entity.Bulletin;
import com.example.Ecole_gestion.services.BulletinService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BulletinController {
    private final BulletinService bulletinService;

    public BulletinController(BulletinService bulletinService) {
        this.bulletinService = bulletinService;
    }
    @PostMapping(path = "bulletin/add")
    @ResponseBody
    public ResponseEntity<BulletinRespDTO> addBulletin(@Valid @RequestBody BulletinReqDTO bulletinReqDTO){
        BulletinRespDTO addBulletin = this.bulletinService.addBulletin(bulletinReqDTO);
        return new ResponseEntity<>(addBulletin, HttpStatus.CREATED);
    }
    @GetMapping(path = "bulletin/get-all-bulletin")
    public ResponseEntity<List<Bulletin>> getAllBulletin(){
        return ResponseEntity
                .ok(this.bulletinService.getAllBulletin());
    }
    @GetMapping(path ="bulletin/get-bulletin-by-id/{bulletinId}")
    public ResponseEntity<BulletinRespDTO> getBulletinById(@PathVariable Integer bulletinId){
        return ResponseEntity
                .ok(this.bulletinService.getBulletinById(bulletinId));
    }
    @PutMapping(path = "bulletin/update-bulletin-by-id/{bulletinId}")
    public ResponseEntity<Bulletin> updateBulletinById(@Valid @RequestBody Bulletin bulletin, @PathVariable Integer bulletinId){
        return ResponseEntity
                .ok(this.bulletinService.updateBulletinById(bulletin, bulletinId));
    }
    @DeleteMapping(path = "bulletin/delete-by-id/{bulletinId}")
    public ResponseEntity<String> deleteById(@PathVariable Integer bulletinId){
        this.bulletinService.deleteBulletin(bulletinId);
        return ResponseEntity
                .ok("paper deleted successfully!");
    }
}
