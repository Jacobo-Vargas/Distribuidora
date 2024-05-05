package com.example.distribuidora;

import com.example.distribuidora.mapping.dto.EmpleadoDto;
import com.example.distribuidora.service.EmpleadoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestEmpleado {

    @InjectMocks
    EmpleadoService empleadoService;

    @Test
    void TestObtenerEmpleadoIdNull(){
        // Preparación
        EmpleadoDto empleadoDto = new EmpleadoDto(null, "Nombre", "Apellido",1L,"ninguno",LocalDate.now(),"ACTIVO");

        // Ejecución
        ResponseEntity<?> responseEntity = empleadoService.crearEmpleado(empleadoDto);

        // Verificación
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}
