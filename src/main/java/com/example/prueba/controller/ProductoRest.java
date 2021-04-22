package com.example.prueba.controller;

import com.example.prueba.model.ProductoEntity;
import com.example.prueba.service.impl.ProductoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Producto")
public class ProductoRest {

    public ProductoServiceImpl productoServiceImpl;

    public ProductoRest(ProductoServiceImpl productoServiceImpl){
        this.productoServiceImpl=productoServiceImpl;
    }

    @PostMapping("/agregar")
    public Long agregarProducto(ProductoEntity producto){
        return productoServiceImpl.agregarProducto(producto);
    }

    @GetMapping("/listar")
    public List<ProductoEntity> listarProductos(){
        return productoServiceImpl.listarProducto();
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable ("id") Long id){
       return productoServiceImpl.eliminarProducto(id);
    }


}
