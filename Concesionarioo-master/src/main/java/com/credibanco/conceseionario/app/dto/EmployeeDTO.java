package com.credibanco.conceseionario.app.dto;
import java.time.LocalDate;


public class EmployeeDTO {
	private int id;
	private String nameEmployee;
	private String lastNameEmployee;
	private Long identificationNumber;
	private LocalDate dateOfBirht;
	private Long phoneNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNameEmployee() {
		return nameEmployee;
	}
	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}
	public String getLastName() {
		return lastNameEmployee;
	}
	public void setLastName(String lastName) {
		this.lastNameEmployee = lastName;
	}
	public Long getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(Long identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getDateOfBirht() {
		return dateOfBirht;
	}
	public void setDateOfBirht(LocalDate dateOfBirht) {
		this.dateOfBirht = dateOfBirht;
	}
	
	
	

}
