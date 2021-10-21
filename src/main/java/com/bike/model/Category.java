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
 * Esta clase representa a una categoria de la bicicleta
 * @author Misael
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category implements Serializable{
    /**
     * Identificador de la categoria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Nombre de la categoria
     */
    @Column(nullable = false, length = 45)
    private String name;
    /**
     * Descripcion sobre la categoria
     */
    @Column(nullable = false, length = 250)
    private String description;
    /**
     * Lista de bicicletas que tienen esta como categoria
     */
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Bike> bikes;
}
