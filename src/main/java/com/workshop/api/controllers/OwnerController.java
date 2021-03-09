package com.workshop.api.controllers;

import com.workshop.api.models.Owner;
import com.workshop.api.models.Vehicle;
import com.workshop.api.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {
    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping
    public List<Owner> list(){
        return ownerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Owner get(@PathVariable Long id){
        return ownerRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Owner create(@RequestBody final Owner owner){
        return ownerRepository.saveAndFlush(owner);
    }

    @RequestMapping(value ="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        ownerRepository.deleteById(id);
    }
}
