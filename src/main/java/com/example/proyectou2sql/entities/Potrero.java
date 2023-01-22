package com.example.proyectou2sql.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "potrero")
@Getter
@Setter
public class Potrero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String nombre_potrero;

    @NotNull
    String hectareas;

    @NotNull
    String tipo_suelo;

    @OneToMany(cascade =  {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "potrero_id", referencedColumnName = "id")
    Set<Animal> animal = new HashSet<>();

    @Column(name = "granja_id")
    Long granjaId;

    public Potrero(Long id, String nombre_potrero, String hectareas, String tipo_suelo, Set<Animal> animal) {
        this.id = id;
        this.nombre_potrero = nombre_potrero;
        this.hectareas = hectareas;
        this.tipo_suelo = tipo_suelo;
        this.animal = animal;
    }

    public Potrero() {
    }
}
