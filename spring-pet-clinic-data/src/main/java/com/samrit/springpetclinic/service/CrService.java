package com.samrit.springpetclinic.service;

import java.util.Set;

public interface CrService<T, ID> {
    Set<T> findAll();
    T findById(ID Id);
    T save(T object);
    void delete(T object);
    void deleteById( ID id);

}
