package co.com.mytrello.rest;

import org.springframework.http.ResponseEntity;

public interface TareaRestController {

    ResponseEntity findAll(Long listaId);
}
