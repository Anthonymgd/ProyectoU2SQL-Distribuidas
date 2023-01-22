package com.example.proyectou2sql.controller;


import com.example.proyectou2sql.entities.Potrero;
import com.example.proyectou2sql.repo.PotreroRepo;
import com.example.proyectou2sql.service.PotreroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("potrero")
public class PotreroController {

    @Autowired
    private PotreroService potreroService;
    @Autowired
    private PotreroRepo potreroRepo;

    @GetMapping(path = "/get")
    public ResponseEntity<List<Potrero>> getAllPotrero(){
        return ResponseEntity.ok().body(potreroService.getAllPotrero());
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Potrero> createPotrero(@RequestBody Potrero potrero){
        return new ResponseEntity<>(potreroService.createPotrero(potrero), HttpStatus.CREATED);
    }
    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Potrero> getPotreroById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(potreroService.getPotreroById(id));
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deletePotreroById(@PathVariable Long id){
        potreroService.deletePotreroById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Potrero> updatePotreroById (@PathVariable("id") long id, @RequestBody Potrero potrero) {
        Optional<Potrero> potreroData = potreroRepo.findById(id);

        if (potreroData.isPresent()) {
            Potrero _potrero = potreroData.get();
            _potrero.setNombre_potrero(potrero.getNombre_potrero());
            _potrero.setHectareas(potrero.getHectareas());
            _potrero.setTipo_suelo(potrero.getTipo_suelo());
            return new ResponseEntity<>(potreroRepo.save(_potrero), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
