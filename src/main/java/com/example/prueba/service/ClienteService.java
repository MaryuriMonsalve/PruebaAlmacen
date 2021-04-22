package com.example.prueba.service;


import com.example.prueba.model.ClienteEntity;

import java.util.List;

public interface ClienteService {
    ClienteEntity agregarCliente(ClienteEntity c);
    List<ClienteEntity> listarCliente();
    String eliminarCliente( Long id);
}
