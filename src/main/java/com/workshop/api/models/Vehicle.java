package com.workshop.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private Instant productionDate;
    private Instant purchaseDate;
    private Integer purchaseMileage;
    private Integer mileage;
    private Integer type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

}
