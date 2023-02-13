package com.Fabio.FamatosFoodapi.domain.repository;

import com.Fabio.FamatosFoodapi.domain.model.Cidade;
import com.Fabio.FamatosFoodapi.domain.model.Estado;

import java.util.List;

public interface CidadeRepository {

    List<Cidade> todas();
    Cidade porId(Long id);
    Cidade adicionar(Cidade cidade);
    void remover(Cidade cidade);

}


