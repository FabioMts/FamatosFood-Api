package com.Fabio.FamatosFoodapi.domain.service;

import com.Fabio.FamatosFoodapi.domain.model.Cozinha;
import com.Fabio.FamatosFoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

    @Autowired
    CozinhaRepository repository;

    public Cozinha salvar(Cozinha cozinha) {
        return repository.adicionar(cozinha);
    }




}
