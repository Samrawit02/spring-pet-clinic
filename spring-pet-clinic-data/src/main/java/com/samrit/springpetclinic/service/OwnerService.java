package com.samrit.springpetclinic.service;

import com.samrit.springpetclinic.model.Owner;

public interface OwnerService extends  CrService<Owner, Long>{

    Owner findByLastName(String lastName);
}
