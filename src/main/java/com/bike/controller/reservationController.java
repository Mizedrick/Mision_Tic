package com.bike.controller;

import com.bike.model.Reservation;
import com.bike.service.ReservationService;
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
 * Controlador con las peticiones Get Post Put y Delete de la tabla Admin
 * @author Misael
 */
@RestController
@RequestMapping("/Reservation")
@CrossOrigin("*")
public class reservationController {
    
    /**
     * Instancia al servicio de Reservation
     */
    @Autowired
    private ReservationService servicios;
    
    /**
     * Metodo para obtener una lista de los elementos de la tabla Reservation
     * @return Lista de elementos de la tabla Reservation
     */
    @GetMapping("/all")
    public List<Reservation> getReservation() {
        return servicios.getAll();
    }
    
    /**
     * Metodo para obtener un elemento de la tabla Reservation
     * @param idReservation = Identificador del elemento a buscar
     * @return Un elemento de la tabla Reservation con el identificador idReservation
     */
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int idReservation) {
        return servicios.getReservation(idReservation);
    }
    
    /**
     * Metodo para guardar un elemento en la tabla Reservation
     * @param reservation = Elemento a guardar en la tabla
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Reservation reservation) {
        servicios.save(reservation);
    }
}
