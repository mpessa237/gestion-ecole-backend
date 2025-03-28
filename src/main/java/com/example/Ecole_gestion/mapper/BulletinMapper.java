package com.example.Ecole_gestion.mapper;

import com.example.Ecole_gestion.dto.BulletinReqDTO;
import com.example.Ecole_gestion.dto.BulletinRespDTO;
import com.example.Ecole_gestion.entity.Bulletin;
import org.springframework.stereotype.Component;

@Component
public class BulletinMapper {

    public Bulletin toEntity(BulletinReqDTO bulletinReqDTO){
        Bulletin bulletin  = new Bulletin();

        bulletin.setAppreciaton(bulletinReqDTO.getAppreciaton());
        bulletin.setMoyenne(bulletinReqDTO.getMoyenne());
        bulletin.setDateRemise(bulletinReqDTO.getDateRemise());

        return bulletin;
    }

    public BulletinRespDTO toDto(Bulletin bulletin){
        BulletinRespDTO bulletinRespDTO = new BulletinRespDTO();

        bulletinRespDTO.setBulletinId(bulletin.getBulletinId());
        bulletinRespDTO.setAppreciaton(bulletin.getAppreciaton());
        bulletinRespDTO.setMoyenne(bulletin.getMoyenne());
        bulletinRespDTO.setDateRemise(bulletin.getDateRemise());

        return bulletinRespDTO;
    }
}
