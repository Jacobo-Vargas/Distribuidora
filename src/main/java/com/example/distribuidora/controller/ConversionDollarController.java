package com.example.distribuidora.controller;

import com.example.distribuidora.service.ConversionDollarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dollar")
public class ConversionDollarController {

    @Autowired
    ConversionDollarService conversionDollarService;

    @GetMapping("/obtenerValor")
    private ResponseEntity<?> obtenerPrecioDollar(){
        return conversionDollarService.obtenerPrecioDollar();
    }
}
