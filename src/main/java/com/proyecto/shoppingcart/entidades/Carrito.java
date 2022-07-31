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
 * Clase tipo entidad para guardar los productos seleccionados antes del check-out
 */

@Getter
@Setter
@Entity
@Table(name = "TBL_Carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column (name = "Id_Producto")
    private Long Id_Producto;
    @Column (name = "Id_Usuario")
    private Long Id_Usuario;
    @Column (name = "Precio")
    private Double Precio;
    @Column (name = "Cantidad")
    private Long Cantidad;
    @Column (name = "Nombre")
    private String Nombre;
}
