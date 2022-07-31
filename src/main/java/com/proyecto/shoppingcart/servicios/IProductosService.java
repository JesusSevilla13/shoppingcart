package com.proyecto.shoppingcart.servicios;

import java.util.List;

import com.proyecto.shoppingcart.dto.ProductosDto;

public interface IProductosService {
    List<ProductosDto> listarProductos();
    ProductosDto buscarProductos(Long Id);
    ProductosDto guardarProductos(ProductosDto productosDto);
    void eliminarProductos(Long Id);
}
