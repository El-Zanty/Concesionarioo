package com.credibanco.conceseionario.app.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "concessionares")
@Data
public class Concessionare {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank
    @Pattern(regexp ="^[a-zA-Z]*$" )
    @Column(name = "names")
    private String nameConcessionare;
    
    @NotBlank
    @Column(name = "adress")
    private String address;
    
    
    @NotBlank
    @Column(name = "phones")
    private Long phone;
    
   @OneToMany(mappedBy = "idConcessionare")
   private List<Sale> listSales;
   
   @OneToMany(mappedBy = "idConcessionare")
   private List<Employee> listEmployees;
   
   @ManyToMany
	@JoinTable(name = "client_concessionare",
					  joinColumns = @JoinColumn(name = "idClient"),
					   inverseJoinColumns =  @JoinColumn(name = "idConcessionare"))
	private List<Client> listClients;
   
   @OneToMany(mappedBy = "idConcessionare")
   private List<Vehicle> listVehicles;
}
