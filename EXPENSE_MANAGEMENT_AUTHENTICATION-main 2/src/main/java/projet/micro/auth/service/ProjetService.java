package projet.micro.auth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projet.micro.auth.dto.CriteriaDto;
import projet.micro.auth.dto.ProjetDto;


public interface ProjetService 
{
	Optional<ProjetDto> findProjet(Long id);
	
	List<ProjetDto> findAll();
	
	ProjetDto save(ProjetDto projetDto);
	
	void delete(Long id);

	ProjetDto update(ProjetDto projetDto,Long id);

	Page<ProjetDto> findByCriteria(CriteriaDto criteria, Pageable page);
}
