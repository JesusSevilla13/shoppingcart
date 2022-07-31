package com.proyecto.shoppingcart.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proyecto.shoppingcart.dto.DireccionesDto;
import com.proyecto.shoppingcart.entidades.Direcciones;

@Mapper(componentModel = "spring")
public interface DireccionesMapper {
    DireccionesMapper MAPPER = Mappers.getMapper(DireccionesMapper.class);
    
    DireccionesDto modelToDto(Direcciones direcciones);

    @InheritInverseConfiguration
    Direcciones dtoToModel(DireccionesDto direccionesDto);

    List<DireccionesDto> modelToDtos(List<Direcciones> direcciones);
}
