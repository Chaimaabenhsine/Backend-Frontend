package projet.micro.auth.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import projet.micro.auth.model.BusinessUnit;


@Repository
public interface BusinessUnitRepo extends JpaRepository<BusinessUnit,Long>, JpaSpecificationExecutor<BusinessUnit>
{

	BusinessUnit findByNomBu(String nom);

}
