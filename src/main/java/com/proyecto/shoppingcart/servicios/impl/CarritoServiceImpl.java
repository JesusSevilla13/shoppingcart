package com.proyecto.shoppingcart.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.shoppingcart.dto.CarritoDto;
import com.proyecto.shoppingcart.dto.mapper.CarritoMapper;
import com.proyecto.shoppingcart.entidades.Carrito;
import com.proyecto.shoppingcart.repositorios.CarritoRepository;
import com.proyecto.shoppingcart.servicios.ICarritoService;

@Service
public class CarritoServiceImpl implements ICarritoService{

    @Autowired
    CarritoRepository carritoRepository;

    @Autowired
    CarritoMapper carritoMapper;

    @Override
    public CarritoDto guardarCarrito(CarritoDto carritoDto) {
        if(carritoDto.getId()==0){
            Carrito carrito = new Carrito();
            carrito = carritoMapper.dtoToModel(carritoDto);
            carrito = carritoRepository.save(carrito);
            carritoDto = carritoMapper.modelToDto(carrito);
        }
        else {
            Carrito categorias = carritoRepository.findById(carritoDto.getId()).get();
            categorias = carritoMapper.dtoToModel(carritoDto);
            categorias = carritoRepository.save(categorias);
            carritoDto = carritoMapper.modelToDto(categorias);
        }
        return carritoDto;
    }

    @Override
    public void eliminarCarrito(Long Id) {
        carritoRepository.deleteById(Id);
        
    }
    
}
