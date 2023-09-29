package com.credibanco.conceseionario.app.implementation.concessionare;

import org.springframework.stereotype.Service;

import com.credibanco.conceseionario.app.dto.ClientDTO;
import com.credibanco.conceseionario.app.dto.ConcessionareDTO;
import com.credibanco.conceseionario.app.dto.EmployeeDTO;
import com.credibanco.conceseionario.app.dto.SaleDTO;
import com.credibanco.conceseionario.app.dto.VehicleDTO;
import com.credibanco.conceseionario.app.entity.Client;
import com.credibanco.conceseionario.app.entity.Concessionare;
import com.credibanco.conceseionario.app.entity.Employee;
import com.credibanco.conceseionario.app.entity.Sale;
import com.credibanco.conceseionario.app.entity.Vehicle;
import com.credibanco.conceseionario.app.mapper.IClientMapper;
import com.credibanco.conceseionario.app.mapper.IConcessionareMapper;
import com.credibanco.conceseionario.app.mapper.IEmployeeMapper;
import com.credibanco.conceseionario.app.mapper.ISaleMapper;
import com.credibanco.conceseionario.app.mapper.IVehicleMapper;
import com.credibanco.conceseionario.app.repository.IClientRepository;
import com.credibanco.conceseionario.app.repository.IConcessionareRepository;
import com.credibanco.conceseionario.app.repository.IEmployeeRepository;
import com.credibanco.conceseionario.app.repository.ISaleRepository;
import com.credibanco.conceseionario.app.repository.IVehicleRepository;
import com.credibanco.conceseionario.app.service.Iconcesionare.IConcessionareCreateServ;

@Service
public class ConcessionareCreateServImpl implements IConcessionareCreateServ  {
	
	private final IConcessionareMapper conceMapper;
	private final IClientMapper clientMapper;
	private final IClientRepository clientRepository;
	private final IEmployeeMapper employeeMapper;
	private final IEmployeeRepository employeeRepository;
	private final IVehicleMapper vehicleMapper;
	private final IVehicleRepository vehicleRepository;
	private final ISaleMapper saleMapper;
	private final ISaleRepository saleRepository;
	private final IConcessionareRepository concessionareRepository;
	
	public ConcessionareCreateServImpl(IConcessionareMapper conceMapper, IClientMapper clientMapper, IClientRepository clientRepository, IEmployeeMapper employeeMapper, IEmployeeRepository employeeRepository, IVehicleRepository vehicleRepository, IVehicleMapper vehicleMapper, ISaleRepository saleRepository, ISaleMapper saleMapper, IConcessionareRepository concessionareRepository) {
		super();
		this.conceMapper = conceMapper;
		this.concessionareRepository = concessionareRepository;
		this.clientMapper = clientMapper;
		this.clientRepository = clientRepository;
		this.employeeMapper = employeeMapper;
		this.employeeRepository = employeeRepository;
		this.vehicleMapper = vehicleMapper;
		this.vehicleRepository = vehicleRepository;
		this.saleMapper = saleMapper;
		this.saleRepository = saleRepository;
		
	}

	@Override
	public void createClient(ClientDTO clientDTO) {
		Client client = clientMapper.dtoToClient(clientDTO);
		clientRepository.save(client);
	}
	
	@Override
	public void createEmployee(EmployeeDTO employeeDTO) {
		Employee employee = employeeMapper.dtoToEmployee(employeeDTO);
		employeeRepository.save(employee);		
	}

	@Override
	public void createVehicle(VehicleDTO vehicleDTO) {
	 Vehicle vehicle = 	vehicleMapper.dtoToVehicle(vehicleDTO);
	 vehicleRepository.save(vehicle);
	}

	@Override
	public void createSale(SaleDTO saleDTO) {
	Sale sale = saleMapper.dtoToSale(saleDTO);
	saleRepository.save(sale);
		
	}

	@Override
	public void createConcessionare(ConcessionareDTO concessionareDTO) {
		Concessionare concessionare = conceMapper.dtoToConcessionare(concessionareDTO);
		concessionareRepository.save(concessionare);
		
	}

}
