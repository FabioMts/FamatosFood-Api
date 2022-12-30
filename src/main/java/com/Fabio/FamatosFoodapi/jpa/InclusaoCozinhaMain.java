package com.Fabio.FamatosFoodapi.jpa;

import com.Fabio.FamatosFoodapi.FamatosFoodApiApplication;
import com.Fabio.FamatosFoodapi.domain.model.Cozinha;
import com.Fabio.FamatosFoodapi.infrastructure.repository.CozinhaRepositoryImpl;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


public class InclusaoCozinhaMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FamatosFoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepositoryImpl cozinhaRepository = applicationContext.getBean(CozinhaRepositoryImpl.class);

        Cozinha cozinha1 = new Cozinha();
        cozinha1.setNome("Brasileira");

        Cozinha cozinha2 = new Cozinha();
        cozinha2.setNome("Japonesa");

        cozinha1 = cozinhaRepository.adicionar(cozinha1);
        cozinha2 = cozinhaRepository.adicionar(cozinha2);

        System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
        System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());


    }

}
