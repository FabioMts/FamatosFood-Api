package com.Fabio.FamatosFoodapi.domain.service;

import com.Fabio.FamatosFoodapi.domain.exception.EntidadeEmUsoException;
import com.Fabio.FamatosFoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.Fabio.FamatosFoodapi.domain.model.Cozinha;
import com.Fabio.FamatosFoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

    @Autowired
    CozinhaRepository repository;

    public Cozinha salvar(Cozinha cozinha) {
        return repository.adicionar(cozinha);
    }

    public void excluir(Long cozinhaId) {
        try {
            repository.remover(cozinhaId);
        }catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de cozinha com o código %d", cozinhaId));

        }catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Cozinha de código %d não pode ser removida, pois está em uso", cozinhaId));
        }
    }



}
