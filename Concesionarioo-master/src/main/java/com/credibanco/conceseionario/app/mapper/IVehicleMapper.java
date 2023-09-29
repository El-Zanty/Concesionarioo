package com.credibanco.conceseionario.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import com.credibanco.conceseionario.app.dto.VehicleDTO;
import com.credibanco.conceseionario.app.entity.Vehicle;

@Mapper(componentModel = "spring")
public interface IVehicleMapper {
	VehicleDTO vehicleToDto(Vehicle vehicle);
	Vehicle dtoToVehicle(VehicleDTO vehicleDTO);
	
	@Mapping(source = "colour", target = "colour")  //
    @Mapping(source = "plaque", target = "plaque")
    @Mapping(source = "model", target = "model")
	@Mapping(source = "brand", target = "brand")
	@Mapping(source = "category", target = "category")
	@Mapping(source = "priceBaseVehicle", target = "priceBaseVehicle")
    void updateDtoToVehicle(VehicleDTO updateDTO, @MappingTarget Vehicle vehicle);

}
