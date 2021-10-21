/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.service;

import com.bike.model.Score;
import com.bike.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Misael
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository metodosCrud;
    
    public List<Score> getAll(){
        return metodosCrud.getAll();
    }
    
    //metodo para que el id no quede nulo
    public Optional<Score> getScore(int idScore){
        return metodosCrud.getScore(idScore);
    }
    
    public void save(Score score){
        if(score.getIdScore()==null){
            metodosCrud.save(score);
        }else{
            Optional<Score> event=metodosCrud.getScore(score.getIdScore());
            if(event.isEmpty()){
                metodosCrud.save(score);
            }
        }
    }
}
