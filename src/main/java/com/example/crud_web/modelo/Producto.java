package com.example.crud_web.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="productos")
/*@Data Se ahorra set get y constructor*/
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private String nombre;
    private double precio;

}

