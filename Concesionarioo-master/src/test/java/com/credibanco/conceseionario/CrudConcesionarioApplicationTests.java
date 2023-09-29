package com.credibanco.conceseionario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.credibanco.conceseionario.app.dto.ClientDTO;
import com.credibanco.conceseionario.app.dto.SaleDTO;
import com.credibanco.conceseionario.app.entity.Client;
import com.credibanco.conceseionario.app.entity.Concessionare;
import com.credibanco.conceseionario.app.entity.Sale;
import com.credibanco.conceseionario.app.entity.Vehicle;
import com.credibanco.conceseionario.app.implementation.ClientServImpl;
import com.credibanco.conceseionario.app.implementation.EmployeeServImpl;
import com.credibanco.conceseionario.app.mapper.IClientMapper;
import com.credibanco.conceseionario.app.mapper.ISaleMapper;
import com.credibanco.conceseionario.app.repository.IClientRepository;
import com.credibanco.conceseionario.app.repository.IConcessionareRepository;
import com.credibanco.conceseionario.app.repository.ISaleRepository;
import com.credibanco.conceseionario.app.repository.IVehicleRepository;
import com.credibanco.conceseionario.app.utils.exceptions.GlobalExceptions;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CrudConcesionarioApplicationTests {
	
		@Autowired
		private ClientServImpl clientServImpl;
		
		@Autowired
		private EmployeeServImpl employeeServImpl;
		
		@MockBean
		private IClientRepository clientRepository;
		
		@MockBean
		private IVehicleRepository vehicleRepository;
		
		@MockBean
		private IConcessionareRepository concessionareRepository;
		
		@MockBean
		private ISaleRepository saleRepository;
		
		@MockBean
		private IClientMapper mapper;
		
		@MockBean
		private ISaleMapper saleMapper;
	
	//Test clase ClientServImpl
		@Test
		public void testCreateClient() {
			// Crear un ClientDTO de prueba
			ClientDTO clientDTO = new ClientDTO();
			
			// Configurar el comportamiento esperado del mapper y del repositorio
			when(mapper.dtoToClient(any(ClientDTO.class))).thenReturn(new Client());
			when(clientRepository.save(any(Client.class))).thenReturn(new Client());
			
			// Llamar al método que quieres probar
			clientServImpl.createClient(clientDTO);
			
			// Verificar que el mapper y el repositorio se llamaron como se esperaba
			verify(mapper, times(1)).dtoToClient(any(ClientDTO.class));
			verify(clientRepository, times(1)).save(any(Client.class));
		}
	
		
		 
		@Test 
		public void testFindByIdVehicle() {
		    int testId = 1; // Cambia esto al ID que quieras probar
		    Vehicle expectedVehicle = new Vehicle();
		    // Configura los atributos de expectedVehicle según sea necesario

		    when(vehicleRepository.findById(testId)).thenReturn(Optional.of(expectedVehicle));

		    Vehicle actualVehicle = clientServImpl.findbyIdVehicle(testId);

		    assertEquals(expectedVehicle, actualVehicle);
		}

		@Test
		public void testFindByIdVehicleNotFound() {
		    int testId = 1; // Cambia esto al ID que quieras probar

		    when(vehicleRepository.findById(testId)).thenReturn(Optional.empty());

		    assertThrows(GlobalExceptions.class, () -> {
		        clientServImpl.findbyIdVehicle(testId);
		    });
		}
	
		@Test
	    public void testDeleteClient() {
	        // Arrange - arreglar
	        int id = 1;
	        Client client = new Client();
	        when(clientRepository.findById(id)).thenReturn(Optional.of(client));

	        // Act - actuar
	        clientServImpl.deleteClient(id);

	        // Assert - afirmar
	        verify(clientRepository, times(1)).delete(client);
	    }

	    @Test
	    public void testDeleteClient_NotFound() {
	        // Arrange
	        int id = 1;
	        when(clientRepository.findById(id)).thenReturn(Optional.empty());

	        // Act and Assert
	        assertThrows(GlobalExceptions.class, () -> clientServImpl.deleteClient(id));
	    }
	    
	    @Test
	    public void testUpdateClient() {
	        // Arrange
	        ClientDTO clientDTO = new ClientDTO();
	        clientDTO.setId(1);
	        Client client = new Client();
	        when(clientRepository.findById(clientDTO.getId())).thenReturn(Optional.of(client));

	        // Act
	        clientServImpl.updateClient(clientDTO);

	        // Assert
	        verify(mapper, times(1)).updateDtoToClient(clientDTO, client);
	        verify(clientRepository, times(1)).save(client);
	    }
	    
	    @Test
	    public void testUpdateClient_NotFound() {
	        // Arrange
	        ClientDTO clientDTO = new ClientDTO();
	        clientDTO.setId(1);
	        when(clientRepository.findById(clientDTO.getId())).thenReturn(Optional.empty());

	        // Act and Assert
	        assertThrows(GlobalExceptions.class, () -> clientServImpl.updateClient(clientDTO));
	    }
	    
	    @Test
	    public void testUpdateClient_UpdateException() {
	        // Arrange
	        ClientDTO clientDTO = new ClientDTO();
	        clientDTO.setId(1);
	        Client client = new Client();
	        when(clientRepository.findById(clientDTO.getId())).thenReturn(Optional.of(client));
	        doThrow(new RuntimeException()).when(mapper).updateDtoToClient(any(ClientDTO.class), any(Client.class));

	        // Act and Assert
	        assertThrows(GlobalExceptions.class, () -> clientServImpl.updateClient(clientDTO));
	    }
	    
		
	    @Test
	    public void testFindAllConcessionare() {
	    	List<Concessionare> expectedConcessionares = new ArrayList<>();
	    	
	    	Concessionare concessionare1 = new Concessionare();
	    	expectedConcessionares.add(concessionare1);
	    	
	    	Concessionare concessionare2 = new Concessionare();
	    	expectedConcessionares.add(concessionare2);
	    	
	    	when(concessionareRepository.findAll()).thenReturn(expectedConcessionares);
	    	List<Concessionare> actualConcessionares = clientServImpl.findAllConcessionares();
	    	assertEquals(expectedConcessionares, actualConcessionares);
	    }
	    
	    @Test
		public void testFindAllSales() {
			  
			List<Sale> expectedSales = new ArrayList<>();
			    
			    // Crear algunas ventas
			    Sale sale1 = new Sale();
			    // Configura los atributos de sale1 según sea necesario
			    expectedSales.add(sale1);

			    Sale sale2 = new Sale();
			    // Configura los atributos de sale2 según sea necesario
			    expectedSales.add(sale2);

			    // Agrega más ventas si es necesario

			    when(saleRepository.findAll()).thenReturn(expectedSales);

			    List<Sale> actualSales = clientServImpl.findAllSales();

			    assertEquals(expectedSales, actualSales);
			}
	    
	    @Test
	    public void testFindAllVehicles() {
	    	List<Vehicle> expectedVehicle = new ArrayList<>();
	    	 Vehicle vehicle1 = new Vehicle();
	    	 expectedVehicle.add(vehicle1);
	    	 Vehicle vehicle2 = new Vehicle();
	    	 expectedVehicle.add(vehicle2);
	    	 
	    	 when(vehicleRepository.findAll()).thenReturn(expectedVehicle);
	    	 
	    	 List<Vehicle> actualVehicles = clientServImpl.findAllVehicles();
	    	 
	    	 assertEquals(expectedVehicle, actualVehicles);    	 
	    }
	 
	    
	    // Test a la Clase EmployeeServImpl.
	    
	    @Test
	    public void testUpdateSale() {
	    	SaleDTO saleDTO = new SaleDTO();
	    	saleDTO.setId(1);
	    	 Sale sale = new Sale();
	    	 when(saleRepository.findById(saleDTO.getId())).thenReturn(Optional.of(sale));
	    	 
	    	 employeeServImpl.updateSale(saleDTO);
	    	 
	    	 verify(saleMapper, times(1)).updateDtoToSale(saleDTO, sale);
	    	 verify(saleRepository, times(1)).save(sale);
	    	}
	    
	    @Test
	    public void testUpdateSale_NotFound() {
	    SaleDTO saleDTO = new SaleDTO();
	    saleDTO.setId(1);
	    when(saleRepository.findById(saleDTO.getId())).thenReturn(Optional.empty());
	    
	    assertThrows(GlobalExceptions.class, () -> employeeServImpl.updateSale(saleDTO));
	    }
	   
	    @Test
	    public void testUpdateSale_UpdateException() {
	    	SaleDTO saleDTO = new SaleDTO();
	    	saleDTO.setId(1);
	    	Sale sale = new Sale();
	    	
	    	when(saleRepository.findById(saleDTO.getId())).thenReturn(Optional.of(sale));
	    	doThrow(new RuntimeException()).when(saleMapper).updateDtoToSale(any(SaleDTO.class), any(Sale.class));
	    	
	    	assertThrows(GlobalExceptions.class, () -> employeeServImpl.updateSale(saleDTO));
	    	
	    }
	     
	    
}  
