package com.example.distribuidora.controller;

import com.example.distribuidora.mapping.dto.ProductoDto;
import com.example.distribuidora.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @PostMapping("/crearProducto")
    private ResponseEntity<?> creaProducto(@RequestBody ProductoDto producto){
        return productoService.creaProducto(producto);
    }

    @PutMapping("/modificarProducto")
    private ResponseEntity<?> modificarProducto(@RequestBody ProductoDto producto){
        return productoService.modificarProducto(producto);
    }

    @DeleteMapping("/deleteProducto/{codigo}")
    private ResponseEntity<?> deleteProducto(@PathVariable String codigo){
        return productoService.deleteProducto(codigo);
    }

    @PutMapping("/actualizarStock/{codigo}")
    private ResponseEntity<?> actualizarStock(@PathVariable String codigo, @RequestBody int stock){
        return productoService.actualizarStock(codigo, stock);
    }
}
