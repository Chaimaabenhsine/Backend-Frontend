package projet.micro.auth.controller;

import java.util.List;
import java.util.Optional;


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
import projet.micro.auth.dto.ProjetDto;
import projet.micro.auth.service.ProjetService;

@RestController
@RequestMapping("/api/projet")
@RequiredArgsConstructor
public class ProjetController 
{
	private final ProjetService projetService;
	
	@GetMapping("{id}")
    public Optional<ProjetDto> getProjet(@PathVariable Long id)
	{
		return projetService.findProjet(id);
    }
	
	@GetMapping
	public List<ProjetDto> getAll()
	{
		return projetService.findAll();
	}

	@PostMapping
	public ProjetDto saveProjet(@RequestBody ProjetDto projetDto)
	{
		 return projetService.save(projetDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteProjet(@PathVariable Long id) {
		projetService.delete(id);
        return ResponseEntity.noContent().build();
    }
	
	@PutMapping("{id}")
	public ProjetDto updateProjet(@RequestBody ProjetDto projetDto, @PathVariable Long id)
	{
		return projetService.update(projetDto,id);

	}

}