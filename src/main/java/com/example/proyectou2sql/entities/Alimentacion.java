package com.example.proyectou2sql.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tipo_alimentacion")
@Getter
@Setter
public class Alimentacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String nombre_alimentacion;

    @NotNull
    String cantidad_raciones;

    @Column(name = "id_animales")
    Long animalesId;

    public Alimentacion(Long id, String nombre_alimentacion, String cantidad_raciones, Long animalesId) {
        this.id = id;
        this.nombre_alimentacion = nombre_alimentacion;
        this.cantidad_raciones = cantidad_raciones;
        this.animalesId = animalesId;
    }

    public Alimentacion() {
    }
}
