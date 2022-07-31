package com.proyecto.shoppingcart.dto.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.proyecto.shoppingcart.dto.FacturaDto;
import com.proyecto.shoppingcart.entidades.Factura;

@Mapper(componentModel = "spring")
public interface FacturaMapper {
    FacturaMapper MAPPER = Mappers.getMapper(FacturaMapper.class);
    
    FacturaDto modelToDto(Factura factura);

    @InheritInverseConfiguration
    Factura dtoToModel(FacturaDto facturaDto);

    List<FacturaDto> modelToDtos(List<Factura> factura);
}
