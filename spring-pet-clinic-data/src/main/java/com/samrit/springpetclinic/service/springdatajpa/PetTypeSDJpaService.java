package com.samrit.springpetclinic.service.springdatajpa;

import com.samrit.springpetclinic.model.PetType;
import com.samrit.springpetclinic.repositories.PetTypeRepository;
import com.samrit.springpetclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {
    public final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long Id) {
        return petTypeRepository.findById(Id).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {

    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);

    }
}
