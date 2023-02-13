package com.Fabio.FamatosFoodapi.jpa;

import com.Fabio.FamatosFoodapi.FamatosFoodApiApplication;
import com.Fabio.FamatosFoodapi.domain.model.Cidade;
import com.Fabio.FamatosFoodapi.domain.model.Permissao;
import com.Fabio.FamatosFoodapi.domain.repository.CidadeRepository;
import com.Fabio.FamatosFoodapi.domain.repository.PermissaoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaPermissaoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(FamatosFoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        PermissaoRepository permissoes = applicationContext.getBean(PermissaoRepository.class);

        List<Permissao> todasPermissoes = permissoes.todas();

        for(Permissao permissao : todasPermissoes) {
            System.out.printf("%s - %s\n",permissao.getNome(),
                     permissao.getDescricao());
        }

    }

}
