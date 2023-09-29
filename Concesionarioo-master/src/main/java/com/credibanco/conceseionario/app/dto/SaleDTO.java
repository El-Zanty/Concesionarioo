package com.credibanco.conceseionario.app.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class SaleDTO {
    //Lower = Inferior, Rate = Tarifa Until = Hasta
    // Vehicle Value Limits
    public static final double LOWER_LIMIT = 49470000.0; // Until $49,470,000
    public static final double LOWER_INTERMEDIATE = 111305000.0; // More of $49,470,000 and until $111,305,000

    // tax rates = tarifas de impuestos. Se aplica  impuesto Dependiendo de cuanto valga el automovil se aplica un diferente impuesto (IVA) u otro.
    public static final double LOWER_RATE = 0.015; // 1.5%
    public static final double INTERMEDIATE_RATE = 0.025; // 2.5%
    public static final double SUPERIOR_RATE = 0.035; // 3.5%

    private int id;
    private LocalDateTime date;          // Guarda fecha y hora de zona horaria local 
    private String paymentMethod;	     // Metodo de pago
    private BigDecimal totalSale;				
    private String nameClient;
    private String lastNameClient;
    private String nameEmployee;
    private String lastNameEmployee;
    private BigDecimal carBasePrice;      // Precio Base Vehiculo 
    private  String branchName;           //nombre de sucursal
    private double iva;
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public BigDecimal getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(BigDecimal totalSale) {
		this.totalSale = totalSale;
	}
	public String getNameClient() {
		return nameClient;
	}
	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}
	public String getLastNameClient() {
		return lastNameClient;
	} 
	public void setLastNameClient(String lastNameClient) {
		this.lastNameClient = lastNameClient;
	}
	public String getNameEmployee() {
		return nameEmployee;
	}
	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}
	public String getLastNameEmployee() {
		return lastNameEmployee;
	}
	public void setLastNameEmployee(String lastNameEmployee) {
		this.lastNameEmployee = lastNameEmployee;
	}
	public BigDecimal getCarBasePrice() {
		return carBasePrice;
	}
	public void setCarBasePrice(BigDecimal carBasePrice) {
		this.carBasePrice = carBasePrice;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public static double getLowerLimit() {
		return LOWER_LIMIT;
	}
	public static double getLowerIntermediate() {
		return LOWER_INTERMEDIATE;
	}
	public static double getLowerRate() {
		return LOWER_RATE;
	}
	public static double getIntermediateRate() {
		return INTERMEDIATE_RATE;
	}
	public static double getSuperiorRate() {
		return SUPERIOR_RATE;
	}

    


}
