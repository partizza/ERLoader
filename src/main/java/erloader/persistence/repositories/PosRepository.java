package erloader.persistence.repositories;


import org.springframework.data.repository.CrudRepository;
import erloader.persistence.entities.Pos;

public interface PosRepository extends CrudRepository<Pos, String>{
}
