package com.example.prueba.service;

import com.example.prueba.model.ProductoEntity;

import java.util.List;


public interface ProductoService {
    Long agregarProducto(ProductoEntity producto);
    List<ProductoEntity> listarProducto();
    String eliminarProducto(Long id);

}
