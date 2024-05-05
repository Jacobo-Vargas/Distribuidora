package com.example.distribuidora.mapping.dto;

import java.time.LocalDate;

public record EmpleadoDto(
        Long id,
        String nombre,
        String apellido,
        Long numeroEmpleado,
        String cargo,
        LocalDate fechaContratacion,
        String estado) {

}
