package com.example.prueba.controller;

import com.example.prueba.dto.FacturaDto;
import com.example.prueba.model.FacturaEntity;
import com.example.prueba.service.impl.FacturaServiceImpl;
import com.example.prueba.service.impl.PedidoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoRest {

    public PedidoServiceImpl pedidoServiceImpl;
    public FacturaServiceImpl facturaServiceImpl;

    public PedidoRest(PedidoServiceImpl pedidoServiceImpl,
                      FacturaServiceImpl facturaServiceImpl){
        this.pedidoServiceImpl=pedidoServiceImpl;
        this.facturaServiceImpl=facturaServiceImpl;
    }

@PostMapping("/agregar")

    public FacturaDto agregarPedido(@RequestBody  FacturaDto factura){
        return facturaServiceImpl.agregarPedido(factura);

}
    @PostMapping("/modificar")
    public FacturaDto modificarPedido(@RequestBody FacturaDto factura){
        return facturaServiceImpl.editarPedido(factura);
    }



}
