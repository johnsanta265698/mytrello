package co.com.mytrello.service.suport;

import java.util.List;

public interface ServiceOperationSupport<Entities> {

    Long count();

    boolean exists(Long id);

    List<Entities> findAll();

    Entities findById(Long id);

    Entities save(Entities dto);

    List<Entities> saveAll(List<Entities> dto);

    Entities update(Entities dto);

    void deleteById(Long id);

    void deleteAll();
}
