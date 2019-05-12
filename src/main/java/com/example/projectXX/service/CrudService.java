package com.example.projectXX.service;

import java.util.List;

public interface CrudService<T> {
    List<T> getAll();
    T findById(Long id);
    T add(T t);
    T update(T t);
    void deleteById(Long id);
    void deleteAll();

}
