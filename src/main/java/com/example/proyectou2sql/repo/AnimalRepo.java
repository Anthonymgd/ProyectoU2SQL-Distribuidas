package com.example.proyectou2sql.repo;

import com.example.proyectou2sql.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Long>{

    @Query("SELECT a FROM Animal a")
    List<Animal> getAllAnimals();
}
