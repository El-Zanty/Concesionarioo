package com.credibanco.conceseionario.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import com.credibanco.conceseionario.app.dto.EmployeeDTO;
import com.credibanco.conceseionario.app.entity.Employee;

@Mapper(componentModel = "spring")
public interface IEmployeeMapper {
	
	EmployeeDTO EmployeeToDto(Employee employee);
	Employee dtoToEmployee(EmployeeDTO employeeDTO);
	
	@Mapping(source = "nameEmployee", target = "nameEmployee")  //
    @Mapping(source = "lastNameEmployee", target = "lastNameEmployee")
    @Mapping(source = "dateOfBirht", target = "dateOfBirht")
	@Mapping(source = "phoneNumber", target = "phoneNumber")
    void updateDtoToEmployee(EmployeeDTO updateDTO, @MappingTarget Employee employee);
	

}
