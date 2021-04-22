package com.example.prueba.dto;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FacturaDto  {

    private Long numFactura;
    ClienteDto cliente;
    List<ItemFacturaDto> productos;
    private Double subtotal;
    private Double iva;
    private Double domicilio;
    private Double total;
    private LocalDateTime horaRegistro;
}
