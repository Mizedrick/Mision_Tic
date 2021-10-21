package com.bike.repository;

import com.bike.model.Bike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bike.repository.crud.BikeCrudRepository;

/**
 * Repositorio de la tabla Bike
 * @author Misael
 */
@Repository
public class BikeRepository {
    @Autowired
    private BikeCrudRepository crud;
    
    public List<Bike> getAll(){
        return (List<Bike>) crud.findAll();
    }
    
    public Optional <Bike> getBikes(int id){
        return crud.findById(id);
    }
    
    public Bike save(Bike bikes){
        return crud.save(bikes);
    }
}
