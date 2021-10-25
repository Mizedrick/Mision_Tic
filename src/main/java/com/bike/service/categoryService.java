/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.service;

import com.bike.model.Category;
import com.bike.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Misael
 */
@Service
public class categoryService {
    @Autowired
    private CategoryRepository metodosCrud;
    
    public List<Category> getAll(){
        return metodosCrud.getAll();
    }
    
    //metodo para que el id no quede nulo
    public Optional<Category> getCategoria(int idCategoria){
        return metodosCrud.getCategoria(idCategoria);
    }
    
    public void save(Category categoria){
        if(categoria.getId()==null){
            metodosCrud.save(categoria);
        }else{
            Optional<Category> event=metodosCrud.getCategoria(categoria.getId());
            if(event.isEmpty()){
                metodosCrud.save(categoria);
            }
        }
    }
    
    public Category update(Category categoria){
        if(categoria.getId()!=null){
            Optional<Category> categoriaEdit = metodosCrud.getCategoria(categoria.getId());
            if(!categoriaEdit.isEmpty()){
                if(categoria.getName()!=null){
                    categoriaEdit.get().setName(categoria.getName());
                }
                if(categoria.getDescription()!=null){
                    categoriaEdit.get().setDescription(categoria.getDescription());
                }
                return metodosCrud.save(categoriaEdit.get());
            }
        }
        return categoria;
    }
    
    public boolean delete(int id){
        Boolean delete = getCategoria(id).map(category ->{
            metodosCrud.delete(category.getId());
            return true;
        }).orElse(false);
        
        return delete;
    }
}
