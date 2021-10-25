package com.bike.repository;

import com.bike.model.Score;
import com.bike.repository.crud.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de la tabla Score
 * @author Misael
 */
@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository crud;
    public List<Score> getAll(){
        return (List<Score>) crud.findAll();
    }
    
    public Optional <Score> getScore(int id){
        return crud.findById(id);
    }
    
    public Score save(Score score){
        return crud.save(score);
    }
    
    public void delete(int id){
        crud.deleteById(id);
    }
}
