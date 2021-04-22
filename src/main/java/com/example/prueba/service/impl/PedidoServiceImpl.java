package com.example.prueba.service.impl;

import com.example.prueba.dto.FacturaDto;
import com.example.prueba.model.ProductoEntity;
import com.example.prueba.repository.ClienteRepository;
import com.example.prueba.service.PedidoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    public ClienteRepository clienteRepository;

    PedidoServiceImpl(ClienteRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    @Override
    public FacturaDto realizarPedido(Long idCliente, List<ProductoEntity> productos) {
        BigDecimal total= new BigDecimal(0);
        FacturaDto factura= new FacturaDto();

    return factura;
    }



    @Override
    public void editarPedido() {

    }

    @Override
    public void eliminarPedido() {

    }
}
