package com.example.distribuidora.service;

import com.example.distribuidora.entities.Producto;
import com.example.distribuidora.mapping.dto.ProductoDto;
import com.example.distribuidora.mapping.mapper.IDistribuidoraMapper;
import com.example.distribuidora.repository.IProductoRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService {

    @Autowired
    IProductoRepository productoRepository;

    IDistribuidoraMapper distribuidoraMapper = Mappers.getMapper(IDistribuidoraMapper.class);

//    Permitir la creación, modificación, eliminación y actualización de la cantidad en stock de los productos

    public ResponseEntity<?> creaProducto(ProductoDto productoDto){
        boolean existe = productoRepository.existsProductoByCodigo(productoDto.codigo());
        if (!existe){
            productoRepository.save(distribuidoraMapper.ProductoDtotoProducto(productoDto));
            return ResponseEntity.ok().body("Se registro exitosamente.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Verifique el producto, código ya existe.");
        }
    }

    public ResponseEntity<?> modificarProducto(ProductoDto productoDto){
        boolean existe = productoRepository.existsProductoByCodigo(productoDto.codigo());
        if (existe){
           // productoRepository.deleteProductoByCodigo(productoDto.codigo());
            productoRepository.save(distribuidoraMapper.ProductoDtotoProducto(productoDto));
            return ResponseEntity.ok().body("Se modificó exitosamente.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Verifique el producto, código no existe.");
        }
    }
    @Transactional
    public ResponseEntity<?> deleteProducto(String codigo){
        boolean existe = productoRepository.existsProductoByCodigo(codigo);
        if(existe){
            productoRepository.deleteProductoByCodigo(codigo);
            return ResponseEntity.ok().body("Se eliminó satisfactoriamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Verifique el código del producto, no existe en la base de datos.");
        }
    }

    public ResponseEntity<?> actualizarStock(String codigo, int stock){
        Producto existente = productoRepository.getProductoByCodigo(codigo);
        if(existente != null){
            existente.setCantidadStock(stock);
            productoRepository.save(existente);
            return ResponseEntity.ok().body("Se actualizó correctamente la cantidad en stock.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Verifique el código del producto, no existe en la base de datos.");
        }
    }
}
