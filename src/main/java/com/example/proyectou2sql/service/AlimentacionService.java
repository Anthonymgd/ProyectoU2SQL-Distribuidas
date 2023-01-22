package com.example.proyectou2.service;

import com.example.proyectou2.entities.Alimentacion;
import com.example.proyectou2.repo.AlimentacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentacionService {

    @Autowired
    private AlimentacionRepo alimentacionRepo;

    public Alimentacion createAlimentacion(Alimentacion alimentacion){
        return alimentacionRepo.save(alimentacion);
    }
    public List<Alimentacion> getAllAlimentacion(){
        return alimentacionRepo.findAll();
    }
    public Alimentacion getAlimentacionById(Long id){
        return alimentacionRepo.findById(id).orElseThrow(() -> new RuntimeException("Alimentación Not Found!"));
    }
    public void deleteAlimentacionById(Long id) {
        alimentacionRepo.deleteById(id);
    }

}
