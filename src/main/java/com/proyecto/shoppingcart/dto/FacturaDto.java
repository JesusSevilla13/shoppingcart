package com.proyecto.shoppingcart.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/*
 * Clase tipo Dto para enmascarar los detalles de la compra hecha por el usuario
 */

@Getter
@Setter
public class FacturaDto {
    private Long Id;
    private Long Id_Producto;
    private Long Cantidad;
    private String Nombre;
    private Long Id_Direcciones;
    private String Nombre_Usuario;
    private Date Fecha;
    private Double Precio;
}
