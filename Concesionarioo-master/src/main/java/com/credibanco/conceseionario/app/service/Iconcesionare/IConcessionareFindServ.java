package com.credibanco.conceseionario.app.service.Iconcesionare;

import java.util.List;

import com.credibanco.conceseionario.app.entity.Client;
import com.credibanco.conceseionario.app.entity.Concessionare;
import com.credibanco.conceseionario.app.entity.Employee;
import com.credibanco.conceseionario.app.entity.Sale;
import com.credibanco.conceseionario.app.entity.Vehicle;

public interface IConcessionareFindServ {
	
	public List<Client> findAllClients();
	public Client findClientById(int id);
	public List<Employee> findAllEmployees();
	public Employee findEmployeeById(int id);
	public List<Vehicle> findAllVehicles();
	public Vehicle findVehicleById(int id);
	public List<Sale> findAllSales();
	public Sale findSaleById(int id);
	public List<Concessionare> findAllConcessionare();
}
