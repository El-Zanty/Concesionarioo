package com.credibanco.conceseionario.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.credibanco.conceseionario.app.dto.ConcessionareDTO;
import com.credibanco.conceseionario.app.entity.Concessionare;

@Mapper(componentModel = "spring")
public interface IConcessionareMapper {
	ConcessionareDTO concessionareToDto(Concessionare concessionare);
	Concessionare dtoToConcessionare(ConcessionareDTO concessionaireDTO);

	@Mapping(source = "nameConcessionare", target = "nameConcessionare")  //
    @Mapping(source = "address", target = "address")
    @Mapping(source = "cellPhone", target = "cellPhone")
	@Mapping(source = "phone", target = "phone")
	void updatedConcessionare( ConcessionareDTO updatedDTO, @MappingTarget Concessionare concessionare);
	}
