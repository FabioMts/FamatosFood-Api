package com.Fabio.FamatosFoodapi.api.controller;


import com.Fabio.FamatosFoodapi.domain.model.Restaurante;
import com.Fabio.FamatosFoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    RestauranteRepository restauranteRepository;

    @GetMapping
    public List<Restaurante> listar() {
        return restauranteRepository.todos();
    }

    @GetMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> buscarPorId(@PathVariable Long restauranteId) {
        Restaurante restaurante = restauranteRepository.porId(restauranteId);

        if(restaurante != null) {
            return ResponseEntity.ok(restaurante);
        }
        return ResponseEntity.notFound().build();

    }

}
