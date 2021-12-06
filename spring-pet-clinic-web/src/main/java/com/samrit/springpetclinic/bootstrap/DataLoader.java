package com.samrit.springpetclinic.bootstrap;

import com.samrit.springpetclinic.model.*;
import com.samrit.springpetclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

   private final OwnerService ownerService;
   private final VetService vetService;
   private final PetTypeService petTypeService;
   private final SpecialtyService specialtyService;
   private final VisitService visitService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }
           @Override
        public void run(String... args) throws Exception {
            int count = petTypeService.findAll().size();
            if(count==0){
                loadData();
            }
           }

    private void loadData() {
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty saveRadio= specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty saveSur = specialtyService.save(saveRadio);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty saveDent = specialtyService.save(dentistry);

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

        System.out.println("Loading Visit");
        Visit catVisit = new Visit();
        catVisit.setDescription("Visiting The cat");
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(fionaPet);
        visitService.save(catVisit);



        System.out.println("Loading Owners");
        Vet vet1 = new Vet();
//        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(saveRadio);
        vetService.save(vet1);


        Vet vet2 = new Vet();
//        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(saveSur);
        vetService.save(vet2);

        System.out.println("Loading Vets");


    }
}
