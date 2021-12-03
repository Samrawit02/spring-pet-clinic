package com.samrit.springpetclinic.service.map;

import com.samrit.springpetclinic.model.Specialty;
import com.samrit.springpetclinic.model.Vet;
import com.samrit.springpetclinic.service.SpecialtyService;
import com.samrit.springpetclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private  final  SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Vet object) {
        super.delete(object);

    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialties().size() == 0) {
            object.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null) {
                    Specialty saveSpecialty = specialtyService.save(specialty);
                    saveSpecialty.setId(saveSpecialty.getId());
                }
            });

        }
        return super.save(object);
    }
    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
