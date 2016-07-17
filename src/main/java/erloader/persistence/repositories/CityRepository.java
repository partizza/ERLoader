package erloader.persistence.repositories;


import org.springframework.data.repository.CrudRepository;
import erloader.persistence.entities.TCity;

public interface CityRepository extends CrudRepository<TCity, String> {

}
