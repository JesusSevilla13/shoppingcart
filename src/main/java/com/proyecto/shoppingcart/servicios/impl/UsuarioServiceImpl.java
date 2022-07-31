package com.proyecto.shoppingcart.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.shoppingcart.dto.UsuarioDto;
import com.proyecto.shoppingcart.dto.mapper.UsuarioMapper;
import com.proyecto.shoppingcart.entidades.Usuario;
import com.proyecto.shoppingcart.excepciones.NoDataFoundException;
import com.proyecto.shoppingcart.repositorios.UsuarioRepository;
import com.proyecto.shoppingcart.servicios.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDto> listarUsuario() {
        List<UsuarioDto> usuarioDtos = new ArrayList<>();
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
        usuarioDtos = usuarioMapper.modelToDtos(usuarios);

        return usuarioDtos;
    }

    @Override
    public UsuarioDto buscarUsuario(Long Id) {
        UsuarioDto usuarioDto = new UsuarioDto();
        if(usuarioRepository.findById(Id).isPresent()){
            usuarioDto = usuarioMapper.modelToDto(usuarioRepository.findById(Id).get());
        } else {
            throw new NoDataFoundException();
        }
        return usuarioDto;
    }

    @Override
    public UsuarioDto guardarUsuario(UsuarioDto usuarioDto) {
        if(usuarioDto.getId()==0){
            Usuario usuario = new Usuario();
            usuario = usuarioMapper.dtoToModel(usuarioDto);
            usuario = usuarioRepository.save(usuario);
            usuarioDto = usuarioMapper.modelToDto(usuario);
        }
        else {
            Usuario usuario = usuarioRepository.findById(usuarioDto.getId()).get();
            usuario = usuarioMapper.dtoToModel(usuarioDto);
            usuario = usuarioRepository.save(usuario);
            usuarioDto = usuarioMapper.modelToDto(usuario);
        }
        return usuarioDto;
    }

    @Override
    public void eliminarUsuario(Long Id) {
        usuarioRepository.deleteById(Id);
        
    }
    
}
