package com.samrit.springpetclinic.controllers;

import com.samrit.springpetclinic.model.Owner;
import com.samrit.springpetclinic.model.PetType;
import com.samrit.springpetclinic.service.OwnerService;
import com.samrit.springpetclinic.service.PetService;
import com.samrit.springpetclinic.service.PetTypeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PetControllerTest {

    @Mock
    PetService petService;

    @Mock
    OwnerService ownerService;

    @Mock
    PetTypeService petTypeService;
    @InjectMocks
    PetController petController;

    MockMvc mockMvc;

    Owner owner;
    Set<PetType> petTypeSet;

    @Before
    public void setUp() throws Exception {
        owner = owner.builder().id(1L).build();

        petTypeSet = new HashSet<>();
        petTypeSet.add(PetType.builder().id(1L).name("Dog").build());
        petTypeSet.add(PetType.builder().id(2L).name("Cat").build());

        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
    }
    @Test
    void initCreationForm()throws Exception{
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypeSet);

        mockMvc.perform(get("/owners/1/pets/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"))
                .andExpect(view().name("pets/createOrUpdatePetForm"));

    }
    @Test
    void processCreationForm() throws Exception{
        when(ownerService.findById(any())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypeSet);

        mockMvc.perform(post("/owners/1/pets/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(petService).save(any());
    }

    @Test
    public void populatePetTypes() {


    }

    @Test
    public void findOwner() {
    }

    @Test
    public void initOwnerBinder() {
    }
}