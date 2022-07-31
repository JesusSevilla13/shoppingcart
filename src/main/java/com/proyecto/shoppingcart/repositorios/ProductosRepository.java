package com.proyecto.shoppingcart.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.shoppingcart.entidades.Productos;

/*
 * Interfaz repositorios para los CRUD de los productos
 */

 @Repository
 @Transactional
public interface ProductosRepository extends CrudRepository<Productos, Long> {

}
