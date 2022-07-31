package com.proyecto.shoppingcart.servicios;

import java.util.List;

import com.proyecto.shoppingcart.dto.UsuarioDto;

public interface IUsuarioService {
    List<UsuarioDto> listarUsuario();
    UsuarioDto buscarUsuario(Long Id);
    UsuarioDto guardarUsuario(UsuarioDto usuarioDto);
    void eliminarUsuario(Long Id);
}
