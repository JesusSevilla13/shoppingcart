package com.proyecto.shoppingcart.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proyecto.shoppingcart.dto.UsuarioDto;
import com.proyecto.shoppingcart.entidades.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioMapper MAPPER = Mappers.getMapper(UsuarioMapper.class);
    
    UsuarioDto modelToDto(Usuario usuario);

    @InheritInverseConfiguration
    Usuario dtoToModel(UsuarioDto usuarioDto);

    List<UsuarioDto> modelToDtos(List<Usuario> usuarios);
}
