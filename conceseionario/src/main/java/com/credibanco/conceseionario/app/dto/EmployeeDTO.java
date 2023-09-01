package com.credibanco.conceseionario.app.dto;

import java.util.Date;

public class EmployeeDTO {
	private int id;
	private String name;
	private String lastName;
	private Long identificationNumber;
	private Date dateofBirht;
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
	public Long getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(Long identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public Date getDateofBirht() {
		return dateofBirht;
	}
	public void setDateofBirht(Date dateofBirht) {
		this.dateofBirht = dateofBirht;
	}
	
	

}
