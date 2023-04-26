package com.Fabio.FamatosFoodapi.domain.repository;

import com.Fabio.FamatosFoodapi.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>,  RestauranteRepositoryQueries, JpaSpecificationExecutor<Restaurante> {


    @Query("from Restaurante r join fetch r.cozinha left join fetch r.formaPagamento")
    List<Restaurante> findAll();

    List<Restaurante> findTop2ByNomeContaining(String nome);
    @Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
    List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);
    int countByCozinhaId(Long cozinha);

}


