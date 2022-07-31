package com.proyecto.shoppingcart.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.shoppingcart.entidades.Direcciones;

/*
 * Interfaz repositorios para los CRUD de las direcciones
 */

 @Repository
 @Transactional
public interface DireccionesRepository extends CrudRepository<Direcciones, Long>{
    
}
