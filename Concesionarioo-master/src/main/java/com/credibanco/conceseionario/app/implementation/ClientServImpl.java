package com.credibanco.conceseionario.app.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.credibanco.conceseionario.app.dto.ClientDTO;
import com.credibanco.conceseionario.app.entity.Client;
import com.credibanco.conceseionario.app.entity.Concessionare;
import com.credibanco.conceseionario.app.entity.Sale;
import com.credibanco.conceseionario.app.entity.Vehicle;
import com.credibanco.conceseionario.app.mapper.IClientMapper;
import com.credibanco.conceseionario.app.repository.IClientRepository;
import com.credibanco.conceseionario.app.repository.IConcessionareRepository;
import com.credibanco.conceseionario.app.repository.ISaleRepository;
import com.credibanco.conceseionario.app.repository.IVehicleRepository;
import com.credibanco.conceseionario.app.service.IClientServ;
import com.credibanco.conceseionario.app.utils.exceptions.GlobalExceptions;

@Service
public class ClientServImpl implements IClientServ {
	
	private final IClientMapper mapper;
	private final IClientRepository clientRepository;
	private final IVehicleRepository vehicleRepository;
	private final ISaleRepository saleRepository;
	private final IConcessionareRepository concessionareRepository;

	
	 public ClientServImpl(IClientMapper mapper, IClientRepository clientRepository, IVehicleRepository vehicleRepository, ISaleRepository saleRepository, IConcessionareRepository concessionareRepository) {
		super();
		this.clientRepository = clientRepository; 
		this.mapper = mapper;
		this.saleRepository = saleRepository;
		this.concessionareRepository = concessionareRepository;
		this.vehicleRepository = vehicleRepository;
	}
	 
	 @Override
		public List<Sale> findAllSales() {
		return saleRepository.findAll(); 
		}
	  
	 @Override
		public Vehicle findbyIdVehicle(int id) {
		 Optional<Vehicle> existingVehicleOpt = vehicleRepository.findById(id);

		    if (existingVehicleOpt.isPresent()) {
		        return existingVehicleOpt.get();
		    } else {
		        throw GlobalExceptions.vehicleNotFoundException(id);
		    }
		} 
	 
	 @Override
	 public void deleteClient(int id) {
	     Optional<Client> existingClientOpt = clientRepository.findById(id);

	     if (existingClientOpt.isPresent()) {
	         clientRepository.delete(existingClientOpt.get());
	     } else {
	         throw GlobalExceptions.clientNotFoundException((int)id); //int depronto no es necesario 
	     }
	 }

	 
	 @Override
		public void updateClient(ClientDTO clientDTO) {
		     Optional<Client> existingClientOpt = clientRepository.findById(clientDTO.getId());  // Primero, Buscamos al cliente existente en la base de datos.		     	
		     	
		     if (existingClientOpt.isPresent()) { 												 // Si el cliente existe, actualizamos sus datos.
		            Client existingClient = existingClientOpt.get();
		        try {
		        	mapper.updateDtoToClient(clientDTO, existingClient);
		        	clientRepository.save(existingClient); 									 // Luego, guardamos el cliente actualizado en la base de datos.
		        }catch (Exception e) {
		        	throw   GlobalExceptions.clientUpdateException(clientDTO.getId());    // al ser un metodo estatico no hay nesecidad de hacer le llamado desde el obejeto si no la misma clase. 
		        }    
		     } else {
		    	throw GlobalExceptions.clientNotFoundException(clientDTO.getId());
		     }
		  }  
	  
	@Override
	public List<Concessionare> findAllConcessionares() {
		return concessionareRepository.findAll() ;
	}

	@Override
	public List<Vehicle> findAllVehicles() {
		return vehicleRepository.findAll();
	}

	@Override
	public void createClient(ClientDTO clientDTO) {
		Client client = mapper.dtoToClient(clientDTO);
		clientRepository.save(client);
	}


	
	

	

	
	
	
	 

}
