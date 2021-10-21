package com.bike.repository;

import com.bike.model.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bike.repository.crud.MessageCrudRepository;

/**
 * Repositorio de la tabla Message
 * @author Misael
 */
@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository crud;
    
    public List<Message> getAll(){
        return (List<Message>) crud.findAll();
    }
    
    public Optional <Message> getMensaje(int id){
        return crud.findById(id);
    }
    
    public Message save(Message mensaje){
        return crud.save(mensaje);
    }
}
