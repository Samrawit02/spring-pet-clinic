package com.samrit.springpetclinic.service.map;

import com.samrit.springpetclinic.model.Owner;
import com.samrit.springpetclinic.model.Pet;
import com.samrit.springpetclinic.service.OwnerService;
import com.samrit.springpetclinic.service.PetService;
import com.samrit.springpetclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

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
        if(object !=null){
            if(object.getPets() !=null)
            {
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() !=null){
                        pet.setPetType((petTypeService.save(pet.getPetType())));

                    }else {
                        throw new RuntimeException("Pet Type Is required");

                    }
                    if(pet.getId() ==null){
                        Pet savePet = petService.save(pet);
                        pet.setId(savePet.getId());
                    }
                });
            }
            return super.save(object);
        }
        else{
            return  null;
        }

    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        // not now
        return null;
    }
}
