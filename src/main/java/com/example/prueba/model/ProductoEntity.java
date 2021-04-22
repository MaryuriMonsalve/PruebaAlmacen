package com.example.prueba.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="producto")
public class ProductoEntity {

    @Id
    @Column(name = "id_producto", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(name= "nombre", length = 25)
    private String nombre;

    @Column(name= "precio")
    private Double precio;
}
