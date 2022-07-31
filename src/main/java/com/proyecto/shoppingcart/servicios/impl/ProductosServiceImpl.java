package com.proyecto.shoppingcart.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.shoppingcart.dto.ProductosDto;
import com.proyecto.shoppingcart.dto.mapper.ProductosMapper;
import com.proyecto.shoppingcart.entidades.Productos;
import com.proyecto.shoppingcart.excepciones.NoDataFoundException;
import com.proyecto.shoppingcart.repositorios.ProductosRepository;
import com.proyecto.shoppingcart.servicios.IProductosService;

@Service
public class ProductosServiceImpl implements IProductosService{

    @Autowired
    ProductosRepository productosRepository;

    @Autowired
    ProductosMapper productosMapper;

    @Override
    public List<ProductosDto> listarProductos() {
        List<ProductosDto> productosDtos = new ArrayList<>();
        List<Productos> productos = (List<Productos>) productosRepository.findAll();
        productosDtos = productosMapper.modelToDtos(productos);

        return productosDtos;
    }

    @Override
    public ProductosDto buscarProductos(Long Id) {
        ProductosDto productosDto = new ProductosDto();
        if(productosRepository.findById(Id).isPresent()){
            productosDto = productosMapper.modelToDto(productosRepository.findById(Id).get());
        } else {
            throw new NoDataFoundException();
        }
        return productosDto;
    }

    @Override
    public ProductosDto guardarProductos(ProductosDto productosDto) {
        if(productosDto.getId()==0){
            Productos productos = new Productos();
            productos = productosMapper.dtoToModel(productosDto);
            productos = productosRepository.save(productos);
            productosDto = productosMapper.modelToDto(productos);
        }
        else {
            Productos productos = productosRepository.findById(productosDto.getId()).get();
            productos = productosMapper.dtoToModel(productosDto);
            productos = productosRepository.save(productos);
            productosDto = productosMapper.modelToDto(productos);
        }
        return productosDto;
    }

    @Override
    public void eliminarProductos(Long Id) {
        productosRepository.deleteById(Id);
        
    }
    
}
