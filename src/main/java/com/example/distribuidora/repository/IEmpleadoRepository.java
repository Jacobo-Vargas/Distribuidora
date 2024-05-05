package com.example.distribuidora.repository;

import com.example.distribuidora.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> {

//    @Query("SELECT e FROM Empleado e WHERE e.id = :id")
//    Empleado getEmpleadoById(Long id);
}
