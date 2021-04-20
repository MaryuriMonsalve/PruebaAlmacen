package com.example.prueba.dto.mapper;

import com.example.prueba.dto.FacturaDto;
import com.example.prueba.model.FacturaEntity;

public class FacturaEntityToDto implements EntityDTOMapper <FacturaEntity, FacturaDto> {
    @Override
    public FacturaEntity toEntity(FacturaDto dto) {

        FacturaEntity factura= new FacturaEntity();
        factura.setCliente(dto.getCliente());
        factura.setDomicilio(dto.getDomicilio());
        factura.setIva(dto.getIva());
        factura.setProducto(dto.getProductos());
        return factura;
    }

    @Override
    public FacturaDto toDto(FacturaEntity entity) {
        return null;
    }


}
