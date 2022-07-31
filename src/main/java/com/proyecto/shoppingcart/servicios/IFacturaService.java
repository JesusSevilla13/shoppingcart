package com.proyecto.shoppingcart.servicios;

import java.util.List;

import com.proyecto.shoppingcart.dto.FacturaDto;

public interface IFacturaService {
    List<FacturaDto> listarFactura();
    FacturaDto guardarFactura(FacturaDto facturaDto);
}
