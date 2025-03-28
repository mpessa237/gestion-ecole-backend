package com.example.Ecole_gestion.repository;

import com.example.Ecole_gestion.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepo extends JpaRepository<Enseignant,Integer> {
}
