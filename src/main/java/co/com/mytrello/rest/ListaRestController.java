package co.com.mytrello.rest;

import co.com.mytrello.repository.domain.Lista;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface ListaRestController {

    ResponseEntity findAll();

    ResponseEntity save(Lista lista, BindingResult result);

    ResponseEntity update(Lista lista, BindingResult result);

    ResponseEntity findById(Long id);

    ResponseEntity deleteById(Long id);
}
