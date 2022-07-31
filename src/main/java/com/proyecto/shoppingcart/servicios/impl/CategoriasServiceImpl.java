package com.proyecto.shoppingcart.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.shoppingcart.dto.CategoriasDto;
import com.proyecto.shoppingcart.dto.mapper.CategoriasMapper;
import com.proyecto.shoppingcart.entidades.CategProd;
import com.proyecto.shoppingcart.entidades.Categorias;
import com.proyecto.shoppingcart.excepciones.NoDataFoundException;
import com.proyecto.shoppingcart.repositorios.CategProdRepository;
import com.proyecto.shoppingcart.repositorios.CategoriasRepository;
import com.proyecto.shoppingcart.repositorios.ProductosRepository;
import com.proyecto.shoppingcart.servicios.ICategoriasService;

@Service
public class CategoriasServiceImpl implements ICategoriasService{

    @Autowired
    CategProdRepository categProdRepository;

    @Autowired
    CategoriasRepository categoriasRepository;

    @Autowired
    CategoriasMapper categoriasMapper;

    @Autowired
    ProductosRepository productosRepository;

    @Override
    public List<CategoriasDto> listarCategorias() {
        List<CategoriasDto> categoriasDtos = new ArrayList<>();
        List<Categorias> categorias = (List<Categorias>) categoriasRepository.findAll();
        categoriasDtos = categoriasMapper.modelToDtos(categorias);
        
        return categoriasDtos;
    }

    @Override
    public CategoriasDto buscarCategorias(Long Id) {
        CategoriasDto categoriasDto = new CategoriasDto();
        if(categoriasRepository.findById(Id).isPresent()){
            categoriasDto = categoriasMapper.modelToDto(categoriasRepository.findById(Id).get());
        }
        else {
            throw new NoDataFoundException();
        }
        return categoriasDto;
    }

    @Override
    public CategoriasDto guardarCategorias(CategoriasDto categoriasDto) {
        if(categoriasDto.getId()==0){
            Categorias categorias = new Categorias();
            categorias = categoriasMapper.dtoToModel(categoriasDto);
            categorias = categoriasRepository.save(categorias);
            categoriasDto = categoriasMapper.modelToDto(categorias);
        }
        else {
            Categorias categorias = categoriasRepository.findById(categoriasDto.getId()).get();
            categorias = categoriasMapper.dtoToModel(categoriasDto);
            categorias = categoriasRepository.save(categorias);
            categoriasDto = categoriasMapper.modelToDto(categorias);
        }
        return categoriasDto;
    }

    @Override
    public void eliminarCategorias(Long Id) {
        categoriasRepository.deleteById(Id);
    }

    @Override
    public List<CategoriasDto> listarPoductosOfCategorias() {
        List<CategoriasDto> categoriasDtos = new ArrayList<>();
        List<Categorias> categorias = (List<Categorias>) categoriasRepository.findAll();
        List<String> Productos = new ArrayList<>();
        for (Categorias categoria : categorias) {
            CategoriasDto categoriasDto = new CategoriasDto();
            categoriasDto.setId(categoria.getId());
            categoriasDto.setNombre(categoria.getNombre());

            List<CategProd> categProds = new ArrayList<>();
            categProds = (List<CategProd>) categProdRepository.BuscarPorIdCategorias(categoria.getId());
            for (CategProd categProd : categProds) {
                    if (productosRepository.findById(categProd.getId_Productos()).isPresent()){
                        Productos.add(productosRepository.findById(categProd.getId_Productos()).get().getNombre());
                    }
            }
            categoriasDto.setProductos(Productos);
            categoriasDtos.add(categoriasDto);
        }
        return categoriasDtos;
    }
    
}
