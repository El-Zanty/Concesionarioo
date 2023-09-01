package com.credibanco.conceseionario.app.entity;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "clients")
@Data
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
}
