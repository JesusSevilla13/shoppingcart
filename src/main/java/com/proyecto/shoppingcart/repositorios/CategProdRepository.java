package com.proyecto.shoppingcart.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.shoppingcart.entidades.CategProd;

/*
 * Interfaz repositorios para los CRUD de los productos de las categorias
 */
@Repository
@Transactional
public interface CategProdRepository extends CrudRepository <CategProd, Long> {
    
    @Query(value = "SELECT tbl_productos.nombre FROM tbl_categorias,tbl_productos WHERE tbl_categorias.id = tbl_productos.id_categorias AND tbl_categorias.id = Id_Categorias", nativeQuery = true)
    Iterable<CategProd> BuscarPorIdCategorias(@Param("idCategoria") Long idCategoria);
    
    //SELECT tbl_productos.nombre FROM tbl_categorias,tbl_productos WHERE tbl_categorias.id = tbl_productos.id_categorias AND tbl_categorias.nombre = "PORTATILES"
    //"PORTATILES"  es cambiado por {{element.nombre}}

}
