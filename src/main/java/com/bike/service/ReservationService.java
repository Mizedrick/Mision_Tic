/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.service;

import com.bike.model.Reservation;
import com.bike.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Misael
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository metodosCrud;
    
    public List<Reservation> getAll(){
        return metodosCrud.getAll();
    }
    
    //metodo para que el id no quede nulo
    public Optional<Reservation> getReservation(int idReservation){
        return metodosCrud.getReservaciones(idReservation);
    }
    
    public void save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            metodosCrud.save(reservation);
        }else{
            Optional<Reservation> event=metodosCrud.getReservaciones(reservation.getIdReservation());
            if(event.isEmpty()){
                metodosCrud.save(reservation);
            }
        }
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> reservationEdit = metodosCrud.getReservaciones(reservation.getIdReservation());
            if(!reservationEdit.isEmpty()){
                if(reservation.getStartDate()!=null){
                    reservationEdit.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    reservationEdit.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    reservationEdit.get().setStatus(reservation.getStatus());
                }
                return metodosCrud.save(reservationEdit.get());
            }
        }
        return reservation;
    }
    
    public boolean delete(int id){
        Boolean delete = getReservation(id).map(reservation ->{
            metodosCrud.delete(reservation.getIdReservation());
            return true;
        }).orElse(false);
        
        return delete;
    }
}
