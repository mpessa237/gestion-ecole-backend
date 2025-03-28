package com.example.Ecole_gestion.repository;

import com.example.Ecole_gestion.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepo extends JpaRepository<Note,Integer> {
    //jpql recherche grace a la valeur
    @Query("SELECT n FROM Note n WHERE n.valeur=:valeur")
    Optional<Note> findNoteByValeur(@Param("valeur") Float valeur);

    //jpql recherche grace a l'appreciation
    Optional<Note> findNoteByAppreciation( String appreciation);

}
