/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.service;

import com.bike.model.Client;
import com.bike.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Misael
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository metodosCrud;

    public List<Client> getAll() {
        return metodosCrud.getAll();
    }

    //metodo para que el id no quede nulo
    public Optional<Client> getCliente(int idCliente) {
        return metodosCrud.getCliente(idCliente);
    }

    public void save(Client cliente) {
        if (cliente.getIdClient()== null) {
            metodosCrud.save(cliente);
        } else {
            Optional<Client> event = metodosCrud.getCliente(cliente.getIdClient());
            if (event.isEmpty()) {
                metodosCrud.save(cliente);
            }
        }
    }
    
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> clientEdit = metodosCrud.getCliente(client.getIdClient());
            if(!clientEdit.isEmpty()){
                if(client.getEmail()!=null){
                    clientEdit.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    clientEdit.get().setPassword(client.getPassword());
                }
                if(client.getName()!=null){
                    clientEdit.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    clientEdit.get().setAge(client.getAge());
                }
                return metodosCrud.save(clientEdit.get());
            }
        }
        return client;
    }
    
    public boolean delete(int id){
        Boolean delete = getCliente(id).map(client ->{
            metodosCrud.delete(client.getIdClient());
            return true;
        }).orElse(false);
        
        return delete;
    }
}
