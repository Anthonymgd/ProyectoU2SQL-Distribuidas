package com.example.proyectou2sql.controller;

import com.example.proyectou2sql.entities.Granja;
import com.example.proyectou2sql.repo.GranjaRepo;
import com.example.proyectou2sql.service.GranjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("granja")
public class GranjaController {

    @Autowired
    private GranjaService granjaService;

    @Autowired
    private GranjaRepo granjaRepo;

    @GetMapping(path = "/get")
    public ResponseEntity<List<Granja>> getAllGranja(){
        return ResponseEntity.ok().body(granjaService.getAllGranja());
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Granja> createGranja(@RequestBody Granja granja){
        return new ResponseEntity<>(granjaService.createGranja(granja), HttpStatus.CREATED);
    }
    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Granja> getGranjaById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(granjaService.getGranjaById(id));
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteGranjaById(@PathVariable Long id){
        granjaService.deleteGranjaById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Granja> updateGranjaById (@PathVariable("id") long id, @RequestBody Granja granja) {
        Optional<Granja> granjaData = granjaRepo.findById(id);

        if (granjaData.isPresent()) {
            Granja _granja = granjaData.get();
            _granja.setNombre_granja(granja.getNombre_granja());
            _granja.setTamanio_granja(granja.getTamanio_granja());
            _granja.setUbicacion(granja.getUbicacion());
            return new ResponseEntity<>(granjaRepo.save(_granja), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
