package com.bike.repository;

import com.bike.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bike.repository.crud.ClientCrudRepository;

/**
 * Repositorio de la tabla Client
 * @author Misael
 */
@Repository
public class ClientRepository {
     @Autowired
    private ClientCrudRepository crud;
    
    public List<Client> getAll(){
        return (List<Client>) crud.findAll();
    }
    
    public Optional <Client> getCliente(int id){
        return crud.findById(id);
    }
    
    public Client save(Client cliente){
        return crud.save(cliente);
    }
    
    public void delete(int id){
        crud.deleteById(id);
    }
}
