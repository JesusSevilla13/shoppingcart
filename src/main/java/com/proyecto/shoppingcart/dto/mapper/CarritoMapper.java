package com.proyecto.shoppingcart.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proyecto.shoppingcart.dto.CarritoDto;
import com.proyecto.shoppingcart.entidades.Carrito;

@Mapper(componentModel = "spring")
public interface CarritoMapper {
    CarritoMapper MAPPER = Mappers.getMapper(CarritoMapper.class);

    CarritoDto modelToDto(Carrito carrito);

    @InheritInverseConfiguration
    Carrito dtoToModel(CarritoDto direccionesDto);
    
}
