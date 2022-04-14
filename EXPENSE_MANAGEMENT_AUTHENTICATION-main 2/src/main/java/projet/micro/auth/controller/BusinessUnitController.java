package projet.micro.auth.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;
import projet.micro.auth.controller.handler.ExceptionHandling;
import projet.micro.auth.dto.BusinessUnitDto;
import projet.micro.auth.exception.AlreadyExistException;
import projet.micro.auth.exception.NotExistException;
import projet.micro.auth.service.BusinessUnitService;

@RestController
@RequestMapping("/api/bu")
@RequiredArgsConstructor
public class BusinessUnitController extends ExceptionHandling
{
	private final BusinessUnitService businessUnitService;
	
	@GetMapping("{id}")
    public Optional<BusinessUnitDto> getBusinessUnit(@PathVariable Long id)
	{
		return businessUnitService.findBusinessUnit(id);
    }
	
	@GetMapping
	public List<BusinessUnitDto> getAll()
	{
		return businessUnitService.findAll();
	}

	@PostMapping
	public ResponseEntity<Void> saveBu(@RequestBody BusinessUnitDto businessUnitDto) throws  AlreadyExistException {
		 businessUnitService.save(businessUnitDto);
		 return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteBu(@PathVariable Long id) 
	{
		 businessUnitService.delete(id);
         return ResponseEntity.noContent().build();
    }

	@PutMapping("{id}")
	public BusinessUnitDto updateBusinessUnit(@RequestBody BusinessUnitDto businessUnitDto, @PathVariable Long id) throws NotExistException
	{
		return businessUnitService.update(businessUnitDto,id);

	}
}
