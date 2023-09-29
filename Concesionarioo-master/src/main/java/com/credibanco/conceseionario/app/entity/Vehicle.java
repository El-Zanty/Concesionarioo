package com.credibanco.conceseionario.app.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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
    private LocalDate model;                     // año de modelo
    
    @Pattern(regexp ="^[a-zA-Z]*$" )
    @Column(name = "brands")
    private String brand;                  // marca
    
    @Pattern(regexp ="^[a-zA-Z]*$" )
    @Column(name = "categorys")
    private String category;               // Tipo de automovil
    
    
    @Column(name = "price_base_vehicle")  
    private BigDecimal priceBaseVehicle;	   // Valor base carro 	

    @ManyToOne
    @JoinColumn(name = "idConcessionaire")
    Concessionare idConcessionare;
    
    @OneToOne(mappedBy = "idVehicle")
    Sale idSale;
    
    @ManyToMany(mappedBy = "listVehicle")
    List<Employee> listVehicle;
    
    @ManyToOne
	@JoinColumn(name = "idClient")
	 private Client idClient;
}