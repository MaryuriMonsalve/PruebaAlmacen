package com.example.prueba.service.impl;


import com.example.prueba.model.ClienteEntity;
import com.example.prueba.repository.ClienteRepository;
import com.example.prueba.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteServiceImpl implements ClienteService {


    public ClienteRepository clienteRepository;

    public ClienteServiceImpl (ClienteRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    @Override
    public ClienteEntity agregarCliente(ClienteEntity cliente) {

     return clienteRepository.save(cliente);
    }

    @Override
    public List<ClienteEntity> listarCliente() {
        return (List<ClienteEntity>) clienteRepository.findAll();
    }

    @Override
    public String eliminarCliente(Long id) {
      clienteRepository.deleteById(id);
        return "El cliente con el id  " +  id  + "  ha sido eliminado";
    }
}
