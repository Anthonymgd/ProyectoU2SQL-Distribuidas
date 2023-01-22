package com.example.proyectou2.service;

import com.example.proyectou2.entities.Animal;
import com.example.proyectou2.repo.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
