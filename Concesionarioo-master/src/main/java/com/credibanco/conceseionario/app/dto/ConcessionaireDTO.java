package com.credibanco.conceseionario.app.dto;

import org.springframework.stereotype.Component;


public class ConcessionaireDTO {
	
	private int id;
	private String nameConcessionare;
	private String address;
	private Long phone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNameConcessionare() {
		return nameConcessionare;
	}

	public void setNameConcessionare(String nameConcessionare) {
		this.nameConcessionare = nameConcessionare;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}

}
