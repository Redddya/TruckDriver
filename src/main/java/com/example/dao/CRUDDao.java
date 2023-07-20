package com.example.dao;

public interface CRUDDao<T> {
    public void save(T entity);
    public T findById(int id);
    public void delete(int id);
    public void update(T entity);
}
