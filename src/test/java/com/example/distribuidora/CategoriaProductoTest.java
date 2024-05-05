package com.example.distribuidora;

import com.example.distribuidora.entities.CategoriaProducto;
import com.example.distribuidora.mapping.dto.CategoriaProductoDto;
import com.example.distribuidora.repository.ICategoriaProductoRepository;
import com.example.distribuidora.service.CategoriaProductoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CategoriaProductoTest {
    @InjectMocks
    private CategoriaProductoService categoriaProductoService;

    @Mock
    private ICategoriaProductoRepository categoriaProductoRepository;


    @Test
    void testCrearCategoria() {
        // Configurar datos de prueba
        CategoriaProductoDto categoriaProductoDto = new CategoriaProductoDto(1L,"TECNOLOGIA", "categoria tecnologica");

        // Simular el comportamiento del repositorio
        when(categoriaProductoRepository.save(any(CategoriaProducto.class))).thenReturn(new CategoriaProducto());
        // Ejecutar el método bajo prueba
        ResponseEntity<?> responseEntity = categoriaProductoService.crearCategoria(categoriaProductoDto);
        // Verificar el resultado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testIdNulo(){
        CategoriaProductoDto categoriaProductoDto = new CategoriaProductoDto(null,"TECNOLOGIA","descripcion");
        ResponseEntity<?> responseEntity = categoriaProductoService.modificarCategoria(categoriaProductoDto);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void noExisteCategoria(){
        CategoriaProductoDto categoriaProductoDto = new CategoriaProductoDto(5L,"TECNOLOGIA","descripcion");
        when(categoriaProductoRepository.existsById(categoriaProductoDto.id())).thenReturn(true);
        ResponseEntity<?> response = categoriaProductoService.modificarCategoria(categoriaProductoDto);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}
