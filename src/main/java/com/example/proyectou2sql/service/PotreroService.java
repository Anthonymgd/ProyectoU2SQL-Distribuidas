package com.example.proyectou2sql.service;

import com.example.proyectou2sql.entities.Potrero;
import com.example.proyectou2sql.repo.PotreroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PotreroService {

    @Autowired
    private PotreroRepo potreroRepo;

    public Potrero createPotrero(Potrero potrero){
        return potreroRepo.save(potrero);
    }
    public List<Potrero> getAllPotrero(){
        return potreroRepo.findAll();
    }
    public Potrero getPotreroById(Long id) {
        return potreroRepo.findById(id).orElseThrow(() -> new RuntimeException("Animal Not Found!"));
    }

    public void deletePotreroById(Long id) {
        potreroRepo.deleteById(id);
    }
}
