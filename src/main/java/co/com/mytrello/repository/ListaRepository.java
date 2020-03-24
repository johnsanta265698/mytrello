package co.com.mytrello.repository;

import co.com.mytrello.repository.domain.Lista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository extends CrudRepository<Lista, Long> {
}
