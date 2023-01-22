package com.example.proyectou2sql.service;

import com.example.proyectou2sql.entities.Granja;
import com.example.proyectou2sql.repo.GranjaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GranjaService {
    @Autowired
    private GranjaRepo granjaRepo;

    public Granja createGranja(Granja granja){
        return granjaRepo.save(granja);
    }
    public List<Granja> getAllGranja(){
        return granjaRepo.findAll();
    }
    public Granja getGranjaById(Long id) {
        return granjaRepo.findById(id).orElseThrow(() -> new RuntimeException("Animal Not Found!"));
    }

    public void deleteGranjaById(Long id) {
        granjaRepo.deleteById(id);
    }
}
