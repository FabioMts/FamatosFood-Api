package com.Fabio.FamatosFoodapi.domain.repository;

import com.Fabio.FamatosFoodapi.domain.model.Cozinha;
import com.Fabio.FamatosFoodapi.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> todos();
    Estado porId(Long id);
    Estado adicionar(Estado estado);
    void remover(Estado estado);

}


