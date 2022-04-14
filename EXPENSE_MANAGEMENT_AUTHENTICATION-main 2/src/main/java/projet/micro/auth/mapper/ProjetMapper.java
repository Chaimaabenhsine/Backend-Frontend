package projet.micro.auth.mapper;

import org.mapstruct.Mapper;
import projet.micro.auth.dto.ProjetDto;
import projet.micro.auth.model.Projet;


@Mapper(componentModel="spring", uses=ProjetMapper.class)
public interface ProjetMapper {

    ProjetDto convertToDto(Projet projet);

    Projet convertToEntity(ProjetDto projetDto);

}