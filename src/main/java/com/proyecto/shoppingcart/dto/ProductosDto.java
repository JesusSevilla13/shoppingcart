package com.proyecto.shoppingcart.dto;

import lombok.Getter;
import lombok.Setter;

/*
 * Clase tipo Dto para enmascarar los productos que estarán en las categorias
 */

@Getter
@Setter
public class ProductosDto {
    private Long Id;
    private String Nombre;
    private Double Precio;
    private Long Id_Categorias;
}
