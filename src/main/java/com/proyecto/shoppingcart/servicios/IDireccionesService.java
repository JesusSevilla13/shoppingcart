package com.proyecto.shoppingcart.servicios;

import java.util.List;

import com.proyecto.shoppingcart.dto.DireccionesDto;

public interface IDireccionesService {
    List<DireccionesDto> listarDirecciones();
    DireccionesDto buscarDirecciones(Long Id);
    DireccionesDto guardarDirecciones(DireccionesDto direccionesDto);
    void eliminarDirecciones(Long Id);
}
