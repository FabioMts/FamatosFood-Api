package com.Fabio.FamatosFoodapi.jpa;

import com.Fabio.FamatosFoodapi.FamatosFoodApiApplication;
import com.Fabio.FamatosFoodapi.domain.model.Cidade;
import com.Fabio.FamatosFoodapi.domain.model.FormaPagamento;
import com.Fabio.FamatosFoodapi.domain.repository.CidadeRepository;
import com.Fabio.FamatosFoodapi.domain.repository.FormaPagamentoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class BuscaFormaPagamentoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(FamatosFoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FormaPagamentoRepository formasDePagamento = applicationContext.getBean(FormaPagamentoRepository.class);

        List<FormaPagamento> todasFormasDePagamento = formasDePagamento.todas();

        for(FormaPagamento formaPagamento : todasFormasDePagamento) {
            System.out.println(formaPagamento.getDescricao());
        }

    }

}
