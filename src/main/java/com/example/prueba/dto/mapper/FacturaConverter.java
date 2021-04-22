package com.example.prueba.dto.mapper;

import com.example.prueba.dto.FacturaDto;
import com.example.prueba.model.FacturaEntity;
import org.springframework.stereotype.Component;

@Component
public class FacturaConverter implements EntityDTOMapper <FacturaEntity, FacturaDto> {
    private ClienteConverter clienteConverter;
    private ItemFacturaConverter itemFacturaConverter;

    public FacturaConverter(ClienteConverter clienteConverter, ItemFacturaConverter itemFacturaConverter){
        this.clienteConverter=clienteConverter;
        this.itemFacturaConverter=itemFacturaConverter;
    }
    @Override
    public FacturaEntity toEntity(FacturaDto dto) {

        FacturaEntity factura= new FacturaEntity();
        factura.setCliente(clienteConverter.toEntity(dto.getCliente()));
        factura.setDomicilio(dto.getDomicilio());
        factura.setIva(dto.getIva());
        factura.setTotal(dto.getTotal());
        factura.setItem(itemFacturaConverter.toListEntity(dto.getProductos()));
        factura.setCreateAt(dto.getHoraRegistro());

        return factura;
    }

    @Override
    public FacturaDto toDto(FacturaEntity entity) {


        FacturaDto dto = new FacturaDto();
        dto.setCliente(clienteConverter.toDto(entity.getCliente()));
        dto.setDomicilio(entity.getDomicilio());
        dto.setIva(entity.getIva());
        dto.setTotal(entity.getTotal());
        dto.setProductos(itemFacturaConverter.toDto(entity.getItem()));
        dto.setHoraRegistro(entity.getCreateAt());

        return dto;
    }

}
