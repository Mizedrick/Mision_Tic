package com.bike.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta clase representa los mensajes enviados por los clientes.
 * @author Misael
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Message implements Serializable{
    /**
     * Identificador del mensaje
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    /**
     * Mensaje enviado por el cliente
     */
    @Column(nullable = false, length = 250)
    private String messageText;
    /**
     * Identificador de la bicicleta asociada al mensaje
     */
    @ManyToOne
    @JoinColumn(name = "bikeId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Bike bike;
    /**
     * Identificador del cliente que realiza el mensaje
     */
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
}
