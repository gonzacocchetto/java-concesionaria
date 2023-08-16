package com.project.concesionaria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad de un cliente
 */
@Getter
@Setter
@Entity
@Table(name = "Cliente")
public class CustomerEntity {

    @Id
    @Column(name = "cedula")
    private String cardId;

    @Column(name = "nombre_completo")
    private String fullName;

    @Column(name = "correo")
    private String email;

    @Column(name = "numero_celular")
    private Double numberCellphone;

    @Column(name = "activo")
    private Integer active;

    @Column(name = "contrasenia")
    private String password;
}
