package com.credibanco.conceseionario.app.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vehicles")
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "colours")
    private String colour;

    @Column(name = "plaques")
    private String plaque;                 // placa

    @Column(name = "models" )
    private int model;                     // año de modelo

    @Column(name = "brands")
    private String brand;                  // marca

    @Column(name = "categorys")
    private String category;               // Tipo de automovil
    
    @Column(name = "price_base_vehicle")  
    private double priceBaseVehicle;	   // Valor base carro 	

    @ManyToOne
    @JoinColumn(name = "idConcessionaire")
    Concessionare idConcessionare;
    
    @OneToOne(mappedBy = "idVehicle")
    Sale idSale;
    
    @ManyToMany(mappedBy = "listVehicle")
    List<Employee> listVehicle;
}