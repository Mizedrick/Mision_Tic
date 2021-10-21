package com.bike.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta clase representa el cliente
 * @author Misael
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client implements Serializable{
    /**
     * Identificador del cliente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    /**
     * Correo electronico del cliente
     */
    @Column(nullable = false, length = 45)
    private String email;
    /**
     * Contraseña del cliente
     */
    @Column(nullable = false, length = 250)
    private String password;
    /**
     * Nombre del cliente
     */
    @Column(nullable = false, length = 250)
    private String name;
    /**
     * Edad del cliente
     */
    @Column(nullable = false)
    private Integer age;
    /**
     * Lista de mensajes enviados por el cliente
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Message> messages; 
    /**
     * Lista de reservaciones realizadas por el cliente
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;
}
