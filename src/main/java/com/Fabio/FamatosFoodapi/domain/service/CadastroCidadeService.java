package com.Fabio.FamatosFoodapi.domain.service;

import com.Fabio.FamatosFoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.Fabio.FamatosFoodapi.domain.model.Cidade;
import com.Fabio.FamatosFoodapi.domain.model.Estado;
import com.Fabio.FamatosFoodapi.domain.repository.CidadeRepository;
import com.Fabio.FamatosFoodapi.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CadastroCidadeService {


    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade) {

        Long estadoId = cidade.getEstado().getId();
        Estado estado = estadoRepository.findById(estadoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Não existe cadastro de cozinha com o código %d.", estadoId)));

        cidade.setEstado(estado);
        return  cidadeRepository.save(cidade);
    }

}
