package com.samrit.springpetclinic.repositories;

import com.samrit.springpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Specialty, Long> {
}
