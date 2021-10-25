package com.bike.repository;

import com.bike.model.Admin;
import com.bike.repository.crud.AdminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de la tabla Admin
 * @author Misael
 */
@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository crud;
    public List<Admin> getAll(){
        return (List<Admin>) crud.findAll();
    }
    public Optional<Admin> getAdmin(int id){
        return crud.findById(id);
    }

    public Admin save(Admin admin){
        return crud.save(admin);
    }
    
    public void delete(int id){
        crud.deleteById(id);
    }
}
