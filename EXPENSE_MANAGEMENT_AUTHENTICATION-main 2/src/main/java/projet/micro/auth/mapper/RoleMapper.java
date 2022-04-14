package projet.micro.auth.mapper;

import org.mapstruct.Mapper;
import projet.micro.auth.dto.RoleDTO;
import projet.micro.auth.model.Role;

@Mapper(componentModel="spring", uses=RoleMapper.class)
public interface RoleMapper
{
    Role convertToEntity(RoleDTO roleDto);
    RoleDTO convertToDto(Role role);
}
