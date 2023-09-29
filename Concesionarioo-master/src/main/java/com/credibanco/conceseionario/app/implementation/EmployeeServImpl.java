package com.credibanco.conceseionario.app.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.credibanco.conceseionario.app.dto.SaleDTO;
import com.credibanco.conceseionario.app.entity.Client;
import com.credibanco.conceseionario.app.entity.Sale;
import com.credibanco.conceseionario.app.entity.Vehicle;
import com.credibanco.conceseionario.app.mapper.ISaleMapper;
import com.credibanco.conceseionario.app.repository.IClientRepository;
import com.credibanco.conceseionario.app.repository.ISaleRepository;
import com.credibanco.conceseionario.app.repository.IVehicleRepository;
import com.credibanco.conceseionario.app.service.IEmployeeServ;
import com.credibanco.conceseionario.app.utils.exceptions.GlobalExceptions;
@Service
public class EmployeeServImpl implements IEmployeeServ {	
	
	private final IClientRepository clientRepository;
	private final IVehicleRepository vehicleRepository;
	private final ISaleRepository saleRepository;
	private final ISaleMapper saleMapper;

	public EmployeeServImpl( IClientRepository clientRepository, IVehicleRepository vehicleRepository, ISaleRepository saleRepository, ISaleMapper saleMapper) {
		super();
		this.clientRepository = clientRepository;
		this.vehicleRepository = vehicleRepository;
		this.saleRepository = saleRepository;
		this.saleMapper = saleMapper;
	}

	@Override
	public List<Client> findAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public List<Vehicle> findAllVehicles() {
		return vehicleRepository.findAll();
	}

	@Override
	public List<Sale> findAllSales() {
		return saleRepository.findAll(); 
	}

	@Override
	public void createSale(SaleDTO saleDTO) {
		Sale sale = saleMapper.dtoToSale(saleDTO);
		saleRepository.save(sale);
		
	} 

	@Override
	public void updateSale(SaleDTO saleDTO) {
		Optional<Sale> existingSaleOpt = saleRepository.findById(saleDTO.getId());
		if(existingSaleOpt.isPresent()) {
			Sale existingSale = existingSaleOpt.get();
			try {
				saleMapper.updateDtoToSale(saleDTO, existingSale);
				saleRepository.save(existingSale);
				}catch(Exception e) {
				 throw GlobalExceptions.saleUpdateException(saleDTO.getId());				 
			}		
		 }else {
			throw GlobalExceptions.saleNotFoundException(saleDTO.getId());			
		}			
		
	}
 
	
}
