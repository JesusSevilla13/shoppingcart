package com.proyecto.shoppingcart.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/*
 * Clase tipo entidad para guardar los detalles de la compra hecha por el usuario
 */

@Getter
@Setter
@Entity
@Table(name = "TBL_Factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column (name = "Id_Producto")
    private Long Id_Producto;
    @Column (name = "Cantidad")
    private Long Cantidad;
    @Column (name = "Nombre")
    private String Nombre;
    @Column (name = "Id_Direcciones")
    private Long Id_Direcciones;
    @Column (name = "Nombre_Usuario")
    private String Nombre_Usuario;
    @Column (name = "Fecha")
    private Date Fecha;
    @Column (name = "Precio")
    private Double Precio;
}
