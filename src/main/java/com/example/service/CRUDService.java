package com.example.service;

public interface CRUDService<T> {
    public void save(T entity);
    public T findById(int id);
    public void delete(int id);
    public void update(T entity);
}
