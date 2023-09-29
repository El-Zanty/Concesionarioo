package com.credibanco.conceseionario.app.implementation.concessionare;

import java.util.Optional;

import com.credibanco.conceseionario.app.dto.ClientDTO;
import com.credibanco.conceseionario.app.dto.ConcessionareDTO;
import com.credibanco.conceseionario.app.dto.EmployeeDTO;
import com.credibanco.conceseionario.app.dto.SaleDTO;
import com.credibanco.conceseionario.app.dto.VehicleDTO;
import com.credibanco.conceseionario.app.entity.Concessionare;
import com.credibanco.conceseionario.app.entity.Employee;
import com.credibanco.conceseionario.app.entity.Vehicle;
import com.credibanco.conceseionario.app.mapper.IConcessionareMapper;
import com.credibanco.conceseionario.app.mapper.IEmployeeMapper;
import com.credibanco.conceseionario.app.mapper.IVehicleMapper;
import com.credibanco.conceseionario.app.repository.IConcessionareRepository;
import com.credibanco.conceseionario.app.repository.IEmployeeRepository;
import com.credibanco.conceseionario.app.repository.IVehicleRepository;
import com.credibanco.conceseionario.app.service.IClientServ;
import com.credibanco.conceseionario.app.service.IEmployeeServ;
import com.credibanco.conceseionario.app.service.Iconcesionare.IConcessionareUpdateServ;
import com.credibanco.conceseionario.app.utils.exceptions.GlobalExceptions;

public class ConcessionareUpdateServImpl implements IConcessionareUpdateServ {
	
	private final IClientServ clientServ;
	private final IEmployeeMapper employeeMapper;
	private final IVehicleMapper vehicleMapper;
	private final IEmployeeServ employeeServ;
	private final IConcessionareMapper conceMapper;
	private final IEmployeeRepository employeeRepository;
	private final IVehicleRepository vehicleRepository;
	private final IConcessionareRepository conceRepository;
	
	
	
	
	public ConcessionareUpdateServImpl( IEmployeeMapper employeeMapper,IVehicleMapper vehicleMapper,  IConcessionareMapper conceMapper,
			 IEmployeeRepository employeeRepository,
			IVehicleRepository vehicleRepository, 
			IConcessionareRepository conceRepository, IClientServ clientServ, IEmployeeServ employeeServ) {
		super();
		this.clientServ = clientServ;
		this.employeeMapper = employeeMapper;
		this.vehicleMapper = vehicleMapper;
		this.employeeServ = employeeServ;
		this.conceMapper = conceMapper;
		this.employeeRepository = employeeRepository;
		this.vehicleRepository = vehicleRepository;
		this.conceRepository = conceRepository;
	}

	@Override
	public void updateClient(ClientDTO clientDTO) {
		clientServ.updateClient(clientDTO);
	}

	@Override
	public void updateEmployee(EmployeeDTO employeeDTO) {
		Optional<Employee> existingEmployeeOpt = employeeRepository.findById(employeeDTO.getId());
		
		if(existingEmployeeOpt.isPresent()) {
			 Employee existingEmployee = existingEmployeeOpt.get();
			 try{
				 employeeMapper.updateDtoToEmployee(employeeDTO, existingEmployee);
				 employeeRepository.save(existingEmployee);
			 }catch(Exception e) {
				 throw GlobalExceptions.employeeUpdateException(employeeDTO.getId());
			 } 
		}else {
			 throw GlobalExceptions.employeeNotFoundException(employeeDTO.getId());
		 	  }
	}

	@Override
	public void updateVehicle(VehicleDTO vehicleDTO) {
		Optional<Vehicle> existingVehicleOpt = vehicleRepository.findById(vehicleDTO.getId());
		
		if(existingVehicleOpt.isPresent()){
			Vehicle existingVehicle = existingVehicleOpt.get();
			try {
				vehicleMapper.updateDtoToVehicle(vehicleDTO, existingVehicle);
				vehicleRepository.save(existingVehicle);}
			catch(Exception e) {
				throw GlobalExceptions.vehicleUpdateException(vehicleDTO.getId());}
		}else { 
		 throw	GlobalExceptions.vehicleNotFoundException(vehicleDTO.getId());}
	}

	@Override
	public void updateSale(SaleDTO saleDTO) {
		employeeServ.updateSale(saleDTO);
	}

	@Override
	public void updateConcessionare(ConcessionareDTO concessionareDTO) {
		Optional<Concessionare> existingConceOpt = conceRepository.findById(concessionareDTO.getId());
		if(existingConceOpt.isPresent()) {
			Concessionare existingConce = existingConceOpt.get();
			try {
				conceMapper.updatedConcessionare(concessionareDTO, existingConce);
				conceRepository.save(existingConce);
			}catch(Exception e) {
				GlobalExceptions.concessionareUpdateException(concessionareDTO.getId());
			}
		}
		
	}

}
