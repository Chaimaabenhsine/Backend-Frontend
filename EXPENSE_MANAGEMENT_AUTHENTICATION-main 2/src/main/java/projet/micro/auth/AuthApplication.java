package projet.micro.auth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import projet.micro.auth.dto.BusinessUnitDto;
import projet.micro.auth.dto.ProjetDto;
import projet.micro.auth.dto.RoleDTO;
import projet.micro.auth.dto.UserRequestDTO;
import projet.micro.auth.service.BusinessUnitService;
import projet.micro.auth.service.ProjetService;
import projet.micro.auth.service.RoleService;
import projet.micro.auth.service.UserService;


@SpringBootApplication 
public class AuthApplication{

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean 
    CommandLineRunner run(UserService userService, RoleService roleService, BusinessUnitService buService, ProjetService projetService)
    {
    	return args->{
    	    RoleDTO role1= roleService.saveRole(new RoleDTO(1L, "ROLE_ADMINISTRATEUR","test"));
    	    RoleDTO role2= roleService.saveRole(new RoleDTO(2L, "ROLE_RESPONSABLE","test"));
    	    
    	    List<RoleDTO> roles1=new ArrayList<>();
    	    roles1.add(role1);
    	    
    	    
    	    List<RoleDTO> roles2=new ArrayList<>();
    	    roles2.add(role2);
    	    
    	    
    	    userService.saveUser(new UserRequestDTO(1L,"Mahmoud","Atif","login","Mahmoud@gmail.com","login",roles1));
    	    userService.saveUser(new UserRequestDTO(2L,"Khadija","Karimi","login1","Kkarimi@gmail.com","login1",roles2));

            projetService.save(new ProjetDto(1L, "HDKE34","Projet1",2000.02,null,null));
            projetService.save(new ProjetDto(2L, "HDKE34","Projet2",2000.02,null,null));


            buService.save(new BusinessUnitDto(1L,"Bu Java","test"));
            buService.save(new BusinessUnitDto(2L,"BU Python","test"));
    	};
    }




}