package com.example.prueba.service.impl;

import com.example.prueba.model.ProductoEntity;
import com.example.prueba.repository.ProductoRepository;
import com.example.prueba.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoServiceImpl implements ProductoService {

    public ProductoRepository productoRepository;

   public ProductoServiceImpl(ProductoRepository productoRepository){
       this.productoRepository=productoRepository;
   }

@Override
public Long agregarProducto(ProductoEntity producto) {
       return productoRepository.save(producto).getIdProducto();
}

    @Override
    public List<ProductoEntity> listarProducto() {
        return (List<ProductoEntity>)productoRepository.findAll();
    }

    @Override
    public String eliminarProducto(Long id) {
        productoRepository.deleteById(id);
        return "El producto con id  " +  id  +"   se ha eliminado" ;
    }
}
