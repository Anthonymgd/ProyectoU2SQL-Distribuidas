package com.example.proyectou2sql.repo;

import com.example.proyectou2sql.entities.Raza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazaRepo extends JpaRepository<Raza, Long> {
}
