package com.credibanco.conceseionario.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.credibanco.conceseionario.app.dto.ClientDTO;
import com.credibanco.conceseionario.app.entity.Client;

@Mapper(componentModel = "spring") //  Le dice a MapStruct que genere una implementación de esta interfaz como un componente de Spring. // Esto significa que MapStruct creará automáticamente el código para el método clientToDto
public interface IClientMapper {
	
	ClientDTO clientToDto(Client client);
	Client dtoToClient(ClientDTO clientDTO);
	
	@Mapping(source = "name", target = "name")  //
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "cellPhone", target = "cellPhone")
	@Mapping(source = "email", target = "email")
	@Mapping(source = "dateOfBirth", target = "dateOfBirth")
    void updateDtoToClient(ClientDTO updateDTO, @MappingTarget Client client);
	
	

}
