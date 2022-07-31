package com.proyecto.shoppingcart.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/*
 * Clase Tipo Entidad para guardar los productos de las categorias
 */

@Getter
@Setter
@Entity
@Table(name = "TBL_Productos_Categorias")
public class CategProd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "Id_Categorias")
    private Long Id_Categorias;
    @Column(name = "Id_Productos")
    private Long Id_Productos;
}
