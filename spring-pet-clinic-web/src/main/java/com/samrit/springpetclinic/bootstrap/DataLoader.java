package com.samrit.springpetclinic.bootstrap;

import com.samrit.springpetclinic.model.Owner;
import com.samrit.springpetclinic.model.Vet;
import com.samrit.springpetclinic.service.OwnerService;
import com.samrit.springpetclinic.service.VetService;
import com.samrit.springpetclinic.service.map.OwnerServiceMap;
import com.samrit.springpetclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

   private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }




    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFristName("Michael");
        owner1.setLastName("Glenanne");

        ownerService.save(owner1);
        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFristName("Fiona");
        owner2.setLastName("Weston");

        ownerService.save(owner2);

        System.out.println("Loading Owners");
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFristName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFristName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);

        System.out.println("Loading Vets");
    }
}
