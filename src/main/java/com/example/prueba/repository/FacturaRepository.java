package com.example.prueba.repository;

import com.example.prueba.model.FacturaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends CrudRepository<FacturaEntity, Long> {
}
