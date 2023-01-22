package com.example.proyectou2sql.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "raza")
@Getter
@Setter
public class Raza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String nombre_raza;

    @JsonIgnore
    @OneToMany(mappedBy = "razaId")
    Set<Animal> animales = new HashSet<>();

    public Raza(Long id, String nombre_raza, Set<Animal> animales) {
        this.id = id;
        this.nombre_raza = nombre_raza;
        this.animales = animales;
    }

    public Raza() {
    }
}
