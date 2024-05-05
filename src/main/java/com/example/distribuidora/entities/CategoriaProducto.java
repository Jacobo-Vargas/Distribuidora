package com.example.distribuidora.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CATEGORIAPRODUCTOS")
@Data
public class CategoriaProducto {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DECRIPCION")
    private String descripcion;
}
