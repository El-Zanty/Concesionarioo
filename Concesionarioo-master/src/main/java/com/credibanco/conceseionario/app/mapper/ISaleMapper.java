package com.credibanco.conceseionario.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.credibanco.conceseionario.app.dto.SaleDTO;
import com.credibanco.conceseionario.app.entity.Sale;

@Mapper(componentModel = "spring")
public interface ISaleMapper {
	
	Sale dtoToSale(SaleDTO saleDTO);
	SaleDTO saleToDto(Sale sale);
	
	@Mapping(source = "date", target = "date") //source = "name" se refiere al atributo name en SaleDTO, y target = "name" se refiere al atributo name en Sale.
	@Mapping(source = "paymentMethod",target = "paymentMethod")
	@Mapping(source = "totalSale", target = "totalSale")
	@Mapping(source = "nameClient", target = "nameClient")
	@Mapping(source = "lastNameClient", target = "lastNameClient")
	@Mapping(source = "nameEmployee", target = "nameEmployee")
	@Mapping(source = "lastNameEmployeee", target = "lastNameEmployee")
	@Mapping(source = "carBasePrice", target = "carBasePrice;")
	@Mapping(source = "branchName", target = "branchName")
	@Mapping(source = "iva", target = "iva")
	void updateDtoToSale(SaleDTO updateDTO, @MappingTarget Sale sale);
}
