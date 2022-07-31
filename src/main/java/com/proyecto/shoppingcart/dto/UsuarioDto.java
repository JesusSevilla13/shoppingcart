package com.proyecto.shoppingcart.dto;

import lombok.Getter;
import lombok.Setter;

/*
 * Clase tipo Dto para enmascarar los datos de los usuarios o compradores
 */

@Getter
@Setter
public class UsuarioDto {
    private Long Id;
    private String Nombre;
    private String Apellido;
    private Long Celular;
    private String Email;
}
