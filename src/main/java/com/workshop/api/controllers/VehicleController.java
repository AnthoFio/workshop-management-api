package com.workshop.api.controllers;

import com.workshop.api.models.Vehicle;
import com.workshop.api.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public List<Vehicle> list(){
        return vehicleRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Vehicle get(@PathVariable Long id){
        return vehicleRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle create(@RequestBody final Vehicle vehicle){
        return vehicleRepository.saveAndFlush(vehicle);
    }

    @RequestMapping(value ="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        vehicleRepository.deleteById(id);
    }
}
