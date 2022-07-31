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

import com.proyecto.shoppingcart.dto.DireccionesDto;
import com.proyecto.shoppingcart.dto.ResponseDto;
import com.proyecto.shoppingcart.servicios.IDireccionesService;

/*
 * Micro servicio para el manejo de los CRUD de tabla Direcciones
 */

@RestController
@RequestMapping("api/v1/direcciones")
public class DireccionesController {
    
    private ResponseDto responseDto;
    public DireccionesController(){
        responseDto = new ResponseDto();
        responseDto.setMensaje("Proceso realizado correctamente");
    }

    @Autowired
    IDireccionesService direccionesService;
    //http://localhost:8080/api/v1/direcciones/buscartodos

    /*
	 * Metodo para buscar todos los registros
	 */
    @GetMapping(path = "buscartodos")
    public ResponseEntity<ResponseDto> buscarTodos(){
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(direccionesService.listarDirecciones());

        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /*
	 * Metodo para buscar un registro
	 */
    @GetMapping(path = "buscarporid/{id}")
    public ResponseEntity<ResponseDto> buscarPorId(@PathVariable("id") long id){
        responseDto.setCodigoRespuesta(HttpStatus.OK.value());
        responseDto.setData(direccionesService.buscarDirecciones(id));

        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /*
	 * Metodo para guardar el registro y obtener el registro guardado
	 */
    @PostMapping(path = "guardar")
    public ResponseEntity<ResponseDto> guardar(@RequestBody DireccionesDto direccionesDto)
    {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        responseDto.setData(direccionesService.guardarDirecciones(direccionesDto));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /*
	 * Metodo para eliminar el registro 
	 */
    @DeleteMapping(path = "eliminar/{id}")
    public ResponseEntity<ResponseDto> eliminar(@PathVariable("id") long id)
    {
        responseDto.setCodigoRespuesta(HttpStatus.CREATED.value());
        direccionesService.eliminarDirecciones(id);
        responseDto.setData(null);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}
