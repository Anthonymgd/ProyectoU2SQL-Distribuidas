package com.example.proyectou2sql.repo;

import com.example.proyectou2sql.entities.Granja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GranjaRepo extends JpaRepository<Granja, Long> {
}
