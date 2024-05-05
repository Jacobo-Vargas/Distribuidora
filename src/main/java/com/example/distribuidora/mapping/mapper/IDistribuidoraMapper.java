package com.example.distribuidora.mapping.mapper;

import com.example.distribuidora.entities.CategoriaProducto;
import com.example.distribuidora.entities.Empleado;
import com.example.distribuidora.entities.Producto;
import com.example.distribuidora.mapping.dto.CategoriaProductoDto;
import com.example.distribuidora.mapping.dto.EmpleadoDto;
import com.example.distribuidora.mapping.dto.ProductoDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface IDistribuidoraMapper {

    @Named("localDateToDate")
    default Date localDateToDate(LocalDate localDate) {
        return localDate != null ? Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()) : null;
    }

    @Named("EmpleadotoEmpleadoDto")
    @Mapping(target = "fechaContratacion", qualifiedByName = "localDateToDate")
    EmpleadoDto EmpleadotoEmpleadoDto(Empleado empleado);

    @Named("EmpleadoDtotoEmpleado")
    Empleado EmpleadoDtotoEmpleado(EmpleadoDto empleadoDto);

    @IterableMapping(qualifiedByName = "EmpleadotoEmpleadoDto")
    List<EmpleadoDto> getEmpleadosDto(List<Empleado> lista);

    @Named("ProductotoProductoDto")
    ProductoDto ProductotoProductoDto(Producto producto);
    @Named("ProductoDtotoProducto")
    Producto ProductoDtotoProducto(ProductoDto productoDto);

    @Named("CategoriaProductotoCategoriaProductoDto")
    CategoriaProductoDto CategoriaProductotoCategoriaProductoDto(CategoriaProducto categoriaProducto);
    @Named("CategoriaProductoDtotoCategoriaProducto")
    CategoriaProducto CategoriaProductoDtotoCategoriaProducto(CategoriaProductoDto categoriaProductoDto);

}
