package com.credibanco.conceseionario.app.dto;

import org.springframework.stereotype.Component;

import java.util.Date;

public class EmployeeDTO {
	private int id;
	private String nameEmployee;
	private String lastName;
	private Long identificationNumber;
	private Date dateofBirht;
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
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	

}
