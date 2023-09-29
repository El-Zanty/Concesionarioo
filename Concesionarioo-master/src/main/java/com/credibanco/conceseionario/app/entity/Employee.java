package com.credibanco.conceseionario.app.entity;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private int id;
	
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]*$")
	@Column(name = "names_employees")
	private String nameEmployee; 
	
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]*$")
	@Column (name = "last_name_employees")
	private String lastNameEmployee;
	
	
	@NotBlank
	@PositiveOrZero                                 //Validad que sea un nuemro positivo y tambien permite que el nuemero 0 haga parte del valor de la varible
	@Column (name = "identifications")
	private Long identificationNumber;
	
	@Column(name = "date_birth")
	private LocalDate dateOfBirht;                   // LocalDate representa una fecha sin tiempo ni zona horaria,
	
	//@Digits(integer = 10, fraction = 0)            // Maximo de numeros enteros "10" y Decimales "0"
	@Size(max = 10, min = 10)                        // Solo se permiten 10 nuemeros enteros
	@Column(name = "phones_numbers")
	private Long phoneNumber;
	
	
	@ManyToMany
	@JoinTable(name = "client_employee",                       // Nombre Tabla intermedia 
	           joinColumns = @JoinColumn(name = "idClient"),
	           inverseJoinColumns = @JoinColumn(name = "idEmployee"))
	private List<Client> listClients; 									//mappedBy configurado correctamente con el valor "listClients", que es el nombre de la variable que representa la relación en la entidad Employee 
	
	
	@ManyToOne
	@JoinColumn(name = "idConcessionare")
	Concessionare idConcessionare;
	
	@OneToMany(mappedBy = "idEmployee")
	private List<Sale> listSales;
	
	@ManyToMany
	@JoinTable(name = "employee_vehicle",
				joinColumns = @JoinColumn(name = "idVehicle"),
				inverseJoinColumns = @JoinColumn(name = "idEmployee"))
	private List<Vehicle> listVehicles;
	
	
	
	
	
}
