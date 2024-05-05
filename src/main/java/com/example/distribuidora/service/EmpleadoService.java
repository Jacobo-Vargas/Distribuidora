package com.example.distribuidora.service;

import com.example.distribuidora.entities.Empleado;
import com.example.distribuidora.mapping.dto.EmpleadoDto;
import com.example.distribuidora.mapping.mapper.IDistribuidoraMapper;
import com.example.distribuidora.repository.IEmpleadoRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    IEmpleadoRepository iEmpleadoRepository;

    IDistribuidoraMapper distribuidoraMapper = Mappers.getMapper(IDistribuidoraMapper.class);

    public ResponseEntity<String> crearEmpleado(EmpleadoDto empleadoDto){
        if(empleadoDto.id() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id no puede ser null.");
        }
        boolean existe = iEmpleadoRepository.existsById(empleadoDto.id());
        if(!existe){
            Empleado empleado = distribuidoraMapper.EmpleadoDtotoEmpleado(empleadoDto);
            empleado.setId(empleadoDto.id());
            iEmpleadoRepository.save(empleado);
            return ResponseEntity.ok().body("Se registro con éxito.");
        } else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("El usuario ya existe");
        }
    }

    public ResponseEntity<?> modificarEmpleado(EmpleadoDto empleadoDto){
        boolean existe = iEmpleadoRepository.existsById(empleadoDto.id());
        if(existe){
            Empleado empleado = distribuidoraMapper.EmpleadoDtotoEmpleado(empleadoDto);
            empleado.setId(empleadoDto.id());
            iEmpleadoRepository.save(empleado);
            return ResponseEntity.ok().body("Se actualizó con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("El usuario no existe");
        }
    }

    public ResponseEntity<?> editarEstado(Long id, String estado){
        Empleado empleado = iEmpleadoRepository.findById(id).orElse(null);
        if(empleado != null){
            empleado.setEstado(String.valueOf(estado));
            iEmpleadoRepository.save(empleado);
            return ResponseEntity.ok().body(empleado);
        } else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("El usuario no existe");
        }
    }

    public ResponseEntity<?> obtenerEmpleado(Long id){
        EmpleadoDto empleado = distribuidoraMapper.EmpleadotoEmpleadoDto(iEmpleadoRepository.findById(id).orElse(null));
        if(empleado != null){
            return ResponseEntity.ok().body(empleado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El empleado no existe.");
        }
    }

    public ResponseEntity<?> obtenerEmpleados(){
        List<EmpleadoDto> listaEmpleados = distribuidoraMapper.getEmpleadosDto(iEmpleadoRepository.findAll());
        if(listaEmpleados.size() > 0){
            return ResponseEntity.ok().body(listaEmpleados);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existen empleados registrados");
        }
    }


}
