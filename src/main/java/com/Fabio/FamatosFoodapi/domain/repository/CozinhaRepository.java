package com.Fabio.FamatosFoodapi.domain.repository;

import com.Fabio.FamatosFoodapi.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> todas();
    Cozinha porId(Long id);
    Cozinha adicionar(Cozinha cozinha);
    void remover(Cozinha cozinha);

}


