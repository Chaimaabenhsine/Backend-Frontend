package projet.micro.auth.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import lombok.RequiredArgsConstructor;
import projet.micro.auth.dto.BusinessUnitDto;
import projet.micro.auth.dto.CriteriaDto;
import projet.micro.auth.exception.AlreadyExistException;
import projet.micro.auth.exception.NotExistException;
import projet.micro.auth.mapper.BusinessUnitMapper;
import projet.micro.auth.model.BusinessUnit;
import projet.micro.auth.repo.BusinessUnitRepo;
import projet.micro.auth.specification.GenericSpecificationsBuilder;
import projet.micro.auth.specification.SpecificationFactory;

@Service
@Transactional
@RequiredArgsConstructor
public class BusinessUnitServiceImpl implements BusinessUnitService
{
	
	private final BusinessUnitRepo businessUnitRepo;
	private final BusinessUnitMapper businessUnitMapper;
    private final SpecificationFactory<BusinessUnit> buSpecificationFactory;

	
	
	@Override
	@Transactional(readOnly=true)
	public Optional<BusinessUnitDto> findBusinessUnit(Long id)
	{
		return businessUnitRepo.findById(id).map(businessUnitMapper::convertToDto);
	}

	@Override
	@Transactional(readOnly=true)
	public List<BusinessUnitDto> findAll() 
	{
		return businessUnitRepo.findAll().stream().map(businessUnitMapper::convertToDto).collect(Collectors.toList());
	}

	
	@Override
	public BusinessUnitDto save(BusinessUnitDto businessUnitDto) throws AlreadyExistException
	{
		if( businessUnitRepo.findByNomBu(businessUnitDto.getNomBu())!=null )
		{
			throw new AlreadyExistException("Then business Unit you enterred already exist");
		}
		return businessUnitMapper.convertToDto(businessUnitRepo.save(businessUnitMapper.convertToEntity(businessUnitDto)));
	}

	@Override
	public void delete(Long id) 
	{
		businessUnitRepo.deleteById(id);
	}
	
	@Override
	public BusinessUnitDto update(BusinessUnitDto businessUnitDto, Long id) throws NotExistException
	{
		if(!businessUnitRepo.existsById(id)) 
		{
			throw new NotExistException("the busniess unit does not exist");
		}
		businessUnitDto.setId(id);
	    return businessUnitMapper.convertToDto(businessUnitRepo.save(businessUnitMapper.convertToEntity(businessUnitDto)));
	}
	
	@Override
    @Transactional(readOnly = true)
    public Page<BusinessUnitDto> findByCriteria(CriteriaDto criteria, Pageable page) {
		
        GenericSpecificationsBuilder<BusinessUnit> builder = new GenericSpecificationsBuilder<>();
        if (null!=criteria.getId()) {
            builder.with(buSpecificationFactory.isEqual("id",  criteria.getId()));
        }
        if (criteria.getNomBu()!=null) {
            builder.with(buSpecificationFactory.isLike("nomBu", criteria.getNomBu().trim()));
        }
        return businessUnitRepo.findAll(builder.build(), page).map(businessUnitMapper::convertToDto);
    }

}
