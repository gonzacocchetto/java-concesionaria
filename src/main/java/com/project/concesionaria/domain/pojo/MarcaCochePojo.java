package com.project.concesionaria.domain.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Pojo de marca coche
 */
@Getter @Setter
public class MarcaCochePojo {

    /**
     * Id de la marca
     */
    private Long id;
    /**
     * Descripcion de la marca
     */
    private String description;

}
