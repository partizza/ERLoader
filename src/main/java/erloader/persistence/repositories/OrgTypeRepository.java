package erloader.persistence.repositories;


import org.springframework.data.repository.CrudRepository;
import erloader.persistence.entities.TOrgType;

public interface OrgTypeRepository extends CrudRepository<TOrgType, String> {
}
