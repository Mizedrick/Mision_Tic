/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.repository.crud;

import com.bike.model.Admin;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Misael
 */
public interface AdminCrudRepository extends CrudRepository<Admin,Integer> {
    
}
