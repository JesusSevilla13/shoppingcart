package com.proyecto.shoppingcart.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.shoppingcart.dto.FacturaDto;
import com.proyecto.shoppingcart.dto.mapper.FacturaMapper;
import com.proyecto.shoppingcart.entidades.Factura;
import com.proyecto.shoppingcart.repositorios.FacturaRepository;
import com.proyecto.shoppingcart.servicios.IFacturaService;

@Service
public class FacturaServiceImpl implements IFacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    FacturaMapper facturaMapper;

    @Override
    public List<FacturaDto> listarFactura() {
        List<FacturaDto> facturaDtos = new ArrayList<>();
        List<Factura> factura = (List<Factura>) facturaRepository.findAll();
        facturaDtos = facturaMapper.modelToDtos(factura);

        return facturaDtos;
    }

    @Override
    public FacturaDto guardarFactura(FacturaDto facturaDto) {
        if(facturaDto.getId()==0){
            Factura factura = new Factura();
            factura = facturaMapper.dtoToModel(facturaDto);
            factura = facturaRepository.save(factura);
            facturaDto = facturaMapper.modelToDto(factura);
        }
        else {
            Factura factura = facturaRepository.findById(facturaDto.getId()).get();
            factura = facturaMapper.dtoToModel(facturaDto);
            factura = facturaRepository.save(factura);
            facturaDto = facturaMapper.modelToDto(factura);
        }
        return facturaDto;
    }
    
}
