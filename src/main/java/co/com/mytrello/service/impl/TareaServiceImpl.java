package co.com.mytrello.service.impl;

import co.com.mytrello.repository.TareaRepository;
import co.com.mytrello.repository.domain.Lista;
import co.com.mytrello.repository.domain.Tarea;
import co.com.mytrello.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public Long count() {
        return tareaRepository.count();
    }

    @Override
    public boolean exists(Long id) {
        return tareaRepository.existsById(id);
    }

    @Override
    public List<Tarea> findAll() {
        return (List<Tarea>) tareaRepository.findAll();
    }

    @Override
    public Tarea findById(Long id) {
        return tareaRepository.findById(id).get();
    }

    @Override
    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public List<Tarea> saveAll(List<Tarea> tareas) {
        return (List<Tarea>) tareaRepository.saveAll(tareas);
    }

    @Override
    public Tarea update(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public void deleteById(Long id) {
        tareaRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        tareaRepository.deleteAll();
    }

    @Override
    public List<Tarea> findByListaId(Long id) {
        Lista lista = new Lista();
        lista.setId(id);
        return  tareaRepository.findAllByListaEquals(lista).orElse(null);
    }
}
