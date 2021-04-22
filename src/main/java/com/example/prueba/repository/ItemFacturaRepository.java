package com.example.prueba.repository;

import com.example.prueba.model.ItemFacturaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemFacturaRepository extends CrudRepository<ItemFacturaEntity, Long> {
}
