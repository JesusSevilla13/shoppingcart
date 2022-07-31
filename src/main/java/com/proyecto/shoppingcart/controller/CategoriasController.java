package com.proyecto.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.shoppingcart.dto.CategoriasDto;
import com.proyecto.shoppingcart.dto.ResponseDto;
import com.proyecto.shoppingcart.servicios.ICategoriasService;

/*
 * Micro servicio para el manejo de los CRUD de tabla Categorias
 */

 @RestController
 @RequestMapping("api/v1/categorias")
public class CategoriasController {
    
    private ResponseDto responseDto;
    public CategoriasController(){
        responseDto = new ResponseDto();
        responseDto.setMensaje("Proceso realizado correctamente");
    }

    @Autowired
    ICategoriasService categoriasService;
    //http://localhost:8080/api/v1/categorias/buscartodos

    /*
	 * Metodo para buscar todos los registros
	 */
    @GetMapping(path = "buscartodos")
    public ResponseEntity<ResponseDto> buscarTodos(){
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(categoriasService.listarCategorias());

        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /*
	 * Metodo para buscar un registro
	 */
    @GetMapping(path = "buscarporid/{id}")
    public ResponseEntity<ResponseDto> buscarPorId(@PathVariable("id") long id){
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(categoriasService.buscarCategorias(id));

        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /*
	 * Metodo para guardar el registro y obtener el registro guardado
	 */
    @PostMapping(path = "guardar")
    public ResponseEntity<ResponseDto> guardar(@RequestBody CategoriasDto categoriasDto)
    {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        responseDto.setData(categoriasService.guardarCategorias(categoriasDto));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /*
	 * Metodo para eliminar el registro 
	 */
    @DeleteMapping(path = "eliminar/{id}")
    public ResponseEntity<ResponseDto> eliminar(@PathVariable("id") long id)
    {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        categoriasService.eliminarCategorias(id);
        responseDto.setData(null);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /*
	 * Metodo para buscar todos los productos de una categoria
	 */
    @GetMapping(path = "buscarcatprod")
    public ResponseEntity<ResponseDto> buscarCategProd(){
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(categoriasService.listarPoductosOfCategorias());

        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}
