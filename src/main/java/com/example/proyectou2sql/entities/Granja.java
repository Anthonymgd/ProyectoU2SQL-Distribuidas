package com.example.proyectou2sql.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "granja")
@Getter
@Setter
public class Granja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String nombre_granja;

    @NotNull
    String tamanio_granja;

    @NotNull
    String ubicacion;

    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "granja_id", referencedColumnName = "id")
    Set<Potrero> potrero = new HashSet<>();

    public Granja(Long id, String nombre_granja, String tamanio_granja, String ubicacion, Set<Potrero> potrero) {
        this.id = id;
        this.nombre_granja = nombre_granja;
        this.tamanio_granja = tamanio_granja;
        this.ubicacion = ubicacion;
        this.potrero = potrero;
    }

    public Granja() {
    }
}
