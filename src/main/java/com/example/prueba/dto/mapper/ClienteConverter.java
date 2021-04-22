package com.example.prueba.dto.mapper;

import com.example.prueba.dto.ClienteDto;
import com.example.prueba.model.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter implements EntityDTOMapper<ClienteEntity, ClienteDto> {

    @Override
    public ClienteEntity toEntity(ClienteDto dto) {
        ClienteEntity cliente= new ClienteEntity();
        cliente.setIdCliente(dto.getId());
        cliente.setCedula(dto.getCedula());
        cliente.setDireccion(dto.getDireccion());
        return cliente;
    }

    @Override
    public ClienteDto toDto(ClienteEntity entity) {
        return null;
    }
}
