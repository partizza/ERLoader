package erloader.persistence.repositories;


import org.springframework.data.repository.CrudRepository;
import erloader.persistence.entities.TCurrency;

public interface CurrencyRepository extends CrudRepository<TCurrency,String>{
}
