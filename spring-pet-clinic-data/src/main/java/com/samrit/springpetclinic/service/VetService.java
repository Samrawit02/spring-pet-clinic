package com.samrit.springpetclinic.service;


import com.samrit.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findbyId(Long id);
    Vet save(Vet owner);
    Set<Vet> findAll();
}
