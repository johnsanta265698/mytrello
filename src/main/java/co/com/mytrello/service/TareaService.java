package co.com.mytrello.service;

import co.com.mytrello.repository.domain.Tarea;
import co.com.mytrello.service.suport.ServiceOperationSupport;

import java.util.List;

public interface TareaService extends ServiceOperationSupport<Tarea> {

    List<Tarea> findByListaId(Long id);
}
