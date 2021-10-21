package com.bike.repository;

import com.bike.model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bike.repository.crud.CategoryCrudRepository;

/**
 * Repositorio de la tabla Category
 * @author Misael
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository crud;
    
    public List<Category> getAll(){
        return (List<Category>) crud.findAll();
    }
    
    public Optional <Category> getCategoria(int id){
        return crud.findById(id);
    }
    
    public Category save(Category categoria){
        return crud.save(categoria);
    }
}
