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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta entidad representa una bicicleta
 * @author Misael
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bike implements Serializable{
    /**
     * Identificador de la bicicleta
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Nombre de la bicicleta
     */
    @Column(nullable = false, length = 45)
    private String name;
    /**
     * Marca de la bicicleta
     */
    @Column(nullable = false, length = 45)
    private String brand;
    /**
     * Modelo de la bicicleta
     */
    @Column(nullable = false, length = 4)
    private Integer year;
    /**
     * Descripcion sobre la bicicleta
     */
    @Column(nullable = false, length = 255)
    private String description;
    /**
     * Categoria asociada a la bicicleta
     */
    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties("bikes")
    private Category category;
    /**
     * Mensajes asociados a la bicicleta
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "bike")
    @JsonIgnoreProperties({"bike","client"})
    private List<Message> messages;
    /**
     * Reservaciones realizadas a la bicicleta
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "bike")
    @JsonIgnoreProperties("bike")
    private List<Reservation> reservations;
}
