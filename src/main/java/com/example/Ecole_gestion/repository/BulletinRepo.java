package com.example.Ecole_gestion.repository;

import com.example.Ecole_gestion.entity.Bulletin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BulletinRepo extends JpaRepository<Bulletin,Integer> {
}
