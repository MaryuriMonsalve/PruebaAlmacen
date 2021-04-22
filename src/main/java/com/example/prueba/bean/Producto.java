package com.example.prueba.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Producto implements Serializable {

    private String nombre;
    private BigDecimal precio;
}
