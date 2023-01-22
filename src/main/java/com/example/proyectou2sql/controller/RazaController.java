package com.example.proyectou2sql.controller;


import com.example.proyectou2sql.entities.Raza;
import com.example.proyectou2sql.repo.RazaRepo;
import com.example.proyectou2sql.service.RazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("raza")
public class RazaController {
    @Autowired
    private RazaService razaService;
    @Autowired
    private RazaRepo razaRepo;

    @GetMapping(path = "/get")
    public ResponseEntity<List<Raza>> getAllRaza(){
        return ResponseEntity.ok().body(razaService.getAllRazas());
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Raza> createRaza(@RequestBody Raza raza){
        return new ResponseEntity<>(razaService.createRaza(raza), HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Raza> getRazaById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(razaService.getRazaById(id));
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteRazaById(@PathVariable Long id){
        razaService.deleteRazaById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Raza> updateRazaById (@PathVariable("id") long id, @RequestBody Raza raza) {
        Optional<Raza> razaData = razaRepo.findById(id);

        if (razaData.isPresent()) {
            Raza _raza = razaData.get();
            _raza.setNombre_raza(raza.getNombre_raza());
            return new ResponseEntity<>(razaRepo.save(_raza), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
