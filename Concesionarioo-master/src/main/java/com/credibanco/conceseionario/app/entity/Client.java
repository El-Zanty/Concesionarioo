package com.credibanco.conceseionario.app.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "clients")
@Data
public class Client {
	/**DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");  // Instacia de DateTimeFormatter para obtener el formateo de  tipo fecha 
	LocalDate date = LocalDate.now();
	String formattedDate = date.format(formatter);**/
	@Id // clave primaria de la entidad
	@GeneratedValue(strategy = GenerationType.IDENTITY) // cómo se generará automáticamente el valor de la clave primaria. En este caso, GenerationType.IDENTITY indica que el valor se generará mediante una estrategia de identidad proporcionada por la base de datos subyacentes.
	private int id;
	
	@Pattern(regexp = "^[a-zA-Z]*$")
	@Column(name = "names")
	private String name;
	
	@Pattern(regexp = "^[a-zA-Z]*$")
	@Column(name = "lastnames")
	private String lastName;
	
	@Column(name = "cellphones")    // API de numverify o Abstract’s Phone Validation
	private Long cellPhone;
	
	@Email(message = "Email is not valid")
    @NotEmpty(message = "Email cannot be empty")                     // dirección de correo electrónico válida.
	@Column(name = "emails")
	private String email;
	
	@Column (name = "datesofBirths" , columnDefinition = "DATE")  //DATE. Esto significa que la fecha se almacenará en la base de datos en el formato especificado por el tipo DATE. 
	private LocalDate dateOfBirth;
	
	@JsonIgnore                                                // Anotación para evitar recursión en la serialización JSON
	@OneToMany(mappedBy = "idClient")                          // Nombre que mantiene la relación  
	private List<Sale> listSales;
	
	@ManyToMany(mappedBy = "listClients")
	private List<Employee> listEmployees;
	
	@ManyToMany(mappedBy = "listClients")
	private List<Concessionare> listConcessionares;
	
	@OneToMany(mappedBy = "idClient")
	List<Vehicle> listVhVehicles;	
	


	
}
