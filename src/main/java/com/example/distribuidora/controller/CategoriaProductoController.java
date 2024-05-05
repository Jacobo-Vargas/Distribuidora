package com.example.distribuidora.controller;

import com.example.distribuidora.mapping.dto.CategoriaProductoDto;
import com.example.distribuidora.service.CategoriaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categoriaProducto")
public class CategoriaProductoController {

    @Autowired
    CategoriaProductoService categoriaProductoService;


    @PostMapping("/crearCategoria")
    public ResponseEntity<?> crearCategoria(@RequestBody CategoriaProductoDto categoriaProducto){
        return categoriaProductoService.crearCategoria(categoriaProducto);
    }

    @PutMapping("/modificarCategoria")
    private ResponseEntity<?> modificarCategoria(@RequestBody CategoriaProductoDto categoriaProducto){
        return categoriaProductoService.modificarCategoria(categoriaProducto);
    }

    @DeleteMapping("/eliminarCategoria/{id}")
    private ResponseEntity<?> eliminarCategoria(@PathVariable Long id){
        return categoriaProductoService.eliminarCategoria(id);
    }
}
