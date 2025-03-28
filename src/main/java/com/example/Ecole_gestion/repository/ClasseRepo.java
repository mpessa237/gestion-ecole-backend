package com.example.Ecole_gestion.repository;

import com.example.Ecole_gestion.entity.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClasseRepo extends JpaRepository<Classe,Integer> {
    @Query("SELECT c FROM Classe c WHERE c.nom=:nom")
    Optional<Classe> findClasseByNom(@Param("nom")String nom);
}
