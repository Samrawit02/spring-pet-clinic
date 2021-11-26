package com.samrit.springpetclinic.service;

import com.samrit.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner  findbyId(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
