package com.example.proyectou2sql.service;

import com.example.proyectou2sql.entities.Animal;
import com.example.proyectou2sql.repo.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepo animalRepo;

    public Animal createAnimal(Animal animal){
        return animalRepo.save(animal);
    }

    public List<Animal> getAllAnimals(){
        return animalRepo.getAllAnimals();
    }

    public Animal getAnimalById(Long id) {
        return animalRepo.findById(id).orElseThrow(() -> new RuntimeException("Animal Not Found!"));
    }

    public void deleteAnimalById(Long id) {
        animalRepo.deleteById(id);
    }


}
