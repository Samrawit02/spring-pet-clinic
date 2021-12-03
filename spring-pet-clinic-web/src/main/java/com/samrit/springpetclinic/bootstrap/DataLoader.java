package com.samrit.springpetclinic.bootstrap;

import com.samrit.springpetclinic.model.Owner;
import com.samrit.springpetclinic.model.Pet;
import com.samrit.springpetclinic.model.PetType;
import com.samrit.springpetclinic.model.Vet;
import com.samrit.springpetclinic.service.OwnerService;
import com.samrit.springpetclinic.service.PetTypeService;
import com.samrit.springpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

   private final OwnerService ownerService;
   private final VetService vetService;
   private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }
    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        System.out.println("Loading Dogs");


        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);
        System.out.println("Loading Cats");

        Owner owner1 = new Owner();
//        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Glenanne");
        owner1.setAddress("123 Brickerl");
        owner1.setCity("Miami");
        owner1.setTelephone("123456987");
        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);
        Owner owner2 = new Owner();
//        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Weston");
        owner2.setAddress("123 Brickerl");

        owner2.setCity("Miami");
        owner2.setTelephone("123456987");
        Pet fionaPet = new Pet();
        fionaPet.setPetType(saveCatPetType);
        fionaPet.setBirthDate(LocalDate.now());
        fionaPet.setName("Just cat");
        owner2.getPets().add(fionaPet);

        ownerService.save(owner2);

        System.out.println("Loading Owners");
        Vet vet1 = new Vet();
//        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);


        Vet vet2 = new Vet();
//        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);

        System.out.println("Loading Vets");
    }
}
