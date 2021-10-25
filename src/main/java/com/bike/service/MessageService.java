/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.service;

import com.bike.model.Message;
import com.bike.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Misael
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository metodosCrud;
    
    public List<Message> getAll(){
        return metodosCrud.getAll();
    }
    
    //metodo para que el id no quede nulo
    public Optional<Message> getMensaje(int idMessage){
        return metodosCrud.getMensaje(idMessage);
    }
    
    public void save(Message mensaje){
        if(mensaje.getIdMessage()==null){
            metodosCrud.save(mensaje);
        }else{
            Optional<Message> event=metodosCrud.getMensaje(mensaje.getIdMessage());
            if(event.isEmpty()){
                metodosCrud.save(mensaje);
            }
        }
    }
    
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> messageEdit = metodosCrud.getMensaje(message.getIdMessage());
            if(!messageEdit.isEmpty()){
                if(message.getMessageText()!=null){
                    messageEdit.get().setMessageText(message.getMessageText());
                }
                return metodosCrud.save(messageEdit.get());
            }
        }
        return message;
    }
    
    public boolean delete(int id){
        Boolean delete = getMensaje(id).map(message ->{
            metodosCrud.delete(message.getIdMessage());
            return true;
        }).orElse(false);
        
        return delete;
    }
}
