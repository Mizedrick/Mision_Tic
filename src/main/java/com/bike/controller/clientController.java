package com.bike.controller;

import com.bike.model.Client;
import com.bike.service.ClientService;
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
 * Controlador con las peticiones Get Post Put y Delete de la tabla Admin
 * @author Misael
 */
@RestController
@RequestMapping("/Client")
@CrossOrigin("*")
public class clientController {
    
    /**
     * Instancia al servicio de Client
     */
    @Autowired
    private ClientService servicios;
    
    /**
     * Metodo para obtener una lista de los elementos de la tabla Client
     * @return Lista de elementos de la tabla Client
     */
    @GetMapping("/all")
    public List<Client> getCliente() {
        return servicios.getAll();
    }
    
    /**
     * Metodo para obtener un elemento de la tabla Client
     * @param idCliente = Identificador del elemento a buscar
     * @return Un elemento de la tabla Client con el identificador idCliente
     */
    @GetMapping("/{id}")
    public Optional<Client> getCliente(@PathVariable("id") int idCliente) {
        return servicios.getCliente(idCliente);
    }
    
    /**
     * Metodo para guardar un elemento en la tabla Client
     * @param cliente = Elemento a guardar en la tabla
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Client cliente) {
        servicios.save(cliente);
    }
    
    /**
     * Metodo para actualizar un elemento de la tabla Client
     * @param client = Elemento a actualizar de la tabla
     * @return Respuesta del proceso
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client){
        return servicios.update(client);
    }
    
    /**
     * Metodo para eliminar un elemento de la tabla Client 
     * @param id = Identificador del elemento a eliminar
     * @return Respuesta del proceso
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return servicios.delete(id);
    }
}
