package com.credibanco.conceseionario.app.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;



//@SuppressWarnings("unused")// se utiliza para suprimir las advertencias del compilador sobre variables locales o métodos privados no utilizados
public class ClientDTO {
	/* Pattern = Pauta, regimen */
	private int id;
	@Pattern(regexp = "^[a-zA-Z]*$")
	@Size(min =10, max = 100)
	private String name;
	
	@Pattern(regexp = "^[a-zA-Z]*$") 
	@Size(min =10, max = 100)
	private String lastName;
	
	private Long cellPhone;
	@Email
	@NotEmpty(message = "Email cannot be empty")  
	private String email;
	
	private LocalDate dateOfBirth;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(Long cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
}
