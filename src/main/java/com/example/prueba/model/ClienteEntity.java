package com.example.prueba.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @Column(name = "id_cliente", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(name= "Cedula", unique= true, nullable = false, length = 15)
    private String Cedula;

    @Column(name= "direccion", length = 60)
    private String direccion;
}
