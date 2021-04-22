package com.example.prueba.repository;

import com.example.prueba.model.ProductoEntity;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository <ProductoEntity, Long> {


}
