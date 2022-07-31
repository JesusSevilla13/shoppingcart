package com.proyecto.shoppingcart.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.shoppingcart.entidades.Carrito;

/*
 * Interfaz repositorios para los CRUD de los productos
 */

@Repository
@Transactional
public interface CarritoRepository extends CrudRepository<Carrito, Long> {
    
}
