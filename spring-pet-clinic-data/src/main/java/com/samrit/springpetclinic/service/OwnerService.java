package com.samrit.springpetclinic.service;

import com.samrit.springpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends  CrService<Owner, Long>{

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);


}
