package projet.micro.auth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projet.micro.auth.dto.BusinessUnitDto;
import projet.micro.auth.dto.CriteriaDto;
import projet.micro.auth.exception.AlreadyExistException;
import projet.micro.auth.exception.NotExistException;


public interface BusinessUnitService 
{
	Optional<BusinessUnitDto> findBusinessUnit(Long id) ;
	
	List<BusinessUnitDto> findAll();
	
	BusinessUnitDto save(BusinessUnitDto businessUnitDto) throws AlreadyExistException;
	
	void delete(Long id) ;
	
	BusinessUnitDto update(BusinessUnitDto businessUnitDto,Long id) throws NotExistException;

	Page<BusinessUnitDto> findByCriteria(CriteriaDto criteria, Pageable page);

}
