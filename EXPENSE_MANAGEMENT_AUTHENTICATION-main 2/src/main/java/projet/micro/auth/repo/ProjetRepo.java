package projet.micro.auth.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import projet.micro.auth.model.Projet;


@Repository
public interface ProjetRepo extends JpaRepository<Projet,Long>, JpaSpecificationExecutor<Projet>
{

}
