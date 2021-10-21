/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.repository.crud;

import com.bike.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositorio para la entidad category
 * @author Misael
 */
public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
    
}
