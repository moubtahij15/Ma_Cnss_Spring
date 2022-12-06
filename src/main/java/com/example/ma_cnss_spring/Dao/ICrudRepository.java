package com.example.ma_cnss_spring.Dao;

import java.util.List;

public interface ICrudRepository <T>{
    public void save(T t);

    public List<T> findAll();

    public List<T> findByDesignation(String mc);

    public T findByid(int id);

    public T update(T T);

    public T delete(long id);
}
