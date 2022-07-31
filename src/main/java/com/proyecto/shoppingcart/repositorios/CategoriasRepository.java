package com.proyecto.shoppingcart.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.shoppingcart.entidades.Categorias;

/*
 * Interfaz repositorios para los CRUD de las categorias
 */

 @Repository
 @Transactional
public interface CategoriasRepository extends CrudRepository<Categorias, Long> {
    
}
