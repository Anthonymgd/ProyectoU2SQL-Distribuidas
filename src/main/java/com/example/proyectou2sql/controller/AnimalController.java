package com.example.proyectou2sql.controller;

import com.example.proyectou2sql.entities.Animal;
import com.example.proyectou2sql.repo.AnimalRepo;
import com.example.proyectou2sql.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private AnimalRepo animalRepo;

    @GetMapping(path = "/get")
    public ResponseEntity<List<Animal>> getAllAnimals(){
        return ResponseEntity.ok().body(animalService.getAllAnimals());
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Animal> createComment(@RequestBody Animal animal) {
        return new ResponseEntity<>(animalService.createAnimal(animal), HttpStatus.CREATED);
    }
    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(animalService.getAnimalById(id));
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteAnimalById(@PathVariable Long id){
        animalService.deleteAnimalById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Animal> updateAnimalById (@PathVariable("id") long id, @RequestBody Animal animal) {
        Optional<Animal> animalData = animalRepo.findById(id);

        if (animalData.isPresent()) {
            Animal _animal = animalData.get();
            _animal.setGenero(animal.getGenero());
            _animal.setEdad(animal.getEdad());
            return new ResponseEntity<>(animalRepo.save(_animal), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
