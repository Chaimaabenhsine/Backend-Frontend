package projet.micro.auth.service;

import java.util.List;

import projet.micro.auth.dto.RoleDTO;
import projet.micro.auth.model.Role;

public interface RoleService {

	RoleDTO saveRole(RoleDTO role);

	List<RoleDTO> getRoles();

	RoleDTO getRole(String name);

	void deleteById(Long id);

}
