package com.example.prueba.dto.mapper;

import com.example.prueba.dto.ProductoDto;
import com.example.prueba.model.ProductoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductoConverter implements EntityDTOMapper<ProductoEntity, ProductoDto> {
    @Override
    public ProductoEntity toEntity(ProductoDto dto) {
        ProductoEntity producto = new ProductoEntity();
        producto.setIdProducto(dto.getId());
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());

        return producto;
    }
    public List<ProductoEntity> toListEntity(List<ProductoDto> productos){
        List<ProductoEntity> products= new ArrayList<>();
        for (ProductoDto p: productos) {
            products.add(toEntity(p));
        }
        return products;
    }



    @Override
    public ProductoDto toDto(ProductoEntity entity) {
        return null;
    }
}
