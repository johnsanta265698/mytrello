package co.com.mytrello.rest.impl;

import co.com.mytrello.repository.domain.Lista;
import co.com.mytrello.rest.ListaRestController;
import co.com.mytrello.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/listas")
public class ListaRestControllerImpl implements ListaRestController {

    @Autowired
    private ListaService listaService;

    @GetMapping
    @Override
    public ResponseEntity findAll() {
        return ResponseEntity.ok(listaService.findAll());
    }

    @PostMapping
    @Override
    public ResponseEntity save(@Validated @RequestBody Lista lista, BindingResult result) {
        if (!result.hasErrors()){
            return  ResponseEntity.ok(listaService.save(lista));
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("El objeto lista no esta completo");
    }

    @PutMapping
    @Override
    public ResponseEntity update(@Validated @RequestBody Lista lista, BindingResult result) {
        if (!result.hasErrors()){
            return  ResponseEntity.ok(listaService.update(lista));
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("El objeto lista no esta completo");
    }

    @GetMapping("/{listaId}")
    @Override
    public ResponseEntity findById(@PathVariable("listaId") Long id) {
        if (listaService.exists(id)){
            Lista lista = listaService.findById(id);
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("El objeto no existe");
    }

    @DeleteMapping
    @Override
    public ResponseEntity deleteById(Long id) {
        if (listaService.exists(id)){
            listaService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("El objeto no existe");
    }

}
