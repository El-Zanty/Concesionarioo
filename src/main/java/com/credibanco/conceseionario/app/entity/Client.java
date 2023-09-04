package com.credibanco.conceseionario.app.entity;

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
	@Column (name = "datesofBirths")
	private Date  dateofBirht;

	@JsonIgnore // // Anotación para evitar recursión en la serialización JSON
	@OneToMany(mappedBy = "idClient")
	private List<Sale> saleList;

	
}
