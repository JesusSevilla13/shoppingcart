package com.proyecto.shoppingcart.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.shoppingcart.dto.DireccionesDto;
import com.proyecto.shoppingcart.dto.mapper.DireccionesMapper;
import com.proyecto.shoppingcart.entidades.Direcciones;
import com.proyecto.shoppingcart.excepciones.NoDataFoundException;
import com.proyecto.shoppingcart.repositorios.DireccionesRepository;
import com.proyecto.shoppingcart.servicios.IDireccionesService;

@Service
public class DireccionesServiceImpl implements IDireccionesService {

    @Autowired
    DireccionesRepository direccionesRepository;

    @Autowired
    DireccionesMapper direccionesMapper;

    @Override
    public List<DireccionesDto> listarDirecciones() {
        List<DireccionesDto> direccionesDtos = new ArrayList<>();
        List<Direcciones> direcciones = (List<Direcciones>) direccionesRepository.findAll();
        direccionesDtos = direccionesMapper.modelToDtos(direcciones);
        
        return direccionesDtos;
    }

    @Override
    public DireccionesDto buscarDirecciones(Long Id) {
        DireccionesDto direccionesDto = new DireccionesDto();
        if(direccionesRepository.findById(Id).isPresent()){
            direccionesDto = direccionesMapper.modelToDto(direccionesRepository.findById(Id).get());
        }else {
            throw new NoDataFoundException();
        }
        return direccionesDto;
    }

    @Override
    public DireccionesDto guardarDirecciones(DireccionesDto direccionesDto) {
        if(direccionesDto.getId()==0){
            Direcciones direcciones = new Direcciones();
            direcciones = direccionesMapper.dtoToModel(direccionesDto);
            direcciones = direccionesRepository.save(direcciones);
            direccionesDto = direccionesMapper.modelToDto(direcciones);
        }
        else {
            Direcciones direcciones = direccionesRepository.findById(direccionesDto.getId()).get();
            direcciones = direccionesMapper.dtoToModel(direccionesDto);
            direcciones = direccionesRepository.save(direcciones);
            direccionesDto = direccionesMapper.modelToDto(direcciones);
        }
        return direccionesDto;
    }

    @Override
    public void eliminarDirecciones(Long Id) {
        direccionesRepository.deleteById(Id);
        
    }
    
}
