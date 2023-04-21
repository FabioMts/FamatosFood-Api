package com.Fabio.FamatosFoodapi.domain.repository;

import com.Fabio.FamatosFoodapi.domain.model.Cidade;
import com.Fabio.FamatosFoodapi.domain.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {

}


