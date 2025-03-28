package com.example.Ecole_gestion.services;

import com.example.Ecole_gestion.dto.ParentReqDTO;
import com.example.Ecole_gestion.dto.ParentRespDTO;
import com.example.Ecole_gestion.entity.Parent;

import java.util.List;

public interface ParentService {
    ParentRespDTO addParent(ParentReqDTO parentReqDTO);
    List<Parent> getAllParent();
    ParentRespDTO getParentById(Integer parentId);
    Parent updateParent(Parent parent,Integer parentId);
    void deleteParentById(Integer parentId);
}
