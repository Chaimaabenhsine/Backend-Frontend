package projet.micro.auth.mapper;

import org.mapstruct.Mapper;
import projet.micro.auth.dto.UserRequestDTO;
import projet.micro.auth.dto.UserResponseDTO;
import projet.micro.auth.model.User;

@Mapper(componentModel="spring", uses=UserMapper.class)
public interface UserMapper 
{
    User convertToEntity(UserRequestDTO user);
    UserResponseDTO toDto(User user);
}
