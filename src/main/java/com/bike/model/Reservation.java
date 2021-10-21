package com.bike.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que representa las reservaciones
 * @author Misael
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    /**
     * Identificador de la reservacion
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    /**
     * Fecha y hora de cuando se solicita la bicicleta
     */
    @Column(nullable = false)
    private Date startDate;
    /**
     * Fecha y hora de cuando se devuelve la bicicleta
     */
    @Column(nullable = false)
    private Date devolutionDate;
    /**
     * Estado de la reserva
     */
    @Column(nullable = false)
    private String status = "created";
    /**
     * Identificador de la bicicleta reservada
     */
    @ManyToOne
    @JoinColumn(name = "bikeId")
    @JsonIgnoreProperties("reservations")
    private Bike bike;
    /**
     * Identificador del cliente que reserva
     */
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
    /**
     * Puntuacion
     */
    @OneToOne(cascade = {CascadeType.REMOVE}, mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    private Score score;
    
}
