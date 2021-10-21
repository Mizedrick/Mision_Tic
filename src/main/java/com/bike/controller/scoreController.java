package com.bike.controller;

import com.bike.model.Score;
import com.bike.service.ScoreService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controlador con las peticiones Get Post Put y Delete de la tabla Score
 * @author Misael
 */
@RestController
@RequestMapping("/Score")
@CrossOrigin("*")
public class scoreController {
    
    /**
     * Instancia al servicio de Score
     */
    @Autowired
    private ScoreService servicios;
    
    /**
     * Metodo para obtener una lista de los elementos de la tabla Score
     * @return Lista de elementos de la tabla Score
     */
    @GetMapping("/all")
    public List<Score> getScore() {
        return servicios.getAll();
    }
    
    /**
     * Metodo para obtener un elemento de la tabla Score
     * @param idScore = Identificador del elemento a buscar
     * @return Un elemento de la tabla Score con el identificador idScore
     */
    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id") int idScore) {
        return servicios.getScore(idScore);
    }
    
    /**
     * Metodo para guardar un elemento en la tabla Score
     * @param score = Elemento a guardar en la tabla
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Score score) {
        servicios.save(score);
    }
}
