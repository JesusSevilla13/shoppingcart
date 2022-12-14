package com.proyecto.shoppingcart.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.shoppingcart.entidades.Usuario;

/*
 * Interfaz repositorios para los CRUD del usuario
 */

 @Repository
 @Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    
}
