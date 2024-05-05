package com.example.distribuidora.repository;

import com.example.distribuidora.mapping.dto.ProductoDto;
import com.example.distribuidora.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, String> {

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Producto e WHERE e.codigo = :codigo")
    boolean existsProductoByCodigo(String codigo);

    @Query("SELECT e FROM Producto e WHERE e.codigo = :codigo")
    Producto getProductoByCodigo(String codigo);

    @Modifying
    @Query("DELETE FROM Producto e WHERE e.codigo = :codigo")
    void deleteProductoByCodigo(String codigo);


}
