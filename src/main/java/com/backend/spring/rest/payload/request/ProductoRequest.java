package com.backend.spring.rest.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductoRequest {


    private String nombre;
    private String  apellido;
    private String  domicilio;
    private String dni;
    private LocalDateTime fecha;
    private String calle;
    private String localidad;
    private String ciudad;




    }

