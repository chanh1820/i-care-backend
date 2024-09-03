package com.example.icare.repository.impl;

import com.example.icare.repository.BaseRepository;
import com.example.icare.sco.BaseSCO;
import org.apache.commons.lang3.ObjectUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class BaseRepositoryImpl<E, K> implements BaseRepository<E, K> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<E> findByCriteria(TypedQuery<E> typedQuery, BaseSCO baseSCO) {
        int firstResult = 0;
        if(baseSCO.getMaxResult() >= 0 && baseSCO.getCurrentPage() >= 0){
            firstResult = (baseSCO.getCurrentPage() - 1) * baseSCO.getMaxResult();
        }
        return typedQuery.setFirstResult(firstResult).setMaxResults(baseSCO.getMaxResult()).getResultList();
    }
}
