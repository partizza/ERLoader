package erloader.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import erloader.persistence.entities.ExchRate;

public interface ExchRateRepository extends CrudRepository<ExchRate, Long> {
}
