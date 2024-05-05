package com.example.distribuidora.service;

import com.example.distribuidora.mapping.dto.CategoriaProductoDto;
import com.example.distribuidora.mapping.mapper.IDistribuidoraMapper;
import com.example.distribuidora.repository.ICategoriaProductoRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoriaProductoService {

    @Autowired
    ICategoriaProductoRepository categoriaProductoRepository;

    IDistribuidoraMapper distribuidoraMapper = Mappers.getMapper(IDistribuidoraMapper.class);

//    Permitir la creación, modificación, eliminación y actualización de las categorías productos

    public ResponseEntity<?> crearCategoria(CategoriaProductoDto categoriaProducto){
        if(categoriaProducto.id() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Verifique el código (id).");
        }
        boolean existe = categoriaProductoRepository.existsById(categoriaProducto.id());
        if(!existe){
            categoriaProductoRepository.save(distribuidoraMapper.CategoriaProductoDtotoCategoriaProducto(categoriaProducto));
            return ResponseEntity.ok().body("Se registró con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("La categoría ya existe, verifique el código (id).");
        }
    }

    public ResponseEntity<?> modificarCategoria(CategoriaProductoDto categoriaProducto){
        if(categoriaProducto.id() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Verifique el código (id).");
        }
        boolean existe = categoriaProductoRepository.existsById(categoriaProducto.id());
        if(!existe){
            categoriaProductoRepository.save(distribuidoraMapper.CategoriaProductoDtotoCategoriaProducto(categoriaProducto));
            return ResponseEntity.ok().body("Se actualizó con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La categoría no existe.");
        }
    }

    public ResponseEntity<?> eliminarCategoria(Long id){
        if(id == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Verifique el código (id).");
        }
        boolean existe = categoriaProductoRepository.existsById(id);
        if(existe){
            categoriaProductoRepository.deleteById(id);
            return ResponseEntity.ok().body("Se eliminó con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La categoría no existe.");
        }
    }
}
