package com.example.Ecole_gestion.repository;

import com.example.Ecole_gestion.entity.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatiereRepo extends JpaRepository<Matiere,Integer> {
    @Query("SELECT m FROM Matiere m WHERE m.nom=:nom")
    Optional<Matiere> findMatiereByNom(@Param("nom") String nom);
}
