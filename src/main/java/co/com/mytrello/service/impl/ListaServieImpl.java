package co.com.mytrello.service.impl;

import co.com.mytrello.repository.ListaRepository;
import co.com.mytrello.repository.domain.Lista;
import co.com.mytrello.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaServieImpl implements ListaService {

    @Autowired
    private ListaRepository listaRepository;

    @Override
    public Long count() {
        return listaRepository.count();
    }

    @Override
    public boolean exists(Long id) {
        return listaRepository.existsById(id);
    }

    @Override
    public List<Lista> findAll() {
        return (List<Lista>) listaRepository.findAll();
    }

    @Override
    public Lista findById(Long id) {
        return listaRepository.findById(id).get();
    }

    @Override
    public Lista save(Lista lista) {
        return listaRepository.save(lista);
    }

    @Override
    public List<Lista> saveAll(List<Lista> listas) {
        return (List<Lista>) listaRepository.saveAll(listas);
    }

    @Override
    public Lista update(Lista lista) {
        return listaRepository.save(lista);
    }

    @Override
    public void deleteById(Long id) {
        listaRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        listaRepository.deleteAll();
    }
}
