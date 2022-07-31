package com.proyecto.shoppingcart.servicios;

import java.util.List;

import com.proyecto.shoppingcart.dto.CategoriasDto;

public interface ICategoriasService {
    List<CategoriasDto> listarCategorias();
    CategoriasDto buscarCategorias(Long Id);
    List<CategoriasDto> listarPoductosOfCategorias();
    CategoriasDto guardarCategorias(CategoriasDto categoriasDto);
    void eliminarCategorias(Long Id);
}
