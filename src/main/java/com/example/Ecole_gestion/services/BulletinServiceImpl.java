package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.BulletinReqDTO;
import com.example.Ecole_gestion.dto.BulletinRespDTO;
import com.example.Ecole_gestion.entity.Bulletin;
import com.example.Ecole_gestion.exception.RessourceNotFoundException;
import com.example.Ecole_gestion.mapper.BulletinMapper;
import com.example.Ecole_gestion.repository.BulletinRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BulletinServiceImpl implements BulletinService{
    private final BulletinRepo bulletinRepo;
    private final BulletinMapper bulletinMapper;

    public BulletinServiceImpl(BulletinRepo bulletinRepo, BulletinMapper bulletinMapper) {
        this.bulletinRepo = bulletinRepo;
        this.bulletinMapper = bulletinMapper;
    }

    @Override
    public BulletinRespDTO addBulletin(BulletinReqDTO bulletinReqDTO)
    {
        Bulletin bulletin = bulletinMapper.toEntity(bulletinReqDTO);
        Bulletin addBulletin = bulletinRepo.save(bulletin);

        return bulletinMapper.toDto(addBulletin);
    }

    @Override
    public List<Bulletin> getAllBulletin() {
        return this.bulletinRepo.findAll();
    }

    @Override
    public BulletinRespDTO getBulletinById(Integer bulletinId) {
        Bulletin bulletin = this.bulletinRepo.findById(bulletinId)
                .orElseThrow(()->new RessourceNotFoundException("paper not found!!"));
        return bulletinMapper.toDto(bulletin);
    }

    @Override
    public Bulletin updateBulletinById(Bulletin bulletin, Integer bulletinId) {

        Optional<Bulletin> bulletinOptional = this.bulletinRepo.findById(bulletinId);
        if (bulletinOptional.isEmpty())
            throw new RessourceNotFoundException("paper not found!!");

        if (bulletin.getAppreciaton()!=null)
            bulletinOptional.get().setAppreciaton(bulletin.getAppreciaton());
        if (bulletin.getMoyenne()!=null)
            bulletinOptional.get().setMoyenne(bulletin.getMoyenne());
        if (bulletin.getDateRemise()!=null)
            bulletinOptional.get().setDateRemise(bulletin.getDateRemise());
        return this.bulletinRepo.saveAndFlush(bulletinOptional.get());
    }

    @Override
    public void deleteBulletin(Integer bulletinId) {

        this.bulletinRepo.delete(this.bulletinRepo.findById(bulletinId)
                .orElseThrow(()-> new RessourceNotFoundException("paper not found!!")));
    }
}
