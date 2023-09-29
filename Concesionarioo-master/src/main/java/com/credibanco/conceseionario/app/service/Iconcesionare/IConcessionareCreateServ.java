package com.credibanco.conceseionario.app.service.Iconcesionare;

import com.credibanco.conceseionario.app.dto.ClientDTO;
import com.credibanco.conceseionario.app.dto.ConcessionareDTO;
import com.credibanco.conceseionario.app.dto.EmployeeDTO;
import com.credibanco.conceseionario.app.dto.SaleDTO;
import com.credibanco.conceseionario.app.dto.VehicleDTO;


public interface IConcessionareCreateServ {
	
	public void createClient(ClientDTO clientDTO);
	public void createEmployee(EmployeeDTO employeeDTO);
	public void createVehicle(VehicleDTO vehicleDTO);
	public void createSale(SaleDTO saleDTO);
	public void createConcessionare(ConcessionareDTO concessionareDTO);
	

}
