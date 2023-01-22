package com.example.proyectou2sql.controller;

import com.example.proyectou2sql.entities.Alimentacion;
import com.example.proyectou2sql.repo.AlimentacionRepo;
import com.example.proyectou2sql.service.AlimentacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("alimentacion")
public class AlimentacionController {

    @Autowired
    private AlimentacionService alimentacionService;

    @Autowired
    private AlimentacionRepo alimentacionRepo;

    @PostMapping(path = "/add")
    public ResponseEntity<Alimentacion> createAlimentacion(@RequestBody Alimentacion alimentacion){
        return new ResponseEntity<>(alimentacionService.createAlimentacion(alimentacion), HttpStatus.CREATED);
    }
    @GetMapping(path = "/get")
    public ResponseEntity<List<Alimentacion>> getAllAlimentacion(){
        return ResponseEntity.ok().body(alimentacionService.getAllAlimentacion());
    }
    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Alimentacion> getAlimentacionById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(alimentacionService.getAlimentacionById(id));
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteAlimentacionById(@PathVariable Long id){
        alimentacionService.deleteAlimentacionById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Alimentacion> updateAlimentacionById (@PathVariable("id") long id, @RequestBody Alimentacion alimentacion) {
        Optional<Alimentacion> alimentacionData = alimentacionRepo.findById(id);

        if (alimentacionData.isPresent()) {
            Alimentacion _alimentacion = alimentacionData.get();
            _alimentacion.setNombre_alimentacion(alimentacion.getNombre_alimentacion());
            _alimentacion.setCantidad_raciones(alimentacion.getCantidad_raciones());
            return new ResponseEntity<>(alimentacionRepo.save(_alimentacion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
