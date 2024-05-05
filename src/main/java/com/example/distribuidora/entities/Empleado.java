package com.example.distribuidora.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "EMPLEADOS")
public class Empleado {
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "NUMEMPLEADO")
    private Long numeroEmpleado;

    @Column(name = "CARGO")
    private String cargo;

    @Column(name = "FECHACONTRATO")
    private LocalDate fechaContratacion;

    @Column(name = "ESTADO")
    private String estado;

}
