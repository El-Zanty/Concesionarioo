package com.credibanco.conceseionario.app.dto;

import java.util.Date;

import org.springframework.stereotype.Component;


public class ClientDTO {
	
	private int id;
	private String name;
	private String lastName;
	private Long cellPhone;
	private String email;
	private Date  dateofBirht;
	
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
	public Date getDateofBirht() {
		return dateofBirht;
	}
	public void setDateofBirht(Date dateofBirht) {
		this.dateofBirht = dateofBirht;
	}
	
	
}
