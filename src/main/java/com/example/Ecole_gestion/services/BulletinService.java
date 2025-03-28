package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.BulletinReqDTO;
import com.example.Ecole_gestion.dto.BulletinRespDTO;
import com.example.Ecole_gestion.entity.Bulletin;

import java.util.List;

public interface BulletinService {
    BulletinRespDTO addBulletin(BulletinReqDTO bulletinReqDTO);
    List<Bulletin> getAllBulletin();
    BulletinRespDTO getBulletinById(Integer bulletinId);
    Bulletin updateBulletinById(Bulletin bulletin,Integer bulletinId);
    void deleteBulletin(Integer bulletinId);
}
