package com.proyecto.shoppingcart.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proyecto.shoppingcart.dto.ProductosDto;
import com.proyecto.shoppingcart.entidades.Productos;

@Mapper(componentModel = "spring")
public interface ProductosMapper {
    ProductosMapper MAPPER = Mappers.getMapper(ProductosMapper.class);
    
    ProductosDto modelToDto(Productos productos);

    @InheritInverseConfiguration
    Productos dtoToModel(ProductosDto productosDto);

    List<ProductosDto> modelToDtos(List<Productos> productos);
    
}
