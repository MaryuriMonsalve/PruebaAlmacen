package com.example.prueba.dto.mapper;

import com.example.prueba.dto.ItemFacturaDto;
import com.example.prueba.model.ItemFacturaEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemFacturaConverter implements EntityDTOMapper<ItemFacturaEntity, ItemFacturaDto> {

    private ProductoConverter productoConverter;

    public ItemFacturaConverter(ProductoConverter productoConverter){
        this.productoConverter= productoConverter;
    }

    @Override
    public ItemFacturaEntity toEntity(ItemFacturaDto dto) {
            ItemFacturaEntity entidad= new ItemFacturaEntity();
            entidad.setCantidad(dto.getCantidad());
            entidad.setProducto(productoConverter.toEntity(dto.getProducto()));
            return entidad;
    }

    @Override
    public ItemFacturaDto toDto(ItemFacturaEntity entity) {
        return null;
    }

    public List<ItemFacturaEntity> toListEntity(List<ItemFacturaDto> item){
        List<ItemFacturaEntity> items= new ArrayList<>();
        for (ItemFacturaDto i: item) {
            items.add(toEntity(i));
        }
        return items;
    }

       public List <ItemFacturaDto> toDto(List <ItemFacturaEntity> entity)
    {
        List<ItemFacturaDto> items= new ArrayList<>();
        for (ItemFacturaEntity i: entity) {
            items.add(toDto(i));
        }
        return items;
    }
    }

