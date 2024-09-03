package com.example.icare.repository;

import com.example.icare.sco.BaseSCO;

import javax.persistence.TypedQuery;
import java.util.List;

public interface BaseRepository<E, K> {
    public List<E> findByCriteria(TypedQuery<E> typedQuery, BaseSCO baseSCO);
}
