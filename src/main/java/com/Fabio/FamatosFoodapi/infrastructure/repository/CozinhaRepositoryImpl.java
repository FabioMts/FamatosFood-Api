package com.Fabio.FamatosFoodapi.infrastructure.repository;

import com.Fabio.FamatosFoodapi.domain.model.Cozinha;
import com.Fabio.FamatosFoodapi.domain.repository.CozinhaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class CozinhaRepositoryImpl implements CozinhaRepository {


    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> todas() {
        return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
    }
    @Override
    public Cozinha porId(Long id) {
        return manager.find(Cozinha.class, id);
    }

    @Transactional
    @Override
    public Cozinha adicionar(Cozinha cozinha) {
        return manager.merge(cozinha);
    }


    @Transactional
    @Override
    public void remover(Cozinha cozinha) {
        cozinha = porId(cozinha.getId());
        manager.remove(cozinha);
    }

}
