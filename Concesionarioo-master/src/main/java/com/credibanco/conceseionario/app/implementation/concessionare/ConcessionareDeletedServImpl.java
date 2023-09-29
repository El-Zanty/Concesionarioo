package com.credibanco.conceseionario.app.implementation.concessionare;

import java.util.Optional;


import com.credibanco.conceseionario.app.entity.Concessionare;
import com.credibanco.conceseionario.app.entity.Employee;
import com.credibanco.conceseionario.app.entity.Sale;
import com.credibanco.conceseionario.app.entity.Vehicle;
import com.credibanco.conceseionario.app.repository.IConcessionareRepository;
import com.credibanco.conceseionario.app.repository.IEmployeeRepository;
import com.credibanco.conceseionario.app.repository.ISaleRepository;
import com.credibanco.conceseionario.app.repository.IVehicleRepository;
import com.credibanco.conceseionario.app.service.IClientServ;
import com.credibanco.conceseionario.app.service.Iconcesionare.IConcessionareDeletedServ;
import com.credibanco.conceseionario.app.utils.exceptions.GlobalExceptions;

public class ConcessionareDeletedServImpl implements IConcessionareDeletedServ {
	
	private final IEmployeeRepository employeeRepository;
	private final IVehicleRepository vehicleRepository;
	private final ISaleRepository saleRepository;
	private final IConcessionareRepository concessionareRepository;
	private final IClientServ iclientServ;
	
	public ConcessionareDeletedServImpl(IEmployeeRepository employeeRepository, IVehicleRepository vehicleRepository,  ISaleRepository saleRepository, IConcessionareRepository concessionareRepository, IClientServ iclientServ ) {
		super();
		this.concessionareRepository = concessionareRepository;
		this.employeeRepository = employeeRepository;
		this.vehicleRepository = vehicleRepository;
		this.saleRepository = saleRepository;
		this.iclientServ = iclientServ;
		
	}
	@Override
	public void deletedClient(int id) {
	 iclientServ.deleteClient(id);
	}

	@Override
	public void deletedEmployee(int id) {
		Optional<Employee> existingEmployeeOpt = employeeRepository.findById(id);
		
		if(existingEmployeeOpt.isPresent()) {
			employeeRepository.delete(existingEmployeeOpt.get());
		}else {
			throw GlobalExceptions.employeeNotFoundException(id);
		}
	}

	@Override
	public void deletedVehicle(int id) {
		Optional<Vehicle> existingVehicleOpt = vehicleRepository.findById(id);
		
		if(existingVehicleOpt.isPresent()) {
			vehicleRepository.delete(existingVehicleOpt.get());
		}else {
			throw GlobalExceptions.vehicleNotFoundException(id);
		}
	}

	@Override
	public void deletedSale(int id) {
		Optional<Sale> existingSaleOpt = saleRepository.findById(id);
		
		if(existingSaleOpt.isPresent()) {
			saleRepository.delete(existingSaleOpt.get());
		}else {
			throw GlobalExceptions.saleNotFoundException(id);
		}
	}

	@Override
	public void deletedConcessionare(int id) {
		Optional<Concessionare> existingConcessionareOpt = concessionareRepository.findById(id);
		
		if(existingConcessionareOpt.isPresent()) {
			concessionareRepository.delete(existingConcessionareOpt.get());
		}else {
			throw GlobalExceptions.concessionareNotFoundException(id);
		}
		
	}

}
