package com.example.Ecole_gestion.repository;

import com.example.Ecole_gestion.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepo extends JpaRepository<Parent,Integer> {
}
