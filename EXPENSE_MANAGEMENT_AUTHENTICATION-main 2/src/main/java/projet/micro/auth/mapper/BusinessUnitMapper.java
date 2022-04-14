package projet.micro.auth.mapper;

import org.mapstruct.Mapper;
import projet.micro.auth.dto.BusinessUnitDto;
import projet.micro.auth.model.BusinessUnit;


@Mapper(componentModel="spring", uses=BusinessUnitMapper.class)
public interface BusinessUnitMapper 
{
	BusinessUnitDto convertToDto(BusinessUnit businessUnit);
	BusinessUnit convertToEntity(BusinessUnitDto businessUnit);
}