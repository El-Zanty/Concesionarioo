package com.credibanco.conceseionario.app.service;

import java.util.List;

import com.credibanco.conceseionario.app.dto.SaleDTO;
import com.credibanco.conceseionario.app.entity.*;

public interface IEmployeeServ {
	
	public List<Client> findAllClients();
	public List<Vehicle> findAllVehicles();
	public List<Sale> findAllSales();
	public void createSale(SaleDTO saleDTO);
	public void updateSale(SaleDTO saleDTO);
}
