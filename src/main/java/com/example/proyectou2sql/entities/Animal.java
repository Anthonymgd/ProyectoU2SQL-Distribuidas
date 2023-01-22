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

    @Column(name = "potrero_id")
    Long potreroId;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "raza_id", referencedColumnName = "id")
    Raza razaId = new Raza();
    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_animales", referencedColumnName = "id")
    Set<Alimentacion> alimentacion = new HashSet<>();

    public Animal(Long id, Character genero, String edad, Long potreroId, Set<Alimentacion> alimentacion) {
        this.id = id;
        this.genero = genero;
        this.edad = edad;
        this.potreroId = potreroId;
        this.alimentacion = alimentacion;
    }

    public Animal() {
    }
}
