package com.Fabio.FamatosFoodapi.jpa;
import com.Fabio.FamatosFoodapi.FamatosFoodApiApplication;
import com.Fabio.FamatosFoodapi.domain.model.Restaurante;
import com.Fabio.FamatosFoodapi.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import java.util.List;

public class ConsultaRestauranteMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(FamatosFoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);

        List<Restaurante> todosRestaurantes = restaurantes.todos();

        for(Restaurante restaurante : todosRestaurantes) {
            System.out.printf("%s - %f -%s\n", restaurante.getNome(),
            restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());
        }

    }

}
