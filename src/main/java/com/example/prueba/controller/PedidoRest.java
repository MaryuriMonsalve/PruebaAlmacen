package com.example.prueba.controller;

import com.example.prueba.dto.FacturaDto;
import com.example.prueba.service.impl.FacturaServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedido")
public class PedidoRest {


    public FacturaServiceImpl facturaServiceImpl;

    public PedidoRest(
                      FacturaServiceImpl facturaServiceImpl){
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

    @DeleteMapping("/Delete")
    public Double eliminarPedido(@RequestParam Long id){
        return facturaServiceImpl.eliminarPedido(id);
    }



}
