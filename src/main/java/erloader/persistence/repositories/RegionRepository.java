package erloader.persistence.repositories;


import erloader.persistence.entities.TRegion;
import org.springframework.data.repository.CrudRepository;

public interface RegionRepository extends CrudRepository<TRegion, String> {
}
