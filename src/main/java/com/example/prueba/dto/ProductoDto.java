package com.example.prueba.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoDto {

    private Long id;
    private String nombre;
    private Double precio;
}
