package com.credibanco.conceseionario.app.dto;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

// No es necesario anotaciones
public class VehicleDTO {
	
	private int id;
	private String colour;
	private String plaque;           // placa
	private LocalDate model; 	     // año de modelo
	private String brand; 			 // marca
	private String category; 		 // Tipo de automovil
	private BigDecimal priceBaseVehicle; // precio base vehiculo
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getPlaque() {
		return plaque;
	}
	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}
	
	public LocalDate getModel() {
		return model;
	}
	public void setModel(LocalDate model) {
		this.model = model;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public BigDecimal getPriceBaseVehicle() {
		return priceBaseVehicle;
	}
	public void setPriceBaseVehicle(BigDecimal priceBaseVehicle) {
		this.priceBaseVehicle = priceBaseVehicle;
	}

	
}
