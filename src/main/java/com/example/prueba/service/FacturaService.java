package com.example.prueba.service;

import com.example.prueba.dto.FacturaDto;
import com.example.prueba.exception.PruebaException;
import com.example.prueba.model.FacturaEntity;

public interface FacturaService  {

    FacturaDto agregarPedido(FacturaDto factura) throws PruebaException;

    FacturaDto editarPedido(FacturaDto factura) throws PruebaException;

    void eliminarPedido(Long idFactura) throws PruebaException;


}
