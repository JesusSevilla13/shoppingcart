package com.proyecto.shoppingcart.dto;

import lombok.Getter;
import lombok.Setter;

/*
 * Clase Tipo Dto para  enmascarar las respuestas de los datos de los microservicios
 */

 @Getter
 @Setter
public class ResponseDto {
    private int codigoRespuesta;
    private String mensaje; 
    private Object data; 
}
