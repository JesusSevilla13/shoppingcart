package com.proyecto.shoppingcart.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/*
 * Clase tipo Dto para enmascarar los datos de los usuarios o compradores
 */

@Getter
@Setter
@Entity
@Table(name = "TBL_Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column (name = "Nombre")
    private String Nombre;
    @Column (name = "Apellido")
    private String Apellido;
    @Column (name = "Celular")
    private Long Celular;
    @Column (name = "Email")
    private String Email;
}
