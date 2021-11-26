package com.samrit.springpetclinic.service.map;

import com.samrit.springpetclinic.model.Owner;
import com.samrit.springpetclinic.service.CrService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrService<Owner, Long> {


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Owner object) {
        super.delete(object);

    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
