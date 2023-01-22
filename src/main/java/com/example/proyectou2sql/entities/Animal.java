package com.example.proyectou2sql.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "animal")
@Getter
@Setter
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    Character genero;
    @NotNull
    String edad;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @Column(name = "raza_id")
    Raza razaId = new Raza();

    @Column(name = "potrero_id")
    Long potreroId;

    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_animales", referencedColumnName = "id")
    Set<Alimentacion> alimentacion = new HashSet<>();

    public Animal(Long id, Character genero, String edad, Raza razaId, Long potreroId, Set<Alimentacion> alimentacion) {
        this.id = id;
        this.genero = genero;
        this.edad = edad;
        this.razaId = razaId;
        this.potreroId = potreroId;
        this.alimentacion = alimentacion;
    }

    public Animal() {
    }
}
