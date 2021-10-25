package com.bike.controller;

import com.bike.model.Message;
import com.bike.service.MessageService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controlador con las peticiones Get Post Put y Delete de la tabla Message
 * @author Misael
 */
@RestController
@RequestMapping("/Message")
@CrossOrigin("*")
public class messageController {
    
    /**
     * Instancia al servicio de Message
     */
    @Autowired
    private MessageService servicios;
    
    /**
     * Metodo para obtener una lista de los elementos de la tabla Message
     * @return Lista de elementos de la tabla Message
     */
    @GetMapping("/all")
    public List<Message> getMensaje() {
        return servicios.getAll();
    }
    
    /**
     * Metodo para obtener un elemento de la tabla Message
     * @param idMessage = Identificador del elemento a buscar
     * @return Un elemento de la tabla Message con el identificador idMessage
     */
    @GetMapping("/{id}")
    public Optional<Message> getMensaje(@PathVariable("id") int idMessage) {
        return servicios.getMensaje(idMessage);
    }
    
    /**
     * Metodo para guardar un elemento en la tabla Message
     * @param mensaje = Elemento a guardar en la tabla
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Message mensaje) {
        servicios.save(mensaje);
    }
    
    /**
     * Metodo para actualizar un elemento de la tabla Message
     * @param message = Elemento a actualizar de la tabla
     * @return Respuesta del proceso
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message){
        return servicios.update(message);
    }
    
    /**
     * Metodo para eliminar un elemento de la tabla Message 
     * @param id = Identificador del elemento a eliminar
     * @return Respuesta del proceso
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return servicios.delete(id);
    }
}
