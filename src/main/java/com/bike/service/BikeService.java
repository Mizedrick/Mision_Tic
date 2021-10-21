/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.service;

import com.bike.model.Bike;
import com.bike.repository.BikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Misael
 */
@Service
public class BikeService {
    @Autowired
    private BikeRepository metodosCrud;
    
    public List<Bike> getAll(){
        return metodosCrud.getAll();
    }
    
    //metodo para que el id no quede nulo
    public Optional<Bike> getBikes(int idBikes){
        return metodosCrud.getBikes(idBikes);
    }
    
    public void save(Bike bikes){
        if(bikes.getId()==null){
            metodosCrud.save(bikes);
        }else{
            Optional<Bike> event=metodosCrud.getBikes(bikes.getId());
            if(event.isEmpty()){
                metodosCrud.save(bikes);
            }
        }
    }
}
