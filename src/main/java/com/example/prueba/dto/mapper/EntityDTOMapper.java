package com.example.prueba.dto.mapper;

public interface EntityDTOToMapper <E,D> {
    E toEntity(D dto);
    D toDto(E entity);
}
