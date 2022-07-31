package com.proyecto.shoppingcart.servicios;

import com.proyecto.shoppingcart.dto.CarritoDto;

public interface ICarritoService {
    CarritoDto guardarCarrito(CarritoDto carritoDto);
    void eliminarCarrito(Long Id);
}
