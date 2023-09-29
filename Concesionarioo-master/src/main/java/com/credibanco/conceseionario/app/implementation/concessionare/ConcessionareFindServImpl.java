package com.credibanco.conceseionario.app.implementation.concessionare;

import java.util.List;
import java.util.Optional;

import com.credibanco.conceseionario.app.entity.Client;
import com.credibanco.conceseionario.app.entity.Concessionare;
import com.credibanco.conceseionario.app.entity.Employee;
import com.credibanco.conceseionario.app.entity.Sale;
import com.credibanco.conceseionario.app.entity.Vehicle;
import com.credibanco.conceseionario.app.repository.IClientRepository;
import com.credibanco.conceseionario.app.repository.IConcessionareRepository;
import com.credibanco.conceseionario.app.repository.IEmployeeRepository;
import com.credibanco.conceseionario.app.repository.ISaleRepository;
import com.credibanco.conceseionario.app.repository.IVehicleRepository;
import com.credibanco.conceseionario.app.service.Iconcesionare.IConcessionareFindServ;
import com.credibanco.conceseionario.app.utils.exceptions.GlobalExceptions;

public class ConcessionareFindServImpl implements IConcessionareFindServ {
	
	private final IClientRepository clientRepository;
	private final IEmployeeRepository employeeRepository;
	private final IVehicleRepository vehicleRepository;
	private final ISaleRepository saleRepository;
	private final IConcessionareRepository concessionareRepository;
 
	
	public ConcessionareFindServImpl(IClientRepository clientRepository, IEmployeeRepository employeeRepository,
			IVehicleRepository vehicleRepository, ISaleRepository saleRepository,
			IConcessionareRepository concessionareRepository) {
		super();
		this.clientRepository = clientRepository;
		this.employeeRepository = employeeRepository;
		this.vehicleRepository = vehicleRepository;
		this.saleRepository = saleRepository;
		this.concessionareRepository = concessionareRepository;
	}

	@Override
	public List<Client> findAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client findClientById(int id) {
		Optional<Client> existingClient = clientRepository.findById(id);
		
		if(existingClient.isPresent()){
			return existingClient.get();
		}else {
			throw GlobalExceptions.clientNotFoundException(id);
		}
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(int id) {
		Optional<Employee> existingEmployeeOpt = employeeRepository.findById(id);
		
		if(existingEmployeeOpt.isPresent()) {
		return existingEmployeeOpt.get();
	}else {
		throw GlobalExceptions.employeeNotFoundException(id);
	}
}
	
	@Override
	public List<Vehicle> findAllVehicles() {
		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle findVehicleById(int id) {
		Optional<Vehicle> existingVehicleOpt = vehicleRepository.findById(id);
		
		if(existingVehicleOpt.isPresent()) {
			return existingVehicleOpt.get();
		}else {
			throw GlobalExceptions.vehicleNotFoundException(id);
		}
	}

	@Override
	public List<Sale> findAllSales() {	
		return saleRepository.findAll();
	}

	@Override
	public Sale findSaleById(int id) {
		Optional<Sale> existingSaleOpt = saleRepository.findById(id);
		if(existingSaleOpt.isPresent()) {
			return existingSaleOpt.get();
			}else {
				throw GlobalExceptions.saleNotFoundException(id);
			}	
	}

	@Override
	public List<Concessionare> findAllConcessionare() {
		return concessionareRepository.findAll();
	}
	

}
