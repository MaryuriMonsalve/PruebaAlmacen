package com.example.prueba.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Cliente implements Serializable {

    private String cedula;
    private String direccion;

}
