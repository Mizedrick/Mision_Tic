package com.bike.controller;

import com.bike.model.Admin;
import com.bike.service.AdminService;
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
@RequestMapping("/Admin")
@CrossOrigin("*")
public class adminController {
    /**
     * Instancia al servicio de Admin
     */
    @Autowired
    private AdminService servicio;
    /**
     * Metodo para obtener una lista de los elementos de la tabla Admin
     * @return Lista de elementos de la tabla Admin
     */
    @GetMapping("/all")
    public List<Admin> getAdmins(){
        return servicio.getAll();
    }
    
    /**
     * Metodo para obtener un elemento de la tabla Admin
     * @param adminId = Identificador del elemento a buscar
     * @return Un elemento de la tabla Admin con el identificador adminId
     */
    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int adminId) {
        return servicio.getAdmin(adminId);
    }
    
    /**
     * Metodo para guardar un elemento en la tabla Admin
     * @param admin = Elemento a guardar en la tabla
     * @return respuesta del guardado
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin) {
        return servicio.save(admin);
    }
    
    /**
     * Metodo para actualizar un elemento de la tabla Admin
     * @param admin = Elemento a actualizar de la tabla
     * @return Respuesta del proceso
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin){
        return servicio.update(admin);
    }
    
    /**
     * Metodo para eliminar un elemento de la tabla Admin 
     * @param id = Identificador del elemento a eliminar
     * @return Respuesta del proceso
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return servicio.delete(id);
    } 
    
}
