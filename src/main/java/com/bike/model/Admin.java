package com.bike.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Entidad que representa un administrador
 * @author Misael
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin implements Serializable{
    /**
     * Identificador del administrador
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdmin;
    /**
     * Correo electronico del administrador
     */
    private String email;
    /**
     * Contraseña del administrador
     */
    private String password;
    /**
     * Nombre del administrador
     */
    private String name;
}
