package com.proyecto.shoppingcart.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/*
 * Clase tipo Dto para enmascarar los productos seleccionados en el carrito
 */

@Getter
@Setter
public class CarritoDto {
    private Long Id;
    private Long Id_Producto;
    private Long Id_Usuario;
    private Double Precio;
    private Long Cantidad;
    private String Nombe;
    private List<String> Direcciones; //Listar las direcciones que tiene un usuario
    private List<Long> AsignarDireccion; //Guardar la direccion al momento del envío 
}
