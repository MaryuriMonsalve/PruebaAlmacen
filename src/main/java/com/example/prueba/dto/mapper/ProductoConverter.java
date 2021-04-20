package com.example.prueba.dto.mapper;

import com.example.prueba.dto.ProductoDto;
import com.example.prueba.model.ProductoEntity;

public class ProductoEntityToDto implements EntityDTOMapper<ProductoEntity, ProductoDto> {
    @Override
    public ProductoEntity toEntity(ProductoDto dto) {
        ProductoEntity producto = new ProductoEntity();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());

        return producto;
    }

    @Override
    public ProductoDto toDto(ProductoEntity entity) {
        return null;
    }
}
