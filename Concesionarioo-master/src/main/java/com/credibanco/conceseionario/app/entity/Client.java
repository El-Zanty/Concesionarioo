package com.credibanco.conceseionario.app.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "clients")
@Data
public class Client {
	
	/**DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");  // Instacia de DateTimeFormatter para obtener el formateo de  tipo fecha 
	LocalDate date = LocalDate.now();
	String formattedDate = date.format(formatter);
	**/
	
	
	@Id // clave primaria de la entidad
	@GeneratedValue(strategy = GenerationType.IDENTITY) // cómo se generará automáticamente el valor de la clave primaria. En este caso, GenerationType.IDENTITY indica que el valor se generará mediante una estrategia de identidad proporcionada por la base de datos subyacentes.
	private int id;
	
	@Column(name = "names")
	private String name;
	@Column(name = "lastnames")
	private String lastname;
	@Column(name = "cellphones")
	private Long cellPhone;
	@Column(name = "emails")
	private String email;
	
	@Column (name = "datesofBirths" , columnDefinition = "DATE")  //DATE. Esto significa que la fecha se almacenará en la base de datos en el formato especificado por el tipo DATE. 
	private LocalDate datesofBirths;
	
	@JsonIgnore                                                // Anotación para evitar recursión en la serialización JSON
	@OneToMany(mappedBy = "idClient")                          // Nombre que mantiene la relación  
	private List<Sale> listSales;
	
	@ManyToMany
	@JoinTable(name = "client_employee",                       // Nombre Tabla intermedia 
	           joinColumns = @JoinColumn(name = "idClient"),
	           inverseJoinColumns = @JoinColumn(name = "idEmployee"))
	private List<Employee> listEmployees; 

	


	
}
