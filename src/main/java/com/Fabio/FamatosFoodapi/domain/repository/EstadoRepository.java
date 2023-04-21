package com.Fabio.FamatosFoodapi.domain.repository;

import com.Fabio.FamatosFoodapi.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}


