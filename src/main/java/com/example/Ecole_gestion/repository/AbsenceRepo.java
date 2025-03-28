package com.example.Ecole_gestion.repository;

import com.example.Ecole_gestion.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepo extends JpaRepository<Absence,Integer> {
}
