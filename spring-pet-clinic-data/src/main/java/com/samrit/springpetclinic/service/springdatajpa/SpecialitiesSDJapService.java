package com.samrit.springpetclinic.service.springdatajpa;

import com.samrit.springpetclinic.model.Specialty;
import com.samrit.springpetclinic.repositories.SpecialityRepository;
import com.samrit.springpetclinic.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitiesSDJapService implements SpecialtyService {
    private final SpecialityRepository specialityRepository;

    public SpecialitiesSDJapService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialityRepository.findAll().forEach(specialties::add);
        return specialties;
    }
    @Override
    public Specialty findById(Long Id) {
        return specialityRepository.findById(Id).orElse(null);
    }
    @Override
    public Specialty save(Specialty object) {
        return specialityRepository.save(object);
    }
    @Override
    public void delete(Specialty object) {
        specialityRepository.delete(object);
    }
    @Override
    public void deleteById(Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}
