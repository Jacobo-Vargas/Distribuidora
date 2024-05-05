package com.example.distribuidora.mapping.dto;

public record ProductoDto(
        String codigo,
        String nombre,
        String descripcion,
        CategoriaProductoDto clasificacion,
        double precioVenta,
        int cantidadStock

        ) {
}
