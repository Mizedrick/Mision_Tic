package com.bike.controller;

import com.bike.model.Bike;
import com.bike.service.BikeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controlador con las peticiones Get Post Put y Delete de la tabla Bike
 * @author Misael
 */
@RestController
@RequestMapping("/Bike")
@CrossOrigin("*")
public class bikeController {
    @GetMapping("/holaMundo")
    public String saludar() {
        return "Hola Mundo";
    }
    
    /**
     * Instancia al servicio de Bike
     */
    @Autowired
    private BikeService servicios;
    
    /**
     * Metodo para obtener una lista de los elementos de la tabla Bike
     * @return Lista de elementos de la tabla Bike
     */
    @GetMapping("/all")
    public List<Bike> getBikes() {
        return servicios.getAll();
    }
    
    /**
     * Metodo para obtener un elemento de la tabla Bike
     * @param idBikes = Identificador del elemento a buscar
     * @return Un elemento de la tabla Bike con el identificador idBikes
     */
    @GetMapping("/{id}")
    public Optional<Bike> getBikes(@PathVariable("id") int idBikes) {
        return servicios.getBikes(idBikes);
    }
    
    /**
     * Metodo para guardar un elemento en la tabla Bike
     * @param bikes = Elemento a guardar en la tabla
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Bike bikes) {
        servicios.save(bikes);
    }
}
