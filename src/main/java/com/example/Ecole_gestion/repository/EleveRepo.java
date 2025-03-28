package com.example.Ecole_gestion.repository;

import com.example.Ecole_gestion.entity.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EleveRepo extends JpaRepository<Eleve,Integer> {
    @Query("SELECT e FROM Eleve e WHERE e.nom=:nom")
    Optional<Eleve> findEleveByNom(@Param("nom")String nom);
}