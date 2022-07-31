package com.proyecto.shoppingcart.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/*
 * Clase tipo entidad para guardar los productos que estarán en las categorias
 */

@Getter
@Setter
@Entity
@Table(name = "TBL_Productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column (name = "Nombre")
    private String Nombre;
    @Column (name = "Precio")
    private Double Precio;
    @Column (name = "Id_Categorias")
    private Long Id_Categorias;
}
