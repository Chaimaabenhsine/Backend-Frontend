package projet.micro.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import projet.micro.auth.model.Role;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data @AllArgsConstructor
public class UserRequestDTO 
{
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private List<RoleDTO> roles=new ArrayList<>();
}
