package com.dao;

import com.domain.Man;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ManDao implements CrudDao<Man> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Man man) {
        entityManager.persist(man);
    }

    @Override
    @Transactional(readOnly = true)
    public Man findById(int id) {
        return entityManager.find(Man.class, id);
    }

    @Override
    @Transactional
    public void update(Man man) {
        Man manNew = entityManager.merge(man);
        entityManager.persist(manNew);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Man man = entityManager.find(Man.class, id);
        entityManager.remove(man);
    }
}
