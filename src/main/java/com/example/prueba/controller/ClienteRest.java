package com.example.prueba.controller;

import com.example.prueba.model.ClienteEntity;
import com.example.prueba.service.impl.ClienteServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cliente")
public class ClienteRest {

    public ClienteServiceImpl clienteServiceImpl;

    public ClienteRest(ClienteServiceImpl clienteServiceImpl){
        this.clienteServiceImpl=clienteServiceImpl;
    }

    @PostMapping("/agregar")
    public ClienteEntity agregarCliente(ClienteEntity clienteEntity){
        return clienteServiceImpl.agregarCliente(clienteEntity);
    }

    @GetMapping("/listar")
    public List<ClienteEntity> listarCliente(){
        return clienteServiceImpl.listarCliente();
    }

    @DeleteMapping("eliminar")
    public String eliminarCliente(Long id){
        return clienteServiceImpl.eliminarCliente(id);
    }


}
