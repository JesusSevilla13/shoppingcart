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
 * Clase tipo entidad para guardar las categorias de la tienda
 */

@Getter
@Setter
@Entity
@Table(name = "TBL_Categorias")
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column (name = "Nombre")
    private String Nombre;
}
