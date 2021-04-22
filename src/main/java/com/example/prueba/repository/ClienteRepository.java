package com.example.prueba.repository;

import com.example.prueba.model.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity,Long> {

    ClienteEntity findByCedula(String cedula);


}
