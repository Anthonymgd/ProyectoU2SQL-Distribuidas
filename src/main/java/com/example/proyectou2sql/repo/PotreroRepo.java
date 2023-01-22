package com.example.proyectou2sql.repo;

import com.example.proyectou2sql.entities.Potrero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotreroRepo extends JpaRepository<Potrero, Long> {
}
