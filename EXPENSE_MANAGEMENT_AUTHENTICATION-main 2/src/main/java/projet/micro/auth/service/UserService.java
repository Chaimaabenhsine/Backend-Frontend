package projet.micro.auth.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import projet.micro.auth.dto.UserRequestDTO;
import projet.micro.auth.dto.UserResponseDTO;
import projet.micro.auth.exception.UsernameExistException;
import projet.micro.auth.model.User;


public interface UserService 
{
	UserResponseDTO saveUser(UserRequestDTO user) throws UsernameExistException;
    UserResponseDTO updateUser(UserRequestDTO user, Long id);
    UserResponseDTO getUser(String userName);
    
	void deleteById(Long id);
	
    List<UserResponseDTO> getUsers();
    
    UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;
    
	void refreshToken(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException;

}
