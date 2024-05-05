package com.example.distribuidora.controller;

import com.example.distribuidora.mapping.dto.EmpleadoDto;
import com.example.distribuidora.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("empleado")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

//    Permitir la creación, modificación, activación y desactivación de empleados.

    @PostMapping("/crearEmpleado")
    private ResponseEntity<String> crearEmpleado(@RequestBody EmpleadoDto empleado){
        return empleadoService.crearEmpleado(empleado);
    }

    @PutMapping("/modificarEmpleado")
    private ResponseEntity<?> modificarEmpleado(@RequestBody EmpleadoDto empleado){
        return empleadoService.modificarEmpleado(empleado);
    }

    @PutMapping("/editarEstado/{id}")
    private ResponseEntity<?> editarEstado(@PathVariable Long id, @RequestBody String estado){
        return empleadoService.editarEstado(id, estado);
    }

    @GetMapping("/obtenerEmpleado/{id}")
    private ResponseEntity<?> obtenerEmpleado(@PathVariable Long id){
        return empleadoService.obtenerEmpleado(id);
    }

    @GetMapping("/obtenerEmpleados")
    private ResponseEntity<?> obtenerEmpleados(){
        return empleadoService.obtenerEmpleados();
    }

}
