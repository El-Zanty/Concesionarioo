package com.credibanco.conceseionario.app.service;

import java.util.List;

import com.credibanco.conceseionario.app.dto.ClientDTO;
import com.credibanco.conceseionario.app.entity.*;

public interface IClientServ  {
	public List<Concessionare> findAllConcessionares();
	public List<Vehicle> findAllVehicles();
	public List<Sale> findAllSales();
	public Vehicle findbyIdVehicle(int id);
	public void updateClient(ClientDTO clientDTO);
	public void createClient(ClientDTO clientDTO);
	public void deleteClient(int id);
}
