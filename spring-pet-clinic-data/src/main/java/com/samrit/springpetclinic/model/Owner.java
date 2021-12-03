package com.samrit.springpetclinic.model;

import java.util.Set;

public class Owner extends  Person{
    private Set<Pet> ptes;

    public Set<Pet> getPtes() {
        return ptes;
    }

    public void setPtes(Set<Pet> ptes) {
        this.ptes = ptes;
    }
}
