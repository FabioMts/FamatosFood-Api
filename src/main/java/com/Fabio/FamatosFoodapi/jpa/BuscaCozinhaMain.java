package com.Fabio.FamatosFoodapi.jpa;

import com.Fabio.FamatosFoodapi.FamatosFoodApiApplication;
import com.Fabio.FamatosFoodapi.domain.model.Cozinha;
import com.Fabio.FamatosFoodapi.infrastructure.repository.CozinhaRepositoryImpl;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

public class BuscaCozinhaMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FamatosFoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepositoryImpl cozinhaRepository = applicationContext.getBean(CozinhaRepositoryImpl.class);

        Cozinha cozinha = cozinhaRepository.porId(1L);

        System.out.println(cozinha.getNome());

    }

}
