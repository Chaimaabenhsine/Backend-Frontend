package projet.micro.auth.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import projet.micro.auth.dto.RoleDTO;
import projet.micro.auth.mapper.RoleMapper;
import projet.micro.auth.model.Role;
import projet.micro.auth.repo.RoleRepository;

@Service @Transactional @RequiredArgsConstructor
public class RoleServiceImpl implements RoleService  {


    private final RoleRepository roleRepository;
	private final RoleMapper roleMapper;
    

    
    @Override
    public RoleDTO saveRole(RoleDTO role)
    {
        return roleMapper.convertToDto(roleRepository.save(roleMapper.convertToEntity(role)));
    }


    
    @Override
	@Transactional(readOnly=true)
    public List<RoleDTO> getRoles()
    {
        return roleRepository.findAll().stream().map(roleMapper::convertToDto).collect(Collectors.toList());
    }

    
   	@Override
   	public void deleteById(Long id) 
   	{
   		roleRepository.deleteById(id);	
   	}

   	
   	@Override
	@Transactional(readOnly=true)
   	public RoleDTO getRole(String name)
   	{
   		return roleMapper.convertToDto(roleRepository.findByName(name));
   	}
}
