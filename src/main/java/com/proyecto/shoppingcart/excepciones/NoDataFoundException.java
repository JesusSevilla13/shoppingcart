package com.proyecto.shoppingcart.excepciones;

public class NoDataFoundException extends RuntimeException{

    public NoDataFoundException()
    {
        super("No existen registros");
    }
    
}
