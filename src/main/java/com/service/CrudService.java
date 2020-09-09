package com.service;

public interface CrudService<T> {

    void save(T entity);

    T findById(int id);

    void update(T entity);

    void deleteById(int id);
}
