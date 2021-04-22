package com.example.prueba.service;

import com.example.prueba.dto.FacturaDto;
import com.example.prueba.model.ProductoEntity;

import java.util.List;

public interface PedidoService {

FacturaDto realizarPedido(Long idCliente, List<ProductoEntity> productos);
void editarPedido();
void eliminarPedido();

}
