package co.com.mytrello.repository;
import co.com.mytrello.repository.domain.Lista;
import co.com.mytrello.repository.domain.Tarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TareaRepository extends CrudRepository<Tarea, Long> {

    Optional<List<Tarea>> findAllByListaEquals(Lista lista);
}
