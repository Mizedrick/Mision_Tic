package com.bike.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que representa la puntuacion dada por el cliente
 * @author Misael
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Score {
    /**
     * Identificador de la puntuacion
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;
    /**
     * Mensaje asociado a la puntuacion
     */
    @Column(nullable = false, length = 255)
    private String messageText;
    /**
     * puntuacion
     */
    @Column(nullable = false, length = 11)
    private Integer stars;
    /**
     * Identificador de la reserva puntuada
     */
    @OneToOne
    @JoinColumn(name = "ReservationId")
    @JsonIgnoreProperties("score")
    private Reservation reservation;
}
