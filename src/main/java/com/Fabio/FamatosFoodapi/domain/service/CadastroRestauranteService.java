package com.Fabio.FamatosFoodapi.domain.service;


import com.Fabio.FamatosFoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.Fabio.FamatosFoodapi.domain.model.Cozinha;
import com.Fabio.FamatosFoodapi.domain.model.Restaurante;
import com.Fabio.FamatosFoodapi.domain.repository.CozinhaRepository;
import com.Fabio.FamatosFoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    @Autowired
    RestauranteRepository restauranteRepository;
    @Autowired
    CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {

        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Não existe cadastro de cozinha com o código %d.", cozinhaId)));

        restaurante.setCozinha(cozinha);

        return  restauranteRepository.save(restaurante);
    }


}
