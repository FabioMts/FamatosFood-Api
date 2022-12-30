package com.Fabio.FamatosFoodapi.jpa;

import com.Fabio.FamatosFoodapi.FamatosFoodApiApplication;
import com.Fabio.FamatosFoodapi.domain.model.Cozinha;
import com.Fabio.FamatosFoodapi.infrastructure.repository.CozinhaRepositoryImpl;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FamatosFoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepositoryImpl cozinhas = applicationContext.getBean(CozinhaRepositoryImpl.class);

        List<Cozinha> todasCozinhas = cozinhas.todas();

        for(Cozinha cozinha : todasCozinhas) {
            System.out.println(cozinha.getNome());
        }

    }

}
