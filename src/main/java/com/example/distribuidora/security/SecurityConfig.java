package com.example.distribuidora.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests(request -> {
            //Endpoints de empleado
            request.requestMatchers("empleado/crearEmpleado").permitAll();
            request.requestMatchers("empleado/modificarEmpleado").permitAll();
            request.requestMatchers("empleado/editarEstado/{id}").authenticated();
            request.requestMatchers("empleado/obtenerEmpleados").permitAll();
            request.requestMatchers("empleado/obtenerEmpleado/{id}").permitAll();

            // Endpoints  de categoríaProducto
            request.requestMatchers("categoriaProducto/crearCategoria").permitAll();
            request.requestMatchers("categoriaProducto/modificarCategoria").permitAll();
            request.requestMatchers("categoriaProducto/eliminarCategoria/{id}").authenticated();

            // Endpoints de producto
            request.requestMatchers("producto/crearProducto").permitAll();
            request.requestMatchers("producto/modificarProducto").permitAll();
            request.requestMatchers("producto/deleteProducto/{codigo}").authenticated();
            request.requestMatchers("producto/actualizarStock/{codigo}").authenticated();

            // endpoint del TRM
            request.requestMatchers("dollar/obtenerValor").permitAll();

        }).httpBasic(Customizer.withDefaults());

        return http.build();
    }
}