package com.example.distribuidora.entities.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Precio {
    private double valor;
    private String unidad;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date vigenciadesde;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date vigenciahasta;

}
