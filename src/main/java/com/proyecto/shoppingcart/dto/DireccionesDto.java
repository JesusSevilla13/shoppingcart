package com.proyecto.shoppingcart.dto;

import lombok.Getter;
import lombok.Setter;

/*
 * Clase tipo Dto para enmascarar las direcciones del usuario
 */

@Getter
@Setter
public class DireccionesDto {
    private Long Id;
    private Long Id_Usuario;
    private String Direccion;
}
