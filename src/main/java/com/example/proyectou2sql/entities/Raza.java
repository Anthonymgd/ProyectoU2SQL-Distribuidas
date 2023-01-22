package com.example.proyectou2sql.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @Column(name = "raza_id")
    Long razaId;

    public Raza(Long id, String nombre_raza, Long razaId) {
        this.id = id;
        this.nombre_raza = nombre_raza;
        this.razaId = razaId;
    }

    public Raza() {
    }
}
