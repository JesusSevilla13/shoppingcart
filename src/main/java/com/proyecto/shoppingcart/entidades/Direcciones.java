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
 * Clase tipo entidad para guardar las direcciones del usuario
 */

@Getter
@Setter
@Entity
@Table(name = "TBL_Direcciones")
public class Direcciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column (name = "Id_Usuario")
    private Long Id_Usuario;
    @Column (name = "Direccion")
    private String Direccion;
}
