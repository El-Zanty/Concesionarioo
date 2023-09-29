package com.credibanco.conceseionario.app.service.Iconcesionare;

import com.credibanco.conceseionario.app.dto.ClientDTO;
import com.credibanco.conceseionario.app.dto.ConcessionareDTO;
import com.credibanco.conceseionario.app.dto.EmployeeDTO;
import com.credibanco.conceseionario.app.dto.SaleDTO;
import com.credibanco.conceseionario.app.dto.VehicleDTO;


public interface IConcessionareUpdateServ {
	
	public void updateClient(ClientDTO clientDTO);
	public void updateEmployee(EmployeeDTO employeeDTO);
	public void updateVehicle (VehicleDTO vehicleDTO);
	public void updateSale(SaleDTO saleDTO);
	public void updateConcessionare(ConcessionareDTO concessionareDTO);
	

}
