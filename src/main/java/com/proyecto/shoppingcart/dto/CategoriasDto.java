package com.proyecto.shoppingcart.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/*
 * Clase tipo Dto para enmascarar las categorias de la tienda
 */

@Getter
@Setter
public class CategoriasDto {
    private Long Id;
    private String Nombre;
    private List<String> Productos;
}
