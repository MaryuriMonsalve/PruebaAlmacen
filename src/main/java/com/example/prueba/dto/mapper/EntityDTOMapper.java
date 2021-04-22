package com.example.prueba.dto.mapper;

public interface EntityDTOMapper<E,D> {
    E toEntity(D dto);
    D toDto(E entity);
}
