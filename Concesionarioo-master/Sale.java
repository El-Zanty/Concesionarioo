package com.credibanco.conceseionario.app.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sales")
@Data

public class Sale implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@jakarta.persistence.Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dates")
	private Date date;
	
	@Column (name = "paymentMethods")
	private String paymentMethod;
	
	@Column (name = "totalSales")
	private int totalSale; 
	
	@Column (name = "nameClients")
	private  String nameClient;
	
	@Column (name = "lastNameClients")
	private String lastNameClient;
	
	@Column (name = "nameEmployees")
	private String nameEmployee; 
	
	@Column (name = "lastNameEmployees")
	private String lastNameEmployee;
	
	@Column (name = "prices")
	private Long price;
	
	@Column (name = "referenceNumber")
	private String referenceNumber;
	
	
	
	
}
