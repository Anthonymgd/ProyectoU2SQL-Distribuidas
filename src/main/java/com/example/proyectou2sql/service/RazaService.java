package com.example.proyectou2sql.service;

import com.example.proyectou2sql.entities.Raza;
import com.example.proyectou2sql.repo.RazaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RazaService {
    @Autowired
    private RazaRepo razaRepo;

    public Raza createRaza(Raza raza){
        return razaRepo.save(raza);
    }
    public List<Raza> getAllRazas(){
        return razaRepo.findAll();
    }
    public Raza getRazaById(Long id) {
        return razaRepo.findById(id).orElseThrow(() -> new RuntimeException("Animal Not Found!"));
    }

    public void deleteRazaById(Long id) {
        razaRepo.deleteById(id);
    }
}
