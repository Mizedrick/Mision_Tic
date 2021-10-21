package com.bike.repository;

import com.bike.model.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bike.repository.crud.ReservationCrudRepository;

/**
 * Repositorio de la tabla Reservation
 * @author Misael
 */
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository crud;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) crud.findAll();
    }
    
    public Optional <Reservation> getReservaciones(int id){
        return crud.findById(id);
    }
    
    public Reservation save(Reservation reservaciones){
        return crud.save(reservaciones);
    }
}
