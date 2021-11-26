package com.samrit.springpetclinic.service;


import com.samrit.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findbyId(Long id);
    Pet save(Pet owner);
    Set<Pet> findAll();
}
