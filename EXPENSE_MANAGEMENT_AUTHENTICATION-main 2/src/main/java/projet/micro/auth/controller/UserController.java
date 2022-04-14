 package projet.micro.auth.controller;


import java.io.IOException;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import projet.micro.auth.controller.handler.ExceptionHandling;
import projet.micro.auth.dto.UserRequestDTO;
import projet.micro.auth.dto.UserResponseDTO;
import projet.micro.auth.exception.UsernameExistException;
import projet.micro.auth.service.UserService;


@RestController
@RequestMapping("/api/users") @RequiredArgsConstructor
public class UserController extends ExceptionHandling
{
	
    private final UserService userService;

    @GetMapping
    public List<UserResponseDTO> getUsers()
    {
        return userService.getUsers();
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATEUR')")
    @GetMapping("/{username}")
    public UserResponseDTO getUser(@PathVariable String username)
    {
        return userService.getUser(username);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMINISTRATEUR')")
    @PostMapping
    public UserResponseDTO saveUser(@Valid @RequestBody UserRequestDTO user) throws UsernameExistException
    {
          return userService.saveUser(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATEUR')")
    @PutMapping("/{id}")
	public UserResponseDTO updateUser(@PathVariable Long id,@RequestBody UserRequestDTO user)
	{
		return userService.updateUser(user,id);
	}
	
    @PreAuthorize("hasRole('ROLE_ADMINISTRATEUR')")
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id)
	{
		 userService.deleteById(id);
	}
   
	
    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException 
    {
    	System.out.print("im inside the controller");
       userService.refreshToken(httpServletRequest, httpServletResponse);
    }
}

