package projet.micro.auth.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import lombok.RequiredArgsConstructor;
import projet.micro.auth.dto.CriteriaDto;
import projet.micro.auth.dto.ProjetDto;
import projet.micro.auth.mapper.ProjetMapper;
import projet.micro.auth.model.Projet;
import projet.micro.auth.repo.ProjetRepo;
import projet.micro.auth.specification.GenericSpecificationsBuilder;
import projet.micro.auth.specification.SpecificationFactory;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjetServiceImpl  implements ProjetService
{
	private final ProjetRepo projetRepo;
	private final ProjetMapper projetMapper;
    private final SpecificationFactory<Projet> projetSpecificationFactory;


	@Override
	@Transactional(readOnly=true)
	public Optional<ProjetDto> findProjet(Long id)
	{
		return projetRepo.findById(id).map(projetMapper::convertToDto);
	}

	
	@Override
	@Transactional(readOnly=true)
	public List<ProjetDto> findAll() 
	{
		return projetRepo.findAll().stream().map(projetMapper::convertToDto).collect(Collectors.toList());
	}

	
	@Override
	public ProjetDto save(ProjetDto projetDto) 
	{
		return projetMapper.convertToDto(projetRepo.save(projetMapper.convertToEntity(projetDto)));
	}
	

	@Override
	public void delete(Long id) 
	{
		projetRepo.deleteById(id);
	}
	
	@Override
	public ProjetDto update(ProjetDto projetDto, Long id) 
	{
	    projetDto.setId(id);
	    return projetMapper.convertToDto(projetRepo.save(projetMapper.convertToEntity(projetDto)));
	}

	 @Override
	    @Transactional(readOnly = true)
	    public Page<ProjetDto> findByCriteria(CriteriaDto criteria, Pageable page) {
	        GenericSpecificationsBuilder<Projet> builder = new GenericSpecificationsBuilder<>();
	        if (null!=criteria.getId()) {
	            builder.with(projetSpecificationFactory.isEqual("id",  criteria.getId()));
	        }
	        if (criteria.getNomProjet()!=null) {
	            builder.with(projetSpecificationFactory.isLike("nomProjet", criteria.getNomProjet().trim()));
	        }
	        return projetRepo.findAll(builder.build(), page).map(projetMapper::convertToDto);
	    }
}
