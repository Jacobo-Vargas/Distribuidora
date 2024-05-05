package com.example.distribuidora.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @Column(name = "CODIGO")
    private String codigo;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "IDCATEGORIA")
    private CategoriaProducto clasificacion;

    @Column(name = "PRECIOVENTA")
    private double precioVenta;

    @Column(name = "CANTIDADSTOCK")
    private int cantidadStock;

}
